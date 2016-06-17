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
import asia.gkc.vneedu.model.Discussion;
import asia.gkc.vneedu.model.User;
import asia.gkc.vneedu.service.DiscussionService;
import asia.gkc.vneedu.utils.BeanUtil;
import asia.gkc.vneedu.utils.FilterUtil;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * File Name: DiscussionServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/10/16 4:55 PM
 */
@Service
public class DiscussionServiceImpl extends BaseService<Discussion> implements DiscussionService {
    /**
     * 通过需求ID获取讨论列表
     *
     * @param ReqId 需求ID
     * @return 讨论列表
     */
    @Override
    public List<Discussion> getDiscussionsByReqId(String ReqId) {
        Example example = new Example(Discussion.class);
        example.createCriteria().andEqualTo("requirementId", ReqId);
        return discussionMapper.selectByExample(example);
    }

    /**
     * 查询处理
     *
     * @param list           - 用于处理的数据
     * @param queryCondition - 处理操作
     * @return 处理后的内容
     */
    @Override
    public List<Map<String, Object>> queryProcess(List<Discussion> list, QueryCondition queryCondition) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (Discussion item: list) {
            Map<String, Object> map = BeanUtil.beanToMap(item, Discussion.class);

            for (String expand: queryCondition.getExpand()) {
                switch (expand.toLowerCase().trim()) {
                    case "sender":
                        User sender = userMapper.selectByPrimaryKey(item.getSenderId());
                        map.put("sender", sender);
                        break;
                }
            }
            map = FilterUtil.exclude(Arrays.asList(queryCondition.getExclude()), map);
            result.add(map);
        }
        return result;
    }
}
