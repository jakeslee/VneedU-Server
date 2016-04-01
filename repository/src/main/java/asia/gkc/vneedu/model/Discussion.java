package asia.gkc.vneedu.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "discussion")
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    private String content;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "requirement_id")
    private String requirementId;

    @Column(name = "receiver_id")
    private String receiverId;

    private Date datetime;

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
     * @return sender_id
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * @param senderId
     */
    public void setSenderId(String senderId) {
        this.senderId = senderId;
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