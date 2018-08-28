package com.nongrj.service;

import com.nongrj.entity.Article;
import com.nongrj.entity.ArticleExample;

import java.util.List;

/**
 * @date 2018/08/13
 * @author ccr
 */
public interface IArticleService {

//    List<Article> selectArticle

    /**
     * 向数据库插入一篇文章
     * @param record 文章
     * @return affected rows
     */
    int saveArticle(Article record);

    /**
     * 删除文章
     * @param id 文章主键
     * @return affected rows
     */
    int deleteArticle(Long id);

    /**
     * 更新文章标题或者内容
     * @param id 文章主键
     * @param title 新标题
     * @param content 新标题
     * @return affected rows
     */
    int updateArticle(Long id,String title,String category, String content,boolean published);

    /**
     * 发布文章
     * @param id 文章主键
     * @return affected rows
     */
    int publishArticle(Long id);

    /**
     * 新增并发布文章
     * @param record x
     * @return affected rows
     */
    int publishArticle(Article record);

    /**
     * 列举文章
     * @param articleExample 查询条件封装
     * @return Article list
     */
    List<Article> listArticle(ArticleExample articleExample);

    /**
     * 列举文章(包含内容)
     * @param articleExample 查询条件封装
     * @return Article list
     */
    List<Article> listArticleWithContent(ArticleExample articleExample);

    /**
     * 统计文章数量
     * @param articleExample 查询条件封装
     * @return Article counts
     */
    long countArticle(ArticleExample articleExample);

    /**
     * id查找
     * @param id id
     * @return article
     */
    Article getById(Long id);

    /**
     * 取消发布
     * @param id id
     * @return affected rows
     */
    int cancelPublish(Long id);
}
