package asia.gkc.vneedu.model;

import asia.gkc.vneedu.common.BaseModel;

import java.util.Date;
import javax.persistence.*;

@Table(name = "order_item")
public class Order extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    /**
     * 订单创建者ID
     */
    @Column(name = "creator_id")
    private String creatorId;

    /**
     * 需求发起者ID
     */
    @Column(name = "user_id")
    private String userId;

    @Column(name = "requirement_id")
    private String requirementId;

    @Column(name = "order_no")
    private String orderNo;

    private Integer status;

    private Date datetime;

    private String title;

    private String image;

    private String price;

    /**
     * 需求发起者是否已经评价
     */
    @Column(name = "u_judged")
    private Integer uJudged;

    /**
     * 订单创建者是否已经评价
     */
    @Column(name = "c_judged")
    private Integer cJudged;

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
     * 获取订单创建者ID
     *
     * @return creator_id - 订单创建者ID
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 设置订单创建者ID
     *
     * @param creatorId 订单创建者ID
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取需求发起者ID
     *
     * @return user_id - 需求发起者ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置需求发起者ID
     *
     * @param userId 需求发起者ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * @return order_no
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获取需求发起者是否已经评价
     *
     * @return u_judged - 需求发起者是否已经评价
     */
    public Integer getuJudged() {
        return uJudged;
    }

    /**
     * 设置需求发起者是否已经评价
     *
     * @param uJudged 需求发起者是否已经评价
     */
    public void setuJudged(Integer uJudged) {
        this.uJudged = uJudged;
    }

    /**
     * 获取订单创建者是否已经评价
     *
     * @return c_judged - 订单创建者是否已经评价
     */
    public Integer getcJudged() {
        return cJudged;
    }

    /**
     * 设置订单创建者是否已经评价
     *
     * @param cJudged 订单创建者是否已经评价
     */
    public void setcJudged(Integer cJudged) {
        this.cJudged = cJudged;
    }
}