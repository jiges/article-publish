package com.nongrj.service.impl;

import com.nongrj.dao.ArticleMapper;
import com.nongrj.entity.Article;
import com.nongrj.entity.ArticleExample;
import com.nongrj.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @date 2018/08/13
 * @author ccr
 */
@Service
public class ArticleServiceImpl implements IArticleService{

    @Autowired
    ArticleMapper articleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveArticle(Article record) {
        record.setCreateTime(new Date());
        record.setIsDeleted(false);
        record.setUpdateTime(new Date());
        record.setIsPublished(false);
        return articleMapper.insertSelective(record);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteArticle(Long id) {
        Article article = new Article();
        article.setId(id);
        article.setIsDeleted(true);
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateArticle(Long id, String title, String category,String content,boolean published) {
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setCategory(category);
        article.setContent(content);
        if(published) {
            article.setIsPublished(true);
            article.setPublishTime(new Date());
        } else {
            article.setIsPublished(false);
        }
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int publishArticle(Long id) {
        Article article = new Article();
        article.setId(id);
        article.setIsPublished(Boolean.TRUE);
        article.setPublishTime(new Date());
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int publishArticle(Article article) {
        article.setCreateTime(new Date());
        article.setIsDeleted(false);
        article.setUpdateTime(new Date());
        article.setIsPublished(true);
        article.setPublishTime(new Date());
        return articleMapper.insertSelective(article);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Article> listArticle(ArticleExample articleExample) {
        return articleMapper.selectByExample(articleExample);
    }

    @Override
    public List<Article> listArticleWithContent(ArticleExample articleExample) {
        return articleMapper.selectByExampleWithBLOBs(articleExample);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long countArticle(ArticleExample articleExample) {
        return articleMapper.countByExample(articleExample);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Article getById(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int cancelPublish(Long id) {
        Article article = new Article();
        article.setId(id);
        article.setIsPublished(Boolean.FALSE);
        return articleMapper.updateByPrimaryKeySelective(article);
    }
}
