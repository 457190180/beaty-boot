package com.yimew.config.base.page;

import java.io.Serializable;

public class BasePage implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer limit;
    private Integer offset;
    //排序字段
    private String sort;
    //排序顺序
    private String order;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
