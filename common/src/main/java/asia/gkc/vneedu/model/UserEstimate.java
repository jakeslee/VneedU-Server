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

@Table(name = "user_estimate")
public class UserEstimate extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户被赞数（可选）
     */
    private Integer nice;

    /**
     * 用户被评价数（可选）
     */
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
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户被赞数（可选）
     *
     * @return nice - 用户被赞数（可选）
     */
    public Integer getNice() {
        return nice;
    }

    /**
     * 设置用户被赞数（可选）
     *
     * @param nice 用户被赞数（可选）
     */
    public void setNice(Integer nice) {
        this.nice = nice;
    }

    /**
     * 获取用户被评价数（可选）
     *
     * @return commented - 用户被评价数（可选）
     */
    public Integer getCommented() {
        return commented;
    }

    /**
     * 设置用户被评价数（可选）
     *
     * @param commented 用户被评价数（可选）
     */
    public void setCommented(Integer commented) {
        this.commented = commented;
    }
}