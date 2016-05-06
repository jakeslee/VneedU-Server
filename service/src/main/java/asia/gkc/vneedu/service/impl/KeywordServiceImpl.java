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
            k.setKeyword(keyword);
            k.setRequirementId(requirementId);
            keywordMapper.insertSelective(k);
        }

        return true;
    }
}
