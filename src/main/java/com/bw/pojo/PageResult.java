package com.bw.pojo;

import java.util.List;

public class PageResult {
    private List rows;

    private Long total;

    public PageResult() {
        super();
    }

    @Override
    public String toString() {
        return "PageResult{" + "rows=" + rows + ", total=" + total + '}';
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public PageResult(List rows, Long total) {

        this.rows = rows;
        this.total = total;
    }
}
