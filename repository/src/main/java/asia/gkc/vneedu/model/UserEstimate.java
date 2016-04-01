package asia.gkc.vneedu.model;

import javax.persistence.*;

@Table(name = "user_estimate")
public class UserEstimate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    @Column(name = "user_id")
    private String userId;

    private Integer nice;

    private Integer commented;

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
     * @return nice
     */
    public Integer getNice() {
        return nice;
    }

    /**
     * @param nice
     */
    public void setNice(Integer nice) {
        this.nice = nice;
    }

    /**
     * @return commented
     */
    public Integer getCommented() {
        return commented;
    }

    /**
     * @param commented
     */
    public void setCommented(Integer commented) {
        this.commented = commented;
    }
}