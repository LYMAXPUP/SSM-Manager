package com.utils;

import com.alibaba.fastjson.JSONObject;

//前端需要给的数据全部在PageData类中
public class PageData {

    //默认每页显示几条
    private final static Integer DEFAULT_PAGE_SIZE = 3;
    //当前页
    private Integer pageIndex;
    //每一页条数
    private Integer pageSize;
    //搜索的数据 "account:'tianma'"
    private String sd;

    public PageData() {
    }

    public PageData(Integer pageIndex, Integer pageSize, String sd) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.sd = sd;
    }

    public Integer getPageIndex() {
        if (this.pageIndex == null || this.pageIndex < 1) {
            this.pageIndex = 1;
        }
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        if (this.pageSize == null || this.pageSize < 1) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    // 非正常访问可能会来000,看这个字符串能不能正确转成JSON
    public JSONObject getSd() {
        if (StringUtils.isNotEmpty(this.sd)) {
            try {
                JSONObject parse = (JSONObject) JSONObject.parse(this.sd);
                return parse;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", sd='" + sd + '\'' +
                '}';
    }
}
