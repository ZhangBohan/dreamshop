package me.nengzhe.base.utils;

/**
 * 分页信息封装
 *
 * @author bohan
 */
public class Pager {
    public static final Integer DEFAULT_PAGE_SIZE = 30;
    public static final Integer DEFAULT_START_PAGE = 1;

    private int page = DEFAULT_START_PAGE; // 页号

    private long total = -1; // 记录总数

    private int size = DEFAULT_PAGE_SIZE; // 每页显示记录数

    private Integer offset; // index

    public Pager() {
    }

    public Pager(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public Pager(int page, long total, int size) {
        this.page = page;
        this.total = total;
        this.size = size;
    }

    public int getPage() {
        return page >= DEFAULT_START_PAGE ? page : DEFAULT_START_PAGE;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOffset() {
        if(offset == null) {
            return (this.getPage() - 1) * size;
        } else {
            return this.offset;
        }
    }

    public long getPageNumber() {
        return (total - 1) / size + 1;
    }

    public void setOffset(Integer offset) {
        this.page = offset / size + 1;
        this.offset = offset;
    }
}
