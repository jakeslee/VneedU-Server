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

import asia.gkc.vneedu.model.Category;

/**
 * File Name: CategoryService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/1/16 4:28 PM
 */

public interface CategoryService extends IService<Category> {
    /**
     * 通过分类值获取分类
     *
     * @param type 分类值
     * @return 分类
     */
    Category getCategoryByType(String type);
}
