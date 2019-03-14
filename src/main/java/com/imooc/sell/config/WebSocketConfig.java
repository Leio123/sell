package com.imooc.sell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
//做个配置
//@Component注解会告诉Spring创建这个类的实例bean（注意，启动Component注解功能需要在xml里面配置） <bean>定义实例对象
//@Component
public class WebSocketConfig {
    @Bean
    //Bean的名字叫做ServerEndpointExporter
    public ServerEndpointExporter  serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
