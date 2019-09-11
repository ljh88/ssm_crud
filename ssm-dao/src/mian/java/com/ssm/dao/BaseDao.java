package com.ssm.dao;

import java.io.Serializable;
import java.util.List;

/**
 * DAO公共基类
 */
public interface BaseDao<ID, T extends Serializable> {

    /**
     * 保存实体
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 通过entity更新实体
     *
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 通过id删除实体
     * @param id
     * @return
     */
    int delete(ID id);

    /**
     * 通过唯一值id查找一条实体
     *
     * @param id
     * @return
     */
    T selectID(ID id);

    /**
     * 条件查询返回唯一实体
     *
     * @param entity
     * @return
     */
    T selectEntity(T entity);

    /**
     * 通过条件查询返回list实体
     *
     * @param entity
     * @return
     */
    List<T> selectBy(T entity);

    /**
     * 通过条件查询总条数
     *
     * @param entity
     * @return
     */
    long selectByCount(T entity);
}