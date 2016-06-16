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

package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.model.Category;
import asia.gkc.vneedu.service.CategoryService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * File Name: CategoryService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 3/29/16 6:15 PM
 */
@Service
public class CategoryServiceImpl
        extends BaseService<Category>
        implements CategoryService {
    /**
     * 通过分类值获取分类
     *
     * @param type 分类值
     * @return 分类
     */
    @Override
    public Category getCategoryByType(String type) {
        return categoryMapper.getCategoryByType(type);
    }
}
