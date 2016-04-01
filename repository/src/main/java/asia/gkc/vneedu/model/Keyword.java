package asia.gkc.vneedu.model;

import javax.persistence.*;

@Table(name = "keyword")
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    private String key;

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
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
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
}