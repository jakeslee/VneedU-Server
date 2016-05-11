package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.common.QueryCondition;
import asia.gkc.vneedu.model.Order;
import asia.gkc.vneedu.model.Requirement;
import asia.gkc.vneedu.model.User;
import asia.gkc.vneedu.service.OrderService;
import asia.gkc.vneedu.utils.BeanUtil;
import asia.gkc.vneedu.utils.FilterUtil;
import asia.gkc.vneedu.utils.GenerationUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * File Name: OrderServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/10/16 8:11 PM
 */
@Service
public class OrderServiceImpl extends BaseService<Order> implements OrderService {
    /**
     * 通过需求ID创建订单
     *
     * @param reqId 需求ID
     * @param c_id  订单发起者ID
     * @return 创建状态
     */
    @Override
    public boolean createOrderByReqId(String reqId, String c_id) {
        Requirement requirement = requirementMapper.selectByPrimaryKey(reqId);
        if (requirement == null)
            return false;

        Date now = Calendar.getInstance().getTime();
        Order order = new Order();

        order.setCreatorId(c_id);
        order.setRequirementId(reqId);
        order.setImage(requirement.getImage());
        order.setTitle(requirement.getTitle());
        order.setPrice(requirement.getPrice().toString());
        order.setUserId(requirement.getPublisherId());
        order.setOrderNo(GenerationUtil.generateOrderNo(now));
        order.setDatetime(now);

        orderMapper.insertSelective(order);

        // 锁定需求
        requirement.setTradeStatus(1);
        requirementMapper.updateByPrimaryKeySelective(requirement);

        return true;
    }

    /**
     * 通过用户ID获取订单
     * （所有状态,默认10项每页）
     *
     * @param uid     用户ID
     * @param page    选取页
     * @param removed 是否显示删除
     * @return
     */
    @Override
    public List<Order> getOrdersByUserId(String uid, int page, int removed) {
        return getOrdersByUserId(uid, page, 10, removed);
    }

    /**
     * 通过用户ID获取订单（所有状态）
     *
     * @param uid     用户ID
     * @param page    选取页
     * @param limit   每页条目
     * @param removed 是否显示删除
     * @return 订单列表
     */
    @Override
    public List<Order> getOrdersByUserId(String uid, int page, int limit, int removed) {
        return getOrdersByUserId(uid, page, limit, -2, removed);
    }

    /**
     * 通过用户ID获取订单
     *
     * @param uid     用户ID
     * @param page    选取页
     * @param limit   每页数
     * @param status  订单状态
     *                0: 订单已提交,等待需求发起方确认
     *                1: 订单已被确认
     *                2: 已完成
     *                -1: 已取消
     *                -2: 所有订单
     * @param removed 是否选取删除
     *                0: 不显示（默认）;
     *                1: 显示
     * @return 订单列表
     */
    @Override
    public List<Order> getOrdersByUserId(String uid, int page, int limit, int status, int removed) {

        PageHelper.startPage(page, limit);
        return orderMapper.getOrdersByUserId(uid, status, removed);
    }

    /**
     * 查询处理
     *
     * @param list           - 用于处理的数据
     * @param queryCondition - 处理操作
     * @return 处理后的内容
     */
    @Override
    public List<Map<String, Object>> queryProcess(List<Order> list, QueryCondition queryCondition) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (Order item: list) {
            Map<String, Object> map = BeanUtil.beanToMap(item, Order.class);

            for (String expand: queryCondition.getExpand()) {
                switch (expand.toLowerCase().trim()) {
                    case "creator":
                        User creator = userMapper.selectByPrimaryKey(item.getCreatorId());
                        map.put("creator", creator);
                        break;
                    case "user":
                        User user = userMapper.selectByPrimaryKey(item.getUserId());
                        logger.debug(user.getName());
                        map.put("user", user);
                        break;
                    case "requirement":
                        Requirement requirement = requirementMapper.selectByPrimaryKey(item.getRequirementId());
                        map.put("requirement", requirement);
                        break;
                }
            }
            map = FilterUtil.exclude(Arrays.asList(queryCondition.getExclude()), map);
            result.add(map);
        }
        return result;
    }
}
