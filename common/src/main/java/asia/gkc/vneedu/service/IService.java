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

import asia.gkc.vneedu.common.QueryCondition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * File Name: IService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/1/16 4:59 PM
 */
@Service
public interface IService<T> {
    int addObject(T entity);
    int addObjectWithoutNull(T entity);

    int updateObject(T entity);
    int updateObjectWithoutNull(T entity);

    int removeByIdWithoutCascadeChecking(String id);

    T getObjectById(String id);

    List<T> selectPage(int pageNumber, int pageSize);

    /**
     * 查询处理
     *
     * @param list - 用于处理的数据
     * @param queryCondition - 处理操作
     * @return 处理后的内容
     */
    List<Map<String, Object>> queryProcess(List<T> list, QueryCondition queryCondition);
}
