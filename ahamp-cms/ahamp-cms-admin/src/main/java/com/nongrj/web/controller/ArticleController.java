package com.nongrj.web.controller;

import com.nongrj.entity.Article;
import com.nongrj.entity.ArticleExample;
import com.nongrj.service.IArticleService;
import com.nongrj.web.vo.ArticlePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 文章
 *
 * @date 2018/08/13
 * @author ccr
 */
@Controller
public class ArticleController {

    @Autowired
    com.baidu.ueditor.springboot.ActionEnter actionEnter;

    @Autowired
    IArticleService articleService;

    @RequestMapping("/article/insert")
    @ResponseBody
    public String insert(Article article) {
        int result = 0;
        if (article.getId() != null) {
            result = articleService.updateArticle(article.getId(),article.getTitle(),article.getCategory(),article.getContent(),false);
        } else {
            result = articleService.saveArticle(article);
        }
        return String.format("{\"code\":%d}",result);
    }

    @RequestMapping("/article/publish")
    @ResponseBody
    public String publish(Article article) {
        int result = 0;
        if (article.getId() != null) {
            result = articleService.updateArticle(article.getId(),article.getTitle(),article.getCategory(),article.getContent(),true);
        } else {
            result = articleService.publishArticle(article);
        }
        return String.format("{\"code\":%d}",result);
    }


    @RequestMapping(value="/article/imgUpload")
    @ResponseBody
    public String imageUpload(HttpServletRequest request){
        return actionEnter.exec(request);
    }

    @RequestMapping(value="/article/article-page")
    @ResponseBody
    public ArticlePage articlePage(ArticlePage pageInfo) {
        ArticleExample example = new ArticleExample(pageInfo.getPageNo(),pageInfo.getPageSize());
        example.setOrderByClause("publish_time");
        if(pageInfo.getCategory() != null && !pageInfo.getCategory().isEmpty()) {
            example.getOredCriteria().add(example.createCriteria().andCategoryEqualTo(pageInfo.getCategory()));
        }
        if(pageInfo.getTitle() != null && !pageInfo.getTitle().isEmpty()) {
            example.getOredCriteria().add(example.createCriteria().andTitleLike(pageInfo.getTitle() + "%"));
        }
        pageInfo.setArticleList(articleService.listArticle(example));
        pageInfo.setCount(articleService.countArticle(example));
        return pageInfo;
    }

    @RequestMapping(value="/article/getById")
    @ResponseBody
    public Article getById(Long id) {
        return articleService.getById(id);
    }

    @RequestMapping(value="/article/publishById")
    @ResponseBody
    public String publish(Long id) {
        int result = articleService.publishArticle(id);
        return String.format("{\"code\":%d}",result);
    }

    @RequestMapping(value="/article/cancelPublish")
    @ResponseBody
    public String cancelPublish(Long id) {
        int result = articleService.cancelPublish(id);
        return String.format("{\"code\":%d}",result);
    }

    @RequestMapping(value="/article/delete")
    @ResponseBody
    public String delete(Long id) {
        int result = articleService.deleteArticle(id);
        return String.format("{\"code\":%d}",result);
    }
}
