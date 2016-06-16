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

import asia.gkc.vneedu.common.QueryCondition;
import asia.gkc.vneedu.repository.*;
import asia.gkc.vneedu.service.IService;
import asia.gkc.vneedu.utils.BeanUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * File Name: BaseService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/1/16 5:07 PM
 */

public abstract class BaseService<T> implements IService<T> {
    /**
     * 注入DAO Mapper
     */
    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected CategoryMapper categoryMapper;
    @Autowired
    protected RequirementMapper requirementMapper;
    @Autowired
    protected RequirementFileMapper requirementFileMapper;
    @Autowired
    protected DiscussionMapper discussionMapper;
    @Autowired
    protected KeywordMapper keywordMapper;
    @Autowired
    protected OrderMapper orderMapper;
    @Autowired
    protected JudgementMapper judgementMapper;

    @Autowired
    protected Mapper<T> repository;

    protected Log logger = LogFactory.getLog(this.getClass());

    @Override
    public int addObject(T entity) {
        return repository.insert(entity);
    }

    @Override
    public int addObjectWithoutNull(T entity) {
        return repository.insertSelective(entity);
    }

    @Override
    public int updateObject(T entity) {
        return repository.updateByPrimaryKey(entity);
    }

    @Override
    public int updateObjectWithoutNull(T entity) {
        return repository.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int removeByIdWithoutCascadeChecking(String id) {
        return repository.deleteByPrimaryKey(id);
    }

    @Override
    public T getObjectById(String id) {
        logger.debug(id);
        return repository.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectPage(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return repository.select(null);
    }

    /**
     * 查询处理
     *
     * @param list           - 用于处理的数据
     * @param queryCondition - 处理操作
     * @return 处理后的内容
     */
    @Override
    public List<Map<String, Object>> queryProcess(List<T> list, QueryCondition queryCondition) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (T item: list) {
            Map<String, Object> map = BeanUtil.beanToMap(item, item.getClass());
            result.add(map);
        }
        return result;
    }
}
