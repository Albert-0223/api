package com.ay.ayblog.controller;

import com.ay.ayblog.pojo.Comment;
import com.ay.ayblog.pojo.Result;
import com.ay.ayblog.service.impl.CommentService;
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
@Api(tags = "评论管理")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ApiOperation("创建评论")
    @PostMapping("/create")
    public Result createUser(@ApiParam("评论信息") Comment comment, HttpServletRequest request) {
        log.info("Get a post request ");
        log.info(comment.toString());
        Result<Comment> result = new Result<>();

        commentService.insert(comment);
        result.setResultSuccess("Comment was successfully inserted into the database", comment);
        return result;

    }
}
