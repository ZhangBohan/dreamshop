package me.nengzhe.base.dao;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午2:45
 */
public interface BaseDao<T> {
    void insert(T entity);
    void update(T entity);
    void delete(Integer id);
    T get(Integer id);
}
