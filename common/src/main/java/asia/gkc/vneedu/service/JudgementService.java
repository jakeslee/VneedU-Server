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

import asia.gkc.vneedu.model.Judgement;
import asia.gkc.vneedu.model.Order;

import java.util.List;

/**
 * File Name: JudgementService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/12/16 9:28 AM
 */

public interface JudgementService extends IService<Judgement> {
    /**
     * 评价订单
     *
     * @param judgement 评价
     * @param order 订单
     * @return
     */
    boolean judgeOrder(Judgement judgement, Order order);

    /**
     * 获取用户评价
     *
     * @param uid 用户ID
     * @return
     */
    List<Judgement> getJudgementsByUid(String uid);
}
