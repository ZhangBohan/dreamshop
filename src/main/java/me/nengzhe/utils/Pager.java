package me.nengzhe.utils;

/**
 * 分页信息封装
 *
 * @author bohan
 */
public class Pager {
    public static final Integer DEFAULT_PAGE_SIZE = 30;
    public static final Integer DEFAULT_START_PAGE = 1;

    int page = DEFAULT_START_PAGE; // 页号

    long total = -1; // 记录总数

    int size = DEFAULT_PAGE_SIZE; // 每页显示记录数

    private int navigatePageNum = 6; //导航页码数

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

    public int getNavigatePageNum() {
        return navigatePageNum;
    }

    public void setNavigatePageNum(int navigatePageNum) {
        this.navigatePageNum = navigatePageNum;
    }

    public int getAllPage() {
        int allPage = 0;
        if (total != 0 && total % size == 0) {
            allPage = (int) (total / size);
        } else {
            allPage = (int) (total / size) + 1;
        }
        return allPage;
    }

    public int getOffset() {
        return (this.getPage() - 1) * size;
    }

    public Integer getPrePage() {
        return page == 1 ? null : page - 1;
    }

    public Integer getNextPage() {
        int allPage = getAllPage();
        return page == allPage || allPage == 0 ? null : page + 1;
    }

    public long getPageNumber() {
        return (total - 1) / size + 1;
    }

    public boolean isFirstPage() {
        return this.getPage() == DEFAULT_START_PAGE;
    }

    public boolean isLastPage() {
        return this.getPage() == this.getPageNumber();
    }

    public boolean hasPrePage() {
        return this.getPage() > DEFAULT_START_PAGE;
    }

    public boolean hasNextPage() {
        return this.getPage() < this.getPageNumber();
    }

    public static void main(String[] args) {
        Pager pager = new Pager(4, 200, 30);
        System.out.println("Page number: " + pager.getPageNumber());
        System.out.println("Page is first page: " + pager.isFirstPage());
        System.out.println("Page has pre: " + pager.hasPrePage());
//        System.out.println("Page Navi Pages: " + ArrayUtils.toString(pager.getNaviPages()));
        System.out.println("Page has next: " + pager.hasNextPage());
        System.out.println("Page is last page: " + pager.isLastPage());
    }
}
