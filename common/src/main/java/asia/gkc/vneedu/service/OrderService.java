package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.Order;

import java.util.List;

/**
 * File Name: OrderService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/10/16 8:09 PM
 */

public interface OrderService extends IService<Order> {
    /**
     * 通过需求ID创建订单
     *
     * @param reqId 需求ID
     * @param c_id 订单发起者ID
     * @return 创建状态
     */
    boolean createOrderByReqId(String reqId, String c_id);

    /**
     * 通过用户ID获取订单
     *  （所有状态,默认10项每页）
     *
     * @param uid 用户ID
     * @param page 选取页
     * @param removed 是否显示删除
     * @return
     */
    List<Order> getOrdersByUserId(String uid, int page, int removed);

    /**
     * 通过用户ID获取订单（所有状态）
     *
     * @param uid 用户ID
     * @param page 选取页
     * @param limit 每页条目
     * @param removed 是否显示删除
     * @return 订单列表
     */
    List<Order> getOrdersByUserId(String uid, int page, int limit, int removed);

    /**
     * 通过用户ID获取订单
     *
     * @param uid 用户ID
     * @param page 选取页
     * @param limit 每页数
     * @param status 订单状态
     *                0: 订单已提交,等待需求发起方确认
     *                1: 订单已被确认
     *                2: 已完成
     *               -1: 已取消
     *               -2: 所有订单
     * @param removed 是否选取删除
     *                0: 不显示（默认）;
     *                1: 显示
     * @return 订单列表
     */
    List<Order> getOrdersByUserId(String uid, int page, int limit, int status, int removed);
}
