package com.wyd.reactorapp.test.reactor;

import com.wyd.reactorapp.test.reactor.entity.SendInfo;
import com.wyd.reactorweb.annotation.MyRequestMapping;
import com.wyd.reactorweb.common.AjaxResult;
import com.wyd.reactorweb.common.AjaxResultUtil;
import com.wyd.reactorweb.design.reactor.core.AsynRemoteChannel;
import com.wyd.reactorweb.design.reactor.core.ChannelContext;
import com.wyd.reactorweb.design.reactor.factory.SpringAsynRemoteChannelBuilderFactory;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: reactor-web-starter
 * @description: reactor测试
 * @author: Stone
 * @create: 2023-11-29 11:12
 **/
@Slf4j
@Component
@MyRequestMapping(value = "/reactorTest")
public class ReactController {

    @Resource
    SpringAsynRemoteChannelBuilderFactory builderFactory;

    @MyRequestMapping(value = "/test1")
    public AjaxResult<String> test1(String param) {
        AjaxResult<String> result = new AjaxResult<>();
        result.setData(param);
        return AjaxResultUtil.getTrueAjaxResult(result);
    }

    @MyRequestMapping(value = "/test2")
    public void test2(Channel c) {
        System.out.println("test2运行~");
        AsynRemoteChannel channel =
                builderFactory.getAsynRemoteChannel("messageSendServiceAsynAdaptor");
        // 简单测试一下
        ChannelContext<Boolean> context = new ChannelContext<>();
        SendInfo sendInfo = new SendInfo();
        sendInfo.setContent("reactor test 一下~");
        context.getParamMap().put("sendInfo", sendInfo);
        context.getContextMap().put("socketChannel", c);
        channel.walk(context);
    }

}
