package asia.gkc.vneedu.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_file")
public class UserFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    @Column(name = "file_id")
    private String fileId;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "uploader_id")
    private String uploaderId;

    private String url;

    private String hash;

    private Date datetime;

    private Integer trashed;

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
     * @return file_id
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * @param fileId
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**
     * @return display_name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return uploader_id
     */
    public String getUploaderId() {
        return uploaderId;
    }

    /**
     * @param uploaderId
     */
    public void setUploaderId(String uploaderId) {
        this.uploaderId = uploaderId;
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

    /**
     * @return hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash
     */
    public void setHash(String hash) {
        this.hash = hash;
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
     * @return trashed
     */
    public Integer getTrashed() {
        return trashed;
    }

    /**
     * @param trashed
     */
    public void setTrashed(Integer trashed) {
        this.trashed = trashed;
    }
}