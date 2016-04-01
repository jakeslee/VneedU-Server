package asia.gkc.vneedu.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "requirement")
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    private String title;

    @Column(name = "publisher_id")
    private String publisherId;

    private Date datetime;

    private String image;

    private String address;

    private Integer price;

    @Column(name = "pay_method")
    private Integer payMethod;

    private Integer nice;

    @Column(name = "trade_status")
    private Integer tradeStatus;

    @Column(name = "category_id")
    private String categoryId;

    private Integer removed;

    private String desciption;

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
     * @return publisher_id
     */
    public String getPublisherId() {
        return publisherId;
    }

    /**
     * @param publisherId
     */
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
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
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return pay_method
     */
    public Integer getPayMethod() {
        return payMethod;
    }

    /**
     * @param payMethod
     */
    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
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
     * @return trade_status
     */
    public Integer getTradeStatus() {
        return tradeStatus;
    }

    /**
     * @param tradeStatus
     */
    public void setTradeStatus(Integer tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    /**
     * @return category_id
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    /**
     * @return desciption
     */
    public String getDesciption() {
        return desciption;
    }

    /**
     * @param desciption
     */
    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}