package asia.gkc.vneedu.controller.api.v1_0;

import asia.gkc.vneedu.authorization.annotation.ActiveUser;
import asia.gkc.vneedu.authorization.annotation.RequireLogin;
import asia.gkc.vneedu.common.QueryCondition;
import asia.gkc.vneedu.common.ResultModel;
import asia.gkc.vneedu.common.ResultStatus;
import asia.gkc.vneedu.controller.core.BaseController;
import asia.gkc.vneedu.model.Judgement;
import asia.gkc.vneedu.model.Order;
import asia.gkc.vneedu.model.User;
import com.github.pagehelper.PageInfo;
import com.qiniu.util.StringMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * File Name: OrderController.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/10/16 7:50 PM
 */
@RestController
@RequestMapping(value = "/api/v1.0")
public class OrderController extends BaseController {
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @RequireLogin
    public ResultModel addNewOrder(@RequestParam(value = "rid") String reqId, @ActiveUser User user) {
        if (user == null)
            return ResultModel.ERROR(ResultStatus.AUTHORIZATION_TOKEN_ERROR);

        if (!orderService.createOrderByReqId(reqId, user.getId()))
            return ResultModel.ERROR(ResultStatus.ERROR_IN_SAVING);
        return ResultModel.OK();
    }

    @RequestMapping(value = "/orders/{uid}", method = RequestMethod.GET)
    @RequireLogin
    public ResultModel getOrders(@PathVariable("uid") String uid,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "exclude", defaultValue = "") String exclude,
                                 @RequestParam(value = "expand", defaultValue = "") String expand,
                                 @RequestParam(value = "limit", defaultValue = "10") int limit,
                                 @RequestParam(value = "withremoved", defaultValue = "0") int withRemoved,
                                 @RequestParam(value = "status", defaultValue = "-2") int status,
                                 @ActiveUser User user) {

        if (user == null)
            return ResultModel.ERROR(ResultStatus.AUTHORIZATION_TOKEN_ERROR);

        if (!user.getId().equals(uid))
            return ResultModel.ERROR(ResultStatus.PERMISSION_DENIED);

        List<Order> orderList = orderService.getOrdersByUserId(uid, page, limit, status, withRemoved);

        PageInfo pageInfo = new PageInfo<>(orderList);

        return ResultModel.SUCCESS(new StringMap()
                .put("orders",
                        orderService.queryProcess(orderList, new QueryCondition(exclude, expand)))
                .put("page", new StringMap()
                        .put("page", page)
                        .put("limit", pageInfo.getSize())
                        .put("max_pages", pageInfo.getPages())
                        .map())
                .map());
    }

    @RequestMapping(value = "/order/{oid}", method = RequestMethod.GET)
    @RequireLogin
    public ResultModel getOrder(@PathVariable("oid") String oid,
                                @RequestParam(value = "exclude", defaultValue = "") String exclude,
                                @RequestParam(value = "expand", defaultValue = "") String expand,
                                @ActiveUser User user) {
        Order order = orderService.getObjectById(oid);

        if (order == null)
            return ResultModel.ERROR(ResultStatus.RESOURCE_NOT_FOUND);

        if (!order.getCreatorId().equals(user.getId()) && !order.getUserId().equals(user.getId()))
            return ResultModel.ERROR(ResultStatus.OPERATION_DENIED);

        return ResultModel.SUCCESS(new StringMap()
                .put("order", orderService.queryProcess(Arrays.asList(order),
                        new QueryCondition(exclude, expand)).get(0))
                .map());
    }

    @RequestMapping(value = "/order/cancel/{oid}", method = RequestMethod.PUT)
    @RequireLogin
    public ResultModel cancelOrder(@PathVariable("oid") String oid,
                                   @RequestParam(value = "exclude", defaultValue = "") String exclude,
                                   @RequestParam(value = "expand", defaultValue = "") String expand,
                                   @ActiveUser User user) {
        Order order = orderService.getObjectById(oid);

        if (order == null)
            return ResultModel.ERROR(ResultStatus.RESOURCE_NOT_FOUND);

        if (!order.getCreatorId().equals(user.getId()))
            return ResultModel.ERROR(ResultStatus.OPERATION_DENIED);

        if (order.getStatus() != 0)
            return ResultModel.ERROR(ResultStatus.STATUS_ERROR);

        orderService.cancelOrder(order);

        return ResultModel.OK();
    }

    @RequestMapping(value = "/order/check/{oid}", method = RequestMethod.PUT)
    @RequireLogin
    public ResultModel checkOrder(@PathVariable("oid") String oid,
                                  @RequestParam(value = "exclude", defaultValue = "") String exclude,
                                  @RequestParam(value = "expand", defaultValue = "") String expand,
                                  @ActiveUser User user) {
        Order order = orderService.getObjectById(oid);

        if (order == null)
            return ResultModel.ERROR(ResultStatus.RESOURCE_NOT_FOUND);

        if (!order.getUserId().equals(user.getId()))
            return ResultModel.ERROR(ResultStatus.OPERATION_DENIED);

        if (order.getStatus() != 0)
            return ResultModel.ERROR(ResultStatus.STATUS_ERROR);

        orderService.checkOrder(order);

        return ResultModel.OK();
    }

    @RequestMapping(value = "/order/finished/{oid}", method = RequestMethod.PUT)
    @RequireLogin
    public ResultModel finishOrder(@PathVariable("oid") String oid,
                                   @RequestParam(value = "exclude", defaultValue = "") String exclude,
                                   @RequestParam(value = "expand", defaultValue = "") String expand,
                                   @ActiveUser User user) {
        Order order = orderService.getObjectById(oid);

        if (order == null)
            return ResultModel.ERROR(ResultStatus.RESOURCE_NOT_FOUND);

        if (!order.getUserId().equals(user.getId()))
            return ResultModel.ERROR(ResultStatus.OPERATION_DENIED);

        if (order.getStatus() != 1)
            return ResultModel.ERROR(ResultStatus.STATUS_ERROR);

        orderService.finishOrder(order);

        return ResultModel.OK();
    }

    @RequestMapping(value = "/order/judgement/{oid}", method = RequestMethod.POST)
    @RequireLogin
    public ResultModel judgement(@PathVariable("oid") String oid,
                                 @RequestParam(value = "content") String content,
                                 @RequestParam(value = "score", defaultValue = "5") int score,
                                 @ActiveUser User user) {

        if (StringUtils.isEmpty(content) || content.length() < 2)
            return ResultModel.ERROR(ResultStatus.BAD_REQUEST);

        Order order = orderService.getObjectById(oid);

        if (order == null)
            return ResultModel.ERROR(ResultStatus.RESOURCE_NOT_FOUND);

        boolean ifOrderCreator = true;

        if (order.getUserId().equals(user.getId()))
            ifOrderCreator = false;

        // 如果不是创建者,且不是需求发起者则表明没有权限操作
        if (!order.getCreatorId().equals(user.getId()) && ifOrderCreator)
            return ResultModel.ERROR(ResultStatus.OPERATION_DENIED);

        if (ifOrderCreator && order.getcJudged() != 0 || !ifOrderCreator && order.getuJudged() != 0)
            return ResultModel.ERROR(ResultStatus.REPETITIVE_OPERATION);

        Judgement judgement = new Judgement();
        judgement.setContent(content);
        judgement.setRequirementId(order.getRequirementId());
        judgement.setDatetime(Calendar.getInstance().getTime());
        judgement.setScore(score > 5 || score < 0 ? 5 : score);
        judgement.setUserId(ifOrderCreator ? order.getUserId() : order.getCreatorId());
        judgement.setIsReqCreator(ifOrderCreator ? 0 : 1);
        judgement.setJudgeId(user.getId());

        if (ifOrderCreator)
            order.setcJudged(1);
        else
            order.setuJudged(1);

        try {
            judgementService.judgeOrder(judgement, order);
            return ResultModel.OK();
        } catch (Exception e) {
            return ResultModel.ERROR(ResultStatus.ERROR_IN_SAVING);
        }
    }
}
