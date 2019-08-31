package com.shop.shopstore.service.base;

import com.shop.shopstore.mapper.base.BaseMapper;
import com.shop.shopstore.model.base.BaseEntity;
import com.shop.shopstore.obj.PageObj;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Long on 2019/4/4.
 */
public class BaseService<M extends BaseMapper<T>, T extends BaseEntity> {

    @Autowired
    protected M mapper;

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public T get(String id) {
        return mapper.get(id);
    }

    @Transactional(readOnly = false)
    public Page<T> query(PageObj pageObj, T entity) throws Exception {
        Page<T> page = PageHelper.startPage(pageObj.getPage(), pageObj.getPageSize());
        mapper.query(entity);
        return page;
    }

    @Transactional(readOnly = false)
    public void delete(List<String> ids) throws Exception {
        mapper.delete(ids);
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public void save(T entity) throws Exception {
        if (entity.getIsNewRecord()) {
            entity.preInsert();
            mapper.insert(entity);
        } else {
            entity.preUpdate();
            mapper.updateByPrimaryKeySelective(entity);
        }
    }

    @Transactional
    public void updateByPrimaryKey(T entity) throws Exception {
        mapper.updateByPrimaryKey(entity);
    }

    @Transactional
    public void updateByPrimaryKeySelective(T entity) throws Exception {
        mapper.updateByPrimaryKeySelective(entity);
    }

    @Transactional
    public Integer findHasOne(T entity) throws Exception {
        return mapper.findHasOne(entity);
    }
}
