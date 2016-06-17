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

import javax.persistence.*;

@Table(name = "notification")
public class Notification extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 关联类型ID（可选）
     */
    @Column(name = "target_id")
    private String targetId;

    /**
     * 接收者ID
     */
    @Column(name = "receiver_id")
    private String receiverId;

    /**
     * 通知内容（可选）
     */
    private String content;

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
     * 获取消息类型
     *
     * @return type - 消息类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置消息类型
     *
     * @param type 消息类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取关联类型ID（可选）
     *
     * @return target_id - 关联类型ID（可选）
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * 设置关联类型ID（可选）
     *
     * @param targetId 关联类型ID（可选）
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    /**
     * 获取接收者ID
     *
     * @return receiver_id - 接收者ID
     */
    public String getReceiverId() {
        return receiverId;
    }

    /**
     * 设置接收者ID
     *
     * @param receiverId 接收者ID
     */
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    /**
     * 获取通知内容（可选）
     *
     * @return content - 通知内容（可选）
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置通知内容（可选）
     *
     * @param content 通知内容（可选）
     */
    public void setContent(String content) {
        this.content = content;
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