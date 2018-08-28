package com.nongrj.web.controller;

import com.nongrj.entity.Article;
import com.nongrj.entity.ArticleExample;
import com.nongrj.service.IArticleService;
import com.nongrj.web.vo.FrontArticle;
import com.nongrj.web.vo.FrontArticlePage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 前台文章展示
 * @author ccr
 * @date 2018/8/24
 */
@Controller
@CrossOrigin
public class ArticleFrontController {

    @Autowired
    IArticleService articleService;

    /**
     * 首页新闻列表
     * @param request request
     * @return 文章列表
     */
    @RequestMapping("/front/news")
    @ResponseBody
    public List<FrontArticle> news(HttpServletRequest request){
        String ctx = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        ArticleExample example = new ArticleExample(1,4);
        example.setOrderByClause("publish_time desc");
        example.createCriteria().andIsPublishedEqualTo(true).andCategoryNotEqualTo("辉隆人");
        List<Article> articles = articleService.listArticleWithContent(example);
        return getFrontArticles(ctx, articles);
    }

    private List<FrontArticle> getFrontArticles(String ctx, List<Article> articles) {
        List<FrontArticle> frontArticles = new ArrayList<>(articles.size());
        for (Article article : articles) {
            FrontArticle frontArticle = new FrontArticle();
            frontArticle.setId(article.getId());
            frontArticle.setTitle(article.getTitle());
            frontArticle.setTime(article.getPublishTime());
            //解析文章Html
            Document doc = Jsoup.parse(article.getContent());
            //获取文章的第一张图片链接
            Elements imgs = doc.select("img");
            if(imgs.isEmpty()) {
                frontArticle.setImg("");
            } else {
                frontArticle.setImg(ctx + imgs.get(0).attr("src"));
            }
            //获取文章第一段文字
            Elements paragraph = doc.select("p:matchesOwn(\\S+)");
            if(paragraph.isEmpty()) {
                frontArticle.setText("");
            } else {
                frontArticle.setText(paragraph.get(0).getElementsMatchingOwnText("").text());
            }

            //获取PDF链接
            Elements link = doc.select("a[href$=pdf]");
            if(link.isEmpty()) {
                frontArticle.setLink("");
            } else {
                frontArticle.setLink(ctx + link.get(0).attr("href"));
            }
            frontArticles.add(frontArticle);
        }
        return frontArticles;
    }

    /**
     * 新闻中心，新闻列表（包含党建新闻）
     * @param request request
     * @param pageInfo 分页信息
     * @return 分页
     */
    @RequestMapping("/front/news-list")
    @ResponseBody
    public FrontArticlePage newsList(HttpServletRequest request,FrontArticlePage pageInfo){
        String ctx = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        ArticleExample example = new ArticleExample(pageInfo.getPageNo(),pageInfo.getPageSize());
        example.setOrderByClause("publish_time desc");
        example.createCriteria().andIsPublishedEqualTo(true).andCategoryNotEqualTo("党建与文化").andCategoryNotEqualTo("辉隆人");
        List<Article> articles = articleService.listArticleWithContent(example);
        long count = articleService.countArticle(example);
        List<FrontArticle> frontArticles = getFrontArticles(ctx, articles);
        pageInfo.setCount(count);
        pageInfo.setNewsList(frontArticles);
        return pageInfo;
    }

    /**
     * 党建新闻列表
     * @param request request
     * @param pageInfo 分页信息
     * @return 分页
     */
    @RequestMapping("/front/party-news")
    @ResponseBody
    public FrontArticlePage partyNews(HttpServletRequest request,FrontArticlePage pageInfo){
        String ctx = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        ArticleExample example = new ArticleExample(pageInfo.getPageNo(),pageInfo.getPageSize());
        example.setOrderByClause("publish_time desc");
        example.createCriteria().andIsPublishedEqualTo(true).andCategoryEqualTo("党建与文化");
        List<Article> articles = articleService.listArticleWithContent(example);
        long count = articleService.countArticle(example);
        List<FrontArticle> frontArticles = getFrontArticles(ctx, articles);
        pageInfo.setCount(count);
        pageInfo.setNewsList(frontArticles);
        return pageInfo;
    }

    /**
     * 党建新闻第一条
     * @param request request
     * @return 分页
     */
    @RequestMapping("/front/party")
    @ResponseBody
    public FrontArticle party(HttpServletRequest request){
        String ctx = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        ArticleExample example = new ArticleExample(1,1);
        example.setOrderByClause("publish_time desc");
        example.createCriteria().andIsPublishedEqualTo(true).andCategoryEqualTo("党建与文化");
        List<Article> articles = articleService.listArticleWithContent(example);
        List<FrontArticle> frontArticles = getFrontArticles(ctx, articles);
        if (frontArticles.isEmpty()) {
            return null;
        }
        return frontArticles.get(0);
    }

    /**
     * 辉隆人新闻列表
     * @param request request
     * @param pageInfo 分页信息
     * @return 分页
     */
    @RequestMapping("/front/pdf-list")
    @ResponseBody
    public FrontArticlePage pdfList(HttpServletRequest request,FrontArticlePage pageInfo){
        String ctx = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        ArticleExample example = new ArticleExample(pageInfo.getPageNo(),pageInfo.getPageSize());
        example.setOrderByClause("publish_time desc");
        example.createCriteria().andIsPublishedEqualTo(true).andCategoryEqualTo("辉隆人");
        List<Article> articles = articleService.listArticleWithContent(example);
        long count = articleService.countArticle(example);
        List<FrontArticle> frontArticles = getFrontArticles(ctx, articles);
        pageInfo.setCount(count);
        pageInfo.setNewsList(frontArticles);
        return pageInfo;
    }

    @RequestMapping("/front/news-detail")
    @ResponseBody
    public FrontArticle newsDetail(HttpServletRequest request,Long id){
        String ctx = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        Article article = articleService.getById(id);
        FrontArticle frontArticle = new FrontArticle();
        frontArticle.setId(article.getId());
        frontArticle.setTitle(article.getTitle());
        frontArticle.setTime(article.getPublishTime());
        //解析文章Html
        Document doc = Jsoup.parse(article.getContent());
        //获取文章的第一张图片链接
        Elements imgs = doc.select("img");
        if(imgs.isEmpty()) {
            frontArticle.setImg("");
        } else {
            frontArticle.setImg(ctx + imgs.get(0).attr("src"));
        }
        frontArticle.setText(article.getContent());
        return frontArticle;
    }



}
