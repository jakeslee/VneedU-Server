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

@Table(name = "judgement")
public class Judgement extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    /**
     * 评价内容
     */
    private String content;

    /**
     * 需求ID
     */
    @Column(name = "requirement_id")
    private String requirementId;

    /**
     * 评价人ID
     */
    @Column(name = "judge_id")
    private String judgeId;

    /**
     * 被评价人ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 评价时间
     */
    private Date datetime;

    /**
     * 是否需求发起者（可选）
     */
    @Column(name = "is_req_creator")
    private Integer isReqCreator;

    /**
     * 评分（可选）
     */
    private Integer score;

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
     * 获取评价内容
     *
     * @return content - 评价内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评价内容
     *
     * @param content 评价内容
     */
    public void setContent(String content) {
        this.content = content;
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
     * 获取评价人ID
     *
     * @return judge_id - 评价人ID
     */
    public String getJudgeId() {
        return judgeId;
    }

    /**
     * 设置评价人ID
     *
     * @param judgeId 评价人ID
     */
    public void setJudgeId(String judgeId) {
        this.judgeId = judgeId;
    }

    /**
     * 获取被评价人ID
     *
     * @return user_id - 被评价人ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置被评价人ID
     *
     * @param userId 被评价人ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取评价时间
     *
     * @return datetime - 评价时间
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * 设置评价时间
     *
     * @param datetime 评价时间
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    /**
     * 获取是否需求发起者（可选）
     *
     * @return is_req_creator - 是否需求发起者（可选）
     */
    public Integer getIsReqCreator() {
        return isReqCreator;
    }

    /**
     * 设置是否需求发起者（可选）
     *
     * @param isReqCreator 是否需求发起者（可选）
     */
    public void setIsReqCreator(Integer isReqCreator) {
        this.isReqCreator = isReqCreator;
    }

    /**
     * 获取评分（可选）
     *
     * @return score - 评分（可选）
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置评分（可选）
     *
     * @param score 评分（可选）
     */
    public void setScore(Integer score) {
        this.score = score;
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