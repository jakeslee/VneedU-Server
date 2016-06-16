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

package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.common.QueryCondition;
import asia.gkc.vneedu.model.Judgement;
import asia.gkc.vneedu.model.Order;
import asia.gkc.vneedu.model.User;
import asia.gkc.vneedu.service.JudgementService;
import asia.gkc.vneedu.utils.BeanUtil;
import asia.gkc.vneedu.utils.FilterUtil;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * File Name: JudgementServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/12/16 9:29 AM
 */

@Service
public class JudgementServiceImpl extends BaseService<Judgement> implements JudgementService {
    /**
     * 评价订单
     *
     * @param judgement 评价
     * @param order 订单
     * @return
     */
    @Override
    public boolean judgeOrder(Judgement judgement, Order order) {
        judgementMapper.insertSelective(judgement);
        orderMapper.updateByPrimaryKeySelective(order);
        return false;
    }

    /**
     * 获取用户评价
     *
     * @param uid 用户ID
     * @return
     */
    @Override
    public List<Judgement> getJudgementsByUid(String uid) {
        Example example = new Example(Judgement.class);
        example.createCriteria().andEqualTo("userId", uid);

        return judgementMapper.selectByExample(example);
    }

    /**
     * 查询处理
     *
     * @param list           - 用于处理的数据
     * @param queryCondition - 处理操作
     * @return 处理后的内容
     */
    @Override
    public List<Map<String, Object>> queryProcess(List<Judgement> list, QueryCondition queryCondition) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (Judgement item: list) {
            Map<String, Object> map = BeanUtil.beanToMap(item, Judgement.class);
            User user = userMapper.selectByPrimaryKey(item.getJudgeId());
            for (String expand : queryCondition.getExpand()) {
                switch (expand.toLowerCase().trim()) {
                    case "mask_name":
                        map.put("mask_name", String.format("****%s", user.getPhone().substring(6)));
                        break;
                    case "avatar":
                        map.put("avatar", user.getAvatar());
                        break;
                }
            }
            map = FilterUtil.exclude(Arrays.asList(queryCondition.getExclude()), map);
            result.add(map);
        }
        return result;
    }
}
