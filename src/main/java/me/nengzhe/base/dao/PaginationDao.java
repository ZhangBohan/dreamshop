package me.nengzhe.base.dao;

import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.utils.Pager;

import java.util.List;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午2:45
 */
public interface PaginationDao<T, K> extends BaseDao<T> {
    List<T> getList(K search) throws NotImplException;
    int getCount(K search) throws NotImplException;
    List<T> getList(K search, Pager pager) throws NotImplException;
}
