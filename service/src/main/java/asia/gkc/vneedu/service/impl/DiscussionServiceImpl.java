package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.model.Discussion;
import asia.gkc.vneedu.service.DiscussionService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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
}
