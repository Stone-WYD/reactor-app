package com.wyd.reactorapp.test.reactor.channel;

import com.wyd.reactorapp.test.reactor.entity.SendInfo;
import com.wyd.reactorapp.test.reactor.service.RemoteMessageSendService;
import com.wyd.reactorweb.annotation.ChannelInfo;
import com.wyd.reactorweb.common.AjaxResult;
import com.wyd.reactorweb.design.reactor.core.AsynReceptResult;
import com.wyd.reactorweb.design.reactor.core.AsynRemoteServiceProxy;
import com.wyd.reactorweb.design.reactor.core.ChannelContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: reactor-web-starter
 * @description: service 转 channel 服务类适配器类
 * @author: Stone
 * @create: 2023-11-29 10:59
 **/
@Component
@ChannelInfo(renderType = TestHandler.class)
public class MessageSendServiceAsynAdaptor extends AsynRemoteServiceProxy<Boolean> {

    @Resource
    private RemoteMessageSendService remoteService;

    @Override
    public AjaxResult<String> call(ChannelContext channelContext) {
        SendInfo sendInfo = ((SendInfo) channelContext.getParamMap().get("sendInfo"));
        return remoteService.send(sendInfo);
    }

    @Override
    public AsynReceptResult<Map<String, AjaxResult<Boolean>>> requestReceipt() {
        return remoteService.getResultList();
    }
}
