package com.cna.helloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController    //Rest API를 처리하는 Bean클래스로 지정함
@RefreshScope      //Config서버와 연동하여 동적갱신이 가능한 Bean클래스로 만듦
public class Controller {
    @Value("${user.nickname:온달}")  //환경변수 user_nickname값을 읽고 없으면 '온달'로 값을 리턴
    private String userNickname;    //@Value에서 리턴한 값을 userNickname변수로 받음

    @GetMapping("/greeting/{message}")  //메소드가 Get이고 URI는 '/greeting/'뒤에 어떤 값이 있다고 지정함
    public String echo(@PathVariable String message) {  //echo라는 메소드는 파라미터로 URI경로에 있는 message값을 받음
        return userNickname + "님! " + message;  //Client에 값을 리턴함
    }
}