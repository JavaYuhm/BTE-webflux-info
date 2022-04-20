package com.example.infoserver;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class infoHandler {

    public static Mono<ServerResponse> getUserInfo(ServerRequest request){

        Optional<String> queryString = request.queryParam("name");

        if(!queryString.isPresent()){
            return ServerResponse.badRequest().bodyValue("올바르지 않은 경로입니다");
        }

        String name = queryString.get();

        UserInfo userInfo = new UserInfo("Backend "+name);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(userInfo));

    }

}
