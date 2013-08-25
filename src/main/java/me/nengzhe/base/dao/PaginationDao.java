package me.nengzhe.base.dao;

import java.util.List;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午2:45
 */
public interface PaginationDao<T> extends BaseDao<T> {
    List<T> getList();
    int getCount();
}
