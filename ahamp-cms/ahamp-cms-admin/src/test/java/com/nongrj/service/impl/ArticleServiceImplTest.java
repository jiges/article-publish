package com.nongrj.service.impl;

import com.nongrj.entity.Article;
import com.nongrj.service.IArticleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ccr
 * @date 2018/8/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ArticleServiceImplTest {

    @Autowired
    IArticleService articleService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void saveArticle() throws Exception {
        Article article = new Article();
        article.setTitle("测试");
        article.setContent("测试车是衬衫");
        assert articleService.saveArticle(article) == 1 : "插入失败";
    }

    @Test
    public void deleteArticle() throws Exception {

    }

    @Test
    public void updateArticle() throws Exception {

    }

    @Test
    public void publishArticle() throws Exception {

    }

    @Test
    public void publishArticle1() throws Exception {

    }

}