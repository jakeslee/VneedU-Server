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
