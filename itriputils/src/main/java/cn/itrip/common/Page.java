
package cn.itrip.common;

import java.util.List;

/**
 * <p>分页处理类 .</p>
 *
 * @version v1.0
 * @author dongdh
 * @date Sep 21, 2011
 *
 */
public class Page<T> {

    // 分页全局变量 begin
    /**
     * 页面大小 .
     */
    private static final int PAGE_SIZE = 10;
    /**
     * 页面允许最大值 MAX  .
     */
    private static final int MAX = 65;
    /**
     * 当前页面 .
     */
    private int curPage = 1;
    /**
     * 总记录数 .
     */
    private long total;
    /**
     * 每页行数 .
     */
    private long pageSize = PAGE_SIZE;

    /** 页面自定义pageSize.*/
    private long customPageSize;
    /**
     * 页面的总数  .
     */
    private long pageCount;
    /**
     * 结果集中数据的起始位置  .
     */
    private long beginPos;
    /**
     * 结果集中数据的终止位置  .
     */
    private long endPos;
    /**
     * List 集合.
     */
    private List<T> rows;
    /**
     * 页面显示页面大小ELEVEN .
     */
    private static final int ELEVEN = 11;
    /**
     * 在页面 显示 多少页 其他页 以...方式 显示 .
     */
    private int showPageSize = ELEVEN;
    /**
     *  0 否 1 是 .
     */
    private int isMultiCondition = 0;
    /**
     * 页面跳转的url .
     */
    private String url;
    /**
     * 当是 多条件 查询的时候 对应的 formid .
     */
    private String formId = "selForm";
    /**
     * 无参数构造方法 .
     */
    public Page() {
    }
    /**
     * 当前页面 .
     * 页面的大小 .
     * @param curpage .
     * @param pagesize .
     */
    public Page(int curpage, long pagesize) {
        if (curpage < 1) {
            curpage = 1;
        }
        this.curPage = curpage;
        this.pageSize = pagesize;
    }
    /**
     * 当前页面 .
     * 页面的大小 .
     * @param curpage .
     * @param pagesize .
     * @param showpagesize .
     */
    public Page(int curpage, long pagesize, int showpagesize) {
        if (curpage < 1) {
            curpage = 1;
        }
        this.curPage = curpage;
        this.pageSize = pagesize;
        this.showPageSize = showpagesize;
    }
    /**
     * 当前页面 .
     * @param curpage .
     */
    public Page(int curpage) {
        if (curpage < 1) {
            curpage = 1;
        }
        this.curPage = curpage;
    }
    /**
     * 构造方法 .
     * @param curpage .
     * @param rows .
     */
    public Page(int curpage, List rows) {
        this.curPage = curpage;
        this.rows = rows;
    }


    /**
     * 总页面数 .
     * @return Long .
     */
    public long getPageCount() {
        this.pageCount = (total + getPageSize() - 1) / getPageSize();
        return pageCount;
    }
    /**
     *  得到页面的当前位置 .
     * @return Long .
     */
    public long getBeginPos() {
        /* (rowCount == 0 ? 0 : 1) 不会显示第1条到第0条。记录数为0时，都显示0 */
        beginPos =  (getPageCount() == 0 ? 0 : (getCurPage() - 1)) * getPageSize() + (total == 0 ? 0 : 1);
        return beginPos;
    }
    /**
     * @param curpage .
     * @param rowcount .
     * @param pagesize .
     */
    public Page(int curpage, long rowcount, long pagesize) {
        super();
        this.curPage = curpage;
        this.total = rowcount;
        this.pageSize = pagesize;
    }

    /**
     * @return the curPage
     */
    public long getCurPage() {
        // 删除尾页全部记录时

        if (curPage < 1) {
            curPage = 1;
        }
        if (total != 0
                && curPage > (total / getPageSize() + (total % getPageSize() == 0 ? 0
                        : 1))) {
            return curPage - 1;
        }

        if (curPage > getPageCount()) {
            return getPageCount();
        }
        return curPage;
    }

    /**
     * @param curPage
     *            the curPage to set
     */
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    /**
     * @return the endPos
     */
    public long getEndPos() {

        endPos = beginPos + getPageSize() - 1;
        if (endPos > total) {
            endPos = total;
            // 分页 end
        }
        return endPos;
    }
    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    /**
     * @return the pageSize
     */
    public long getPageSize() {
        if (customPageSize != 0) {
            return customPageSize;
        }
        return pageSize;
    }

    /**
     * @param pageSize
     *            the pageSize to set
     */
    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @param rowCount
     *            the rowCount to set
     */
    public void setRowCount(long rowCount) {
        this.total = rowCount;
    }

    /**
     * @param beginPos
     *            the beginPos to set
     */
    public void setBeginPos(long beginPos) {
        this.beginPos = beginPos;
    }

    public int getShowPageSize() {
        return showPageSize;
    }

    public void setShowPageSize(int showPageSize) {
        this.showPageSize = showPageSize;
    }

    public int getIsMultiCondition() {
        return isMultiCondition;
    }

    public void setIsMultiCondition(int isMultiCondition) {
        this.isMultiCondition = isMultiCondition;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
         this.formId = formId;
    }
    /**
     * 循环往页面插入 .
     * @param args .
     */
    public static void main(String[] args) {
        for (int i = 0; i < MAX; i++) {
            System.out.println("insert into mobi_page_demo(id) values(" + i
                    + ");");
        }
    }
    /**
     * @return the customPageSize
     */
    public long getCustomPageSize() {
        return customPageSize;
    }
    /**s
     * @param customPageSize the customPageSize to set
     */
    public void setCustomPageSize(long customPageSize) {
        this.customPageSize = customPageSize;
    }

    public static int getMax() {
        return MAX;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public void setEndPos(long endPos) {
        this.endPos = endPos;
    }

    public static int getEleven() {
        return ELEVEN;
    }
}
