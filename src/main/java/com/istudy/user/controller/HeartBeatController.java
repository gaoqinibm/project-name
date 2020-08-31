package com.istudy.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Baizhen
 */
@RestController
@RequestMapping("hb")
@Api(value="HeartBeatController",tags={"心跳检测 示范"})
public class HeartBeatController {

    /**
     * 健康值
     * @return
     */
    @ApiOperation(value = "hello O(∩_∩)O", notes = "健康值")
    @GetMapping("/getValue")
    public int getValue() {
        return 1;
    }

    /**
     * @param name
     */
    @ApiOperation(value = "hello ~", notes = "欢迎")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "名字", required = true)})
    @GetMapping("/hello")
    public String getName(String name) {
        return "hello " + name;
    }
}
