package asia.gkc.vneedu.model;

import javax.persistence.*;

@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    private String hash;

    private String location;

    private String filename;

    private String mime;

    private Long size;

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
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
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
     * @return size
     */
    public Long getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(Long size) {
        this.size = size;
    }
}