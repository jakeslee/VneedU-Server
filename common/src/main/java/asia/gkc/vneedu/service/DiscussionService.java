package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.Discussion;

import java.util.List;

/**
 * File Name: DiscussionService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/10/16 4:52 PM
 */

public interface DiscussionService extends IService<Discussion> {
    /**
     * 通过需求ID获取讨论列表
     *
     * @param ReqId 需求ID
     * @return 讨论列表
     */
    List<Discussion> getDiscussionsByReqId(String ReqId);
}
