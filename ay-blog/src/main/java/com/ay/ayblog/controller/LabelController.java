package com.ay.ayblog.controller;

import com.ay.ayblog.pojo.Label;
import com.ay.ayblog.pojo.Result;
import com.ay.ayblog.service.impl.LabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(tags = "标签管理")
@RestController
public class LabelController {
    @Autowired
    private LabelService labelService;

    @ApiOperation("标签管理")
    @PostMapping("/create")
    public Result createUser(@ApiParam("标签信息") Label label, HttpServletRequest request) {
        log.info("Get a post request ");
        log.info(label.toString());
        Result<Label> result = new Result<>();

        labelService.insert(label);
        result.setResultSuccess("Label was successfully inserted into the database", label);
        return result;

    }

}
