package main.java.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // localhost:8080/   이렇게 도메인을 입력하면 뜬다
    public String home() {
        return "home"; //home 파일을 resources/templates에서 찾아서 렌더링
    }



}
