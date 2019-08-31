package com.shop.shopstore.mapper.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Long on 2019/4/4.
 */
public interface BaseMapper<T> {

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    T get(String id);

    List<T> query(T t);

    int deleteByPrimaryKey(String id);

    void insert(T t);

    void delete(@Param("ids") List<String> ids);

    int insertSelective(T t);

    T selectByPrimaryKey(String id);

    void updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    Integer findHasOne(T t);
}
