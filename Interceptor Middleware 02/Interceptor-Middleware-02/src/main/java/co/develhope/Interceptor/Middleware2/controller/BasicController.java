package co.develhope.Interceptor.Middleware2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("")
    public String print(){
        return "welcome";
    }
}
