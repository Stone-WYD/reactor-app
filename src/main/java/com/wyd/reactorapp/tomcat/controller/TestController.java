package com.wyd.reactorapp.tomcat.controller;

import com.wyd.reactorweb.common.AjaxResult;
import com.wyd.reactorweb.common.AjaxResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: reactor-app
 * @description: springMVC测试controller类
 * @author: Stone
 * @create: 2023-12-06 10:54
 **/
@Slf4j
@RestController
@RequestMapping("/springMVC/test")
public class TestController {

    @RequestMapping("/test1")
    public AjaxResult<String> test1(@RequestParam("name") String name) {
        log.info(name);
        AjaxResult<String> result = new AjaxResult<>();
        result.setData(name);
        return AjaxResultUtil.getTrueAjaxResult(result);
    }
}
