package com.example.infoserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class InfoRouter {

    @Bean
    public RouterFunction<ServerResponse> route(){
        System.out.println("route 실행");
        return RouterFunctions
                .route(GET("/userJobInfo").and(accept(MediaType.APPLICATION_JSON)), infoHandler::getUserInfo);

    }

}
