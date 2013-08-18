package me.nengzhe.goods.dao.base;

import me.nengzhe.utils.Pager;
import me.nengzhe.utils.SearchAble;

import java.util.List;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午10:26
 */
public interface PaginationDao<T> extends BaseDao<T> {
    /**
     * 取得列表
     *
     * @param search 搜索条件
     * @return 列表
     */
    List<T> getList(SearchAble search);
    /**
     * 取得列表
     *
     * @param search 搜索条件
     * @param pager 分页
     * @return 列表
     */
    List<T> getList(SearchAble search, Pager pager);

    /**
     * 取得符合搜索的个数
     *
     * @param search 搜索条件
     * @return 总个数
     */
    Integer getCount(SearchAble search);
}
