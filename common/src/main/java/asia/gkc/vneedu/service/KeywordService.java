package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.Keyword;

/**
 * File Name: KeywordService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/6/16 11:27 AM
 */

public interface KeywordService extends IService<Keyword>  {
    /**
     * 为需求添加关键字
     *
     * @param keywords - 关键字列表
     * @param requirementId - 需求ID
     * @return 成功与否
     */
    boolean addKeywordsToRequirement(String[] keywords, String requirementId);
}
