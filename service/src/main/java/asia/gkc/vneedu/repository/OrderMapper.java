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

package asia.gkc.vneedu.repository;

import asia.gkc.vneedu.model.Order;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    /**
     * 通过用户ID获取订单
     *
     * @param uid 用户ID
     * @param status 状态（-2表示显示所有）
     * @param removed 是否显示移除的（0标识不显示,1标识显示所有）
     * @return
     */
    List<Order> getOrdersByUserId(@Param("uid") String uid,
                                  @Param("status") int status,
                                  @Param("removed") int removed);
}