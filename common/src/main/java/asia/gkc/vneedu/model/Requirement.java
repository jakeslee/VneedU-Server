/*
 * Copyright 2016 Jakes Lee
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package asia.gkc.vneedu.model;

import asia.gkc.vneedu.common.BaseModel;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;

@Table(name = "requirement")
public class Requirement extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    /**
     * 需求标题
     */
    @NotBlank
    private String title;

    /**
     * 发布者
     */
    @Column(name = "publisher_id")
    private String publisherId;

    /**
     * 发布日期
     */
    private Date datetime;

    /**
     * 需求主图，图片URL路径（可选）
     */
    private String image;

    /**
     * 需求地址
     */
    @NotBlank
    private String address;

    /**
     * 需求价格
     */
    @Min(value = 0)
    private Integer price;

    /**
     * 支付方式
     */
    @Column(name = "pay_method")
    @Min(value = 0)
    private Integer payMethod;

    /**
     * 赞（可选）
     */
    private Integer nice;

    /**
     * 交易状态（可选）
     */
    @Column(name = "trade_status")
    private Integer tradeStatus;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 是否删除（可选）
     */
    private Integer removed;

    /**
     * 需求地区
     */
    @NotBlank
    private String area;

    /**
     * 需求描述（可选）
     */
    private String description;

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
     * 获取需求标题
     *
     * @return title - 需求标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置需求标题
     *
     * @param title 需求标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取发布者
     *
     * @return publisher_id - 发布者
     */
    public String getPublisherId() {
        return publisherId;
    }

    /**
     * 设置发布者
     *
     * @param publisherId 发布者
     */
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    /**
     * 获取发布日期
     *
     * @return datetime - 发布日期
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * 设置发布日期
     *
     * @param datetime 发布日期
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    /**
     * 获取需求主图，图片URL路径（可选）
     *
     * @return image - 需求主图，图片URL路径（可选）
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置需求主图，图片URL路径（可选）
     *
     * @param image 需求主图，图片URL路径（可选）
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取需求地址
     *
     * @return address - 需求地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置需求地址
     *
     * @param address 需求地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取需求价格
     *
     * @return price - 需求价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置需求价格
     *
     * @param price 需求价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取支付方式
     *
     * @return pay_method - 支付方式
     */
    public Integer getPayMethod() {
        return payMethod;
    }

    /**
     * 设置支付方式
     *
     * @param payMethod 支付方式
     */
    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * 获取赞（可选）
     *
     * @return nice - 赞（可选）
     */
    public Integer getNice() {
        return nice;
    }

    /**
     * 设置赞（可选）
     *
     * @param nice 赞（可选）
     */
    public void setNice(Integer nice) {
        this.nice = nice;
    }

    /**
     * 获取交易状态（可选）
     *
     * @return trade_status - 交易状态（可选）
     */
    public Integer getTradeStatus() {
        return tradeStatus;
    }

    /**
     * 设置交易状态（可选）
     *
     * @param tradeStatus 交易状态（可选）
     */
    public void setTradeStatus(Integer tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    /**
     * 获取分类ID
     *
     * @return category_id - 分类ID
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类ID
     *
     * @param categoryId 分类ID
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取是否删除（可选）
     *
     * @return removed - 是否删除（可选）
     */
    public Integer getRemoved() {
        return removed;
    }

    /**
     * 设置是否删除（可选）
     *
     * @param removed 是否删除（可选）
     */
    public void setRemoved(Integer removed) {
        this.removed = removed;
    }

    /**
     * 获取需求地区
     *
     * @return area - 需求地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置需求地区
     *
     * @param area 需求地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取需求描述（可选）
     *
     * @return description - 需求描述（可选）
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置需求描述（可选）
     *
     * @param description 需求描述（可选）
     */
    public void setdescription(String description) {
        this.description = description;
    }
}