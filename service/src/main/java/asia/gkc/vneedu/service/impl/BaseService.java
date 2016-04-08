package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.service.IService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * File Name: BaseService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/1/16 5:07 PM
 */

public abstract class BaseService<T> implements IService<T> {
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
}
