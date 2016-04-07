package asia.gkc.vneedu.service;

import org.springframework.stereotype.Service;

import java.util.List;

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
    int updateObject(T entity);
    int removeByIdWithoutCascadeChecking(String id);

    T getObjectById(String id);

    List<T> selectPage(int pageNumber, int pageSize);
}
