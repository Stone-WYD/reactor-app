package com.wyd.reactorapp.test.reactor.channel;

import com.wyd.reactorweb.design.reactor.core.ChannelContext;
import com.wyd.reactorweb.design.reactor.pipeline.Handler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * @program: reactor-web-starter
 * @description: 测试Handler类
 * @author: Stone
 * @create: 2023-11-29 14:31
 **/
@Component
public class TestHandler implements Handler {

    @Override
    public void handle(ChannelContext channelContext) {
        Channel socketChannel = (Channel) channelContext.getContextMap().get("socketChannel");
        socketChannel.writeAndFlush(channelContext.getAsynReceptResult());
    }
}
