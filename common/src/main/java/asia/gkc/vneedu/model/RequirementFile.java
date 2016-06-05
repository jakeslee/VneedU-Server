package asia.gkc.vneedu.model;

import javax.persistence.*;

@Table(name = "requirement_file")
public class RequirementFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    @Column(name = "user_file_id")
    private String userFileId;

    private String mime;

    @Column(name = "requirement_id")
    private String requirementId;

    private String url;

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
     * @return user_file_id
     */
    public String getUserFileId() {
        return userFileId;
    }

    /**
     * @param userFileId
     */
    public void setUserFileId(String userFileId) {
        this.userFileId = userFileId;
    }

    /**
     * @return mime
     */
    public String getMime() {
        return mime;
    }

    /**
     * @param mime
     */
    public void setMime(String mime) {
        this.mime = mime;
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
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}