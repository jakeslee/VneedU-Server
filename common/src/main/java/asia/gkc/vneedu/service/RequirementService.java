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

package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.Requirement;

import java.util.List;

/**
 * File Name: RequirementService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/8/16 10:32 AM
 */

public interface RequirementService extends IService<Requirement> {
    /**
     * 增加需求
     *
     * @param requirement - 需求模型
     * @param userFiles - 用户文件ID
     * @return 创建的需求
     */
    Requirement addRequirementWithFiles(Requirement requirement, String[] userFiles);

    /**
     * 增加需求
     *
     * @param requirement - 需求模型
     * @param userFiles - 用户文件ID
     * @param category - 分类值
     * @return 创建的需求
     */
    Requirement addRequirementWithFiles(Requirement requirement, String[] userFiles, String category);

    /**
     * 获取分类最新需求列表
     * 默认每页10条
     *
     * @param category 分类
     *                 latest表示所有分类
     * @param page 页码
     * @param removed 是否显示已删除内容
     *                0: 不显示（默认）;
     *                1: 显示
     * @return 需求列表
     */
    List<Requirement> getLatestRequirements(String category, int page, int removed);

    /**
     * 获取分类最新需求列表
     *
     * @param category 分类
     *                 latest表示所有分类
     * @param page 页码
     * @param limit 每页条数
     * @param removed 是否显示已删除内容
     *                0: 不显示（默认）;
     *                1: 显示
     * @param status 选择订单状态
     *               0: opened(default)
     *               1: locked
     *               -1: closed
     *               -2: all
     * @return 需求列表
     */
    List<Requirement> getLatestRequirements(
            String category, int page, int limit, int removed, int status);

    /**
     * 赞
     *
     * @param requirement 被赞需求
     * @return
     */
    int raceUp(Requirement requirement);

    /**
     * 通过用户ID获取需求
     *
     * @param uid 用户ID
     * @return 需求列表
     */
    List<Requirement> getRequirementsByUid(String uid);
}
