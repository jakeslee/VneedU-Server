package asia.gkc.vneedu.model;

import javax.persistence.*;

@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    private Integer type;

    @Column(name = "target_id")
    private String targetId;

    @Column(name = "receiver_id")
    private String receiverId;

    private String content;

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
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return target_id
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * @param targetId
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    /**
     * @return receiver_id
     */
    public String getReceiverId() {
        return receiverId;
    }

    /**
     * @param receiverId
     */
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
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