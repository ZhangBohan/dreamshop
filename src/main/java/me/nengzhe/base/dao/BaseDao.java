package me.nengzhe.base.dao;

import me.nengzhe.base.exception.NotImplException;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午2:45
 */
public interface BaseDao<T> {
    void insert(T entity) throws NotImplException;
    void update(T entity) throws NotImplException;
    void delete(Integer id) throws NotImplException;
    T get(Integer id) throws NotImplException;
}
