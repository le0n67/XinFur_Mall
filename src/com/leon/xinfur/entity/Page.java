package com.leon.xinfur.entity;

/**
 * Date：2024/7/6  20:32
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

import java.util.List;

/**
 * * 分页实体类
 * 包含各种分页信息
 *
 */
public class Page<T> {

    // 默认每页显示的记录数
    public final static Integer DEFAULT_PAGE_SIZE=3;
    // 分页页码
    private Integer pageNo;
    // 分页每页显示的记录数
    private Integer pageSize=DEFAULT_PAGE_SIZE;
    // 总页数
    private Integer totalPage;
    // 总记录数
    private Integer totalRow;
    // 当前页的数据
    private List<T> items;
    // 分页导航
    private String url;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer gettotalPage() {
        return totalPage;
    }

    public void settotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalRow=" + totalRow +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
