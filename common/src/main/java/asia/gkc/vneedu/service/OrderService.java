/*
 * Copyright 2016 Jakes Lee
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    /**
     * 确认订单
     *
     * @param order 订单
     * @return
     */
    int checkOrder(Order order);

    /**
     * 取消订单
     *
     * @param order 订单
     * @return
     */
    int cancelOrder(Order order);

    /**
     * 完成订单
     *
     * @param order 订单
     * @return
     */
    int finishOrder(Order order);
}
