package com.utils;

import java.util.List;

// 后端传回去要显示的内容，都在TableData中
public class TableData<T> {
    // 以前在vue中定义的数据，以前是零零散散地传
    private Integer pageIndex;//索引
    private Integer pageSize;//每页数量
    private Integer pageCount;//总页数
    private Integer dataCount;//总数据量
    private List<T> dataList;//数据列表

    public TableData(PageData pd) {
        this.pageIndex = pd.getPageIndex();
        this.pageSize = pd.getPageSize();
    }

    public TableData(Integer pageIndex, Integer pageSize, Integer pageCount, Integer dataCount, List<T> dataList, PageData pd) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.dataCount = dataCount;
        this.dataList = dataList;
        this.pageIndex = pd.getPageIndex();
        this.pageSize = pd.getPageSize();
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        int pc = 0;
        if (dataCount > 0) {
            pc = (dataCount % pageSize == 0) ? (dataCount / pageSize) : (dataCount / pageSize) + 1;
        }
        this.dataCount = dataCount;
        this.pageCount = pc;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "TableData{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", dataCount=" + dataCount +
                ", dataList=" + dataList +
                '}';
    }
}
