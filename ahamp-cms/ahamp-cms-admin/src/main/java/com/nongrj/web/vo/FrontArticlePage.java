package com.nongrj.web.vo;

import java.util.List;

/**
 * @author ccr
 * @date 2018/8/24
 */
public class FrontArticlePage {

    /**
     * 起始页
     */
    private int pageNo;

    /**
     * 分页大小
     */
    private int pageSize;

    private long count;

    private List<FrontArticle> newsList;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<FrontArticle> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<FrontArticle> newsList) {
        this.newsList = newsList;
    }
}
