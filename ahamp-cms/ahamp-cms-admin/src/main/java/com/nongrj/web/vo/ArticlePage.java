package com.nongrj.web.vo;

import com.nongrj.entity.Article;

import java.util.List;

/**
 * 封装文章的分页信息
 * @author ccr
 * @date 2018/8/23
 */
public class ArticlePage {
    /**
     * 起始页
     */
    private int pageNo;

    /**
     * 分页大小
     */
    private int pageSize;

    /**
     * 查询条件-文章栏目
     */
    private String category;

    /**
     * 查询条件-文章标题
     */
    private String title;

    /**
     * 返回数据
     */
    private List<Article> articleList;

    /**
     * 数据条目
     */
    private long count;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
