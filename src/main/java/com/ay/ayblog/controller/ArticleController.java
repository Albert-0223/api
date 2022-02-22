package com.ay.ayblog.controller;

import com.ay.ayblog.pojo.Article;
import com.ay.ayblog.pojo.Result;
import com.ay.ayblog.service.impl.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(tags = "文章管理")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @ApiOperation("创建文章")
    @PostMapping("/create")
    public Result createUser(@ApiParam("文章信息") Article article, HttpServletRequest request) {
        log.info("Get a post request ");
        log.info(article.toString());
        Result<Article> result = new Result<>();

        articleService.insert(article);
        result.setResultSuccess("Article was successfully inserted into the database", article);
        return result;

    }

}
