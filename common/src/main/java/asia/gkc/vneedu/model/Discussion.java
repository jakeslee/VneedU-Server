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

import java.util.Date;
import javax.persistence.*;

@Table(name = "discussion")
public class Discussion extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    /**
     * 讨论内容
     */
    private String content;

    /**
     * 发布者
     */
    @Column(name = "sender_id")
    private String senderId;

    /**
     * 需求ID
     */
    @Column(name = "requirement_id")
    private String requirementId;

    /**
     * 发布时间
     */
    private Date datetime;

    /**
     * 是否删除（可选）
     */
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
     * 获取讨论内容
     *
     * @return content - 讨论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置讨论内容
     *
     * @param content 讨论内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取发布者
     *
     * @return sender_id - 发布者
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * 设置发布者
     *
     * @param senderId 发布者
     */
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    /**
     * 获取需求ID
     *
     * @return requirement_id - 需求ID
     */
    public String getRequirementId() {
        return requirementId;
    }

    /**
     * 设置需求ID
     *
     * @param requirementId 需求ID
     */
    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    /**
     * 获取发布时间
     *
     * @return datetime - 发布时间
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * 设置发布时间
     *
     * @param datetime 发布时间
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
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
}