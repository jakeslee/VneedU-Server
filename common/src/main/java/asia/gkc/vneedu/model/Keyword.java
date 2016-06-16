package asia.gkc.vneedu.model;

import asia.gkc.vneedu.common.BaseModel;

import javax.persistence.*;

@Table(name = "keyword")
public class Keyword extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 关联需求
     */
    @Column(name = "requirement_id")
    private String requirementId;

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
     * 获取关键字
     *
     * @return keyword - 关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 设置关键字
     *
     * @param keyword 关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * 获取关联需求
     *
     * @return requirement_id - 关联需求
     */
    public String getRequirementId() {
        return requirementId;
    }

    /**
     * 设置关联需求
     *
     * @param requirementId 关联需求
     */
    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }
}