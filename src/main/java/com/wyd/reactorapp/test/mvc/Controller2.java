package com.wyd.reactorapp.test.mvc;

import com.wyd.reactorapp.test.mvc.entity.Names;
import com.wyd.reactorweb.annotation.MyRequestMapping;
import com.wyd.reactorweb.annotation.param.MyReqeustBody;
import com.wyd.reactorweb.annotation.param.MyRequestParam;
import com.wyd.reactorweb.common.AjaxResult;
import com.wyd.reactorweb.common.AjaxResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;


/**
 * @program: reactor_web
 * @description: 测试controller
 * @author: Stone
 * @create: 2023-11-10 18:16
 **/
@Slf4j
@Component
@MyRequestMapping(value = "/appTest")
public class Controller2 {

    @MyRequestMapping(value = "/test1")
    public ModelAndView test1() {
        System.out.println("没有传参的测试~");
        return null;
    }

    @MyRequestMapping(value = "/test2")
    public ModelAndView test2(@MyRequestParam("name") String name, String name2, Integer name3, String name4) {
        String content = name + name2 + name3 + name4;
        log.debug("test2({})", content);
        System.out.println(content);
        return null;
    }

    @MyRequestMapping(value = "/test3")
    public AjaxResult<String> test3(@MyRequestParam("name") String name, String name2, Integer name3, String name4) {
        String content = name + name2 + name3 + name4;
        log.debug("test3({})", content);
        System.out.println(content);
        AjaxResult<String> result = new AjaxResult<>();
        result.setData(content);
        return AjaxResultUtil.getTrueAjaxResult(result);
    }

    @MyRequestMapping(value = "/test4")
    public AjaxResult<String> test4(Names names) {
        String content = names.toString();
        log.info("test3({})", content);
        System.out.println(content);
        AjaxResult<String> result = new AjaxResult<>();
        result.setData(content);
        return AjaxResultUtil.getTrueAjaxResult(result);
    }

    @MyRequestMapping(value = "/test5")
    public AjaxResult<String> test5(@MyReqeustBody Names names) {
        String content = names.toString();
        log.debug("test3({})", content);
        System.out.println(content);
        AjaxResult<String> result = new AjaxResult<>();
        result.setData(content);
        return AjaxResultUtil.getTrueAjaxResult(result);
    }
}
