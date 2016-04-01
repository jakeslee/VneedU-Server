package asia.gkc.vneedu.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "judgement")
public class Judgement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    private String content;

    @Column(name = "requirement_id")
    private String requirementId;

    @Column(name = "judge_id")
    private String judgeId;

    @Column(name = "user_id")
    private String userId;

    private Date datetime;

    @Column(name = "is_req_creator")
    private Integer isReqCreator;

    private Integer score;

    private Integer removed;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return requirement_id
     */
    public String getRequirementId() {
        return requirementId;
    }

    /**
     * @param requirementId
     */
    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    /**
     * @return judge_id
     */
    public String getJudgeId() {
        return judgeId;
    }

    /**
     * @param judgeId
     */
    public void setJudgeId(String judgeId) {
        this.judgeId = judgeId;
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return datetime
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * @param datetime
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    /**
     * @return is_req_creator
     */
    public Integer getIsReqCreator() {
        return isReqCreator;
    }

    /**
     * @param isReqCreator
     */
    public void setIsReqCreator(Integer isReqCreator) {
        this.isReqCreator = isReqCreator;
    }

    /**
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return removed
     */
    public Integer getRemoved() {
        return removed;
    }

    /**
     * @param removed
     */
    public void setRemoved(Integer removed) {
        this.removed = removed;
    }
}