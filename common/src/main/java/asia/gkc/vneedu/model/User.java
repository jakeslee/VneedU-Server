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
import asia.gkc.vneedu.utils.IdentityUtil;
import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Table(name = "user")
public class User extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(UUID(),'-','')")
    private String id;

    /**
     * 用户唯一ID
     */
    @Column(name = "at_id")
    private String atId;

    /**
     * 用户昵称（可选）
     */
    private String name;

    /**
     * 用户手机号
     */
    @NotBlank
    private String phone;
    /**
     * 用户邮箱（可选）
     */
    private String email;

    /**
     * BCrypt密码
     */
    @Column(name = "password_hash")
    @JSONField(serialize = false, deserialize = false)
    @NotBlank
    private String passwordHash;

    /**
     * 用户积分（可选）
     */
    private Integer score;

    /**
     * 等级（可选）
     */
    private Integer level;

    /**
     * 用户简介（可选）
     */
    private String profile;

    /**
     * 用户头像URL（可选）
     */
    private String avatar;

    /**
     * 用户所在地区（可选）
     */
    private String area;

    /**
     * 用户Token,不记入数据库
     */
    @Transient
    private String token;

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
     * 获取用户唯一ID
     *
     * @return at_id - 用户唯一ID
     */
    public String getAtId() {
        return atId;
    }

    /**
     * 设置用户唯一ID
     *
     * @param atId 用户唯一ID
     */
    public void setAtId(String atId) {
        this.atId = atId;
    }

    /**
     * 获取用户昵称（可选）
     *
     * @return name - 用户昵称（可选）
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户昵称（可选）
     *
     * @param name 用户昵称（可选）
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户手机号
     *
     * @return phone - 用户手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置用户手机号
     *
     * @param phone 用户手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取用户邮箱（可选）
     *
     * @return email - 用户邮箱（可选）
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户邮箱（可选）
     *
     * @param email 用户邮箱（可选）
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取用户积分（可选）
     *
     * @return score - 用户积分（可选）
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置用户积分（可选）
     *
     * @param score 用户积分（可选）
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取等级（可选）
     *
     * @return level - 等级（可选）
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置等级（可选）
     *
     * @param level 等级（可选）
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取用户简介（可选）
     *
     * @return profile - 用户简介（可选）
     */
    public String getProfile() {
        return profile;
    }

    /**
     * 设置用户简介（可选）
     *
     * @param profile 用户简介（可选）
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * 获取用户头像URL（可选）
     *
     * @return avatar - 用户头像URL（可选）
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置用户头像URL（可选）
     *
     * @param avatar 用户头像URL（可选）
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取用户所在地区（可选）
     *
     * @return area - 用户所在地区（可选）
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置用户所在地区（可选）
     *
     * @param area 用户所在地区（可选）
     */
    public void setArea(String area) {
        this.area = area;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * 通过原始密码设置加密密码
     *
     * @param password - 原始密码
     */
    public void setPassword(String password) {
        passwordHash = IdentityUtil.generate_hash(password);
    }

    /**
     * 验证密码是否正确
     *
     * @param password - 用于验证的密码
     * @return
     */
    public boolean verify_password(String password) {
        return IdentityUtil.verify_password(passwordHash, password);
    }
}