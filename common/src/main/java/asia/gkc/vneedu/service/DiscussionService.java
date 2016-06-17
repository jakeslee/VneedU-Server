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

import asia.gkc.vneedu.model.Discussion;

import java.util.List;

/**
 * File Name: DiscussionService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/10/16 4:52 PM
 */

public interface DiscussionService extends IService<Discussion> {
    /**
     * 通过需求ID获取讨论列表
     *
     * @param ReqId 需求ID
     * @return 讨论列表
     */
    List<Discussion> getDiscussionsByReqId(String ReqId);
}
