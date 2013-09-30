package me.nengzhe.base.dao;

import me.nengzhe.base.exception.NotImplException;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午2:45
 */
public interface BaseDao<T> {

    /**
     * 增加记录
     *
     * @param entity 记录实体
     * @return 成功条数
     * @throws NotImplException
     */
    Integer insert(T entity) throws NotImplException;

    /**
     * 修改记录
     *
     * @param entity 记录实体
     * @return 成功条数
     * @throws NotImplException
     */
    Integer update(T entity) throws NotImplException;

    /**
     * 删除实体
     *
     * @param id 记录ID
     * @return 成功条数
     * @throws NotImplException
     */
    Integer delete(Integer id) throws NotImplException;

    /**
     * 取得实体
     *
     * @param id 记录ID
     * @return 记录实体
     * @throws NotImplException
     */
    T get(Integer id) throws NotImplException;
}
