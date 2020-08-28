package com.cai.springcloud.service.impl;

import com.cai.springcloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class) //创建通道
public class MessageProviderImpl implements MessageProvider {

    @Qualifier("output")
    @Autowired
    private MessageChannel channel;

    @Override
    public String send() {

        String s = UUID.randomUUID().toString();
        channel.send(MessageBuilder.withPayload(s).build());
        System.out.println(s + "===");
        return s;
    }
}
