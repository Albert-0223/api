package com.ay.ayblog.controller;

import com.ay.ayblog.pojo.Category;
import com.ay.ayblog.pojo.Result;
import com.ay.ayblog.service.impl.CategoryService;
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
@Api(tags = "分类管理")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation("创建分类")
    @PostMapping("/create")
    public Result createUser(@ApiParam("分类信息") Category category, HttpServletRequest request) {
        log.info("Get a post request ");
        log.info(category.toString());
        Result<Category> result = new Result<>();

        categoryService.insert(category);
        result.setResultSuccess("Category was successfully inserted into the database", category);
        return result;

    }
}
