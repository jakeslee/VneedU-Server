package asia.gkc.vneedu.controller.api.v1_0;

import asia.gkc.vneedu.authorization.annotation.ActiveUser;
import asia.gkc.vneedu.authorization.annotation.RequireLogin;
import asia.gkc.vneedu.common.QueryCondition;
import asia.gkc.vneedu.common.ResultModel;
import asia.gkc.vneedu.common.ResultStatus;
import asia.gkc.vneedu.controller.core.BaseController;
import asia.gkc.vneedu.model.Order;
import asia.gkc.vneedu.model.User;
import com.github.pagehelper.PageInfo;
import com.qiniu.util.StringMap;
import org.springframework.web.bind.annotation.*;

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
}
