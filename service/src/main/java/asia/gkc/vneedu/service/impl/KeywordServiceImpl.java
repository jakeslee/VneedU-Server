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

import asia.gkc.vneedu.model.Keyword;
import asia.gkc.vneedu.repository.KeywordMapper;
import asia.gkc.vneedu.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * File Name: KeywordServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/6/16 11:30 AM
 */

@Service
public class KeywordServiceImpl extends BaseService<Keyword> implements KeywordService {
    @Autowired
    KeywordMapper keywordMapper;

    /**
     * 为需求添加关键字
     *
     * @param keywords      - 关键字列表
     * @param requirementId - 需求ID
     * @return 成功与否
     */
    @Override
    public boolean addKeywordsToRequirement(String[] keywords, String requirementId) {
        Keyword k;
        for (String keyword : keywords) {
            k = new Keyword();
            k.setKeyword(keyword.trim());
            k.setRequirementId(requirementId);
            keywordMapper.insertSelective(k);
        }

        return true;
    }
}
