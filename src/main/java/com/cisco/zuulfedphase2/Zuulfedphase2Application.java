package com.cisco.zuulfedphase2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@SpringBootApplication
@RestController
@EnableZuulProxy
public class Zuulfedphase2Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuulfedphase2Application.class, args);
    }

    @RequestMapping(value = "/hydra/{name}")
    public String echoStudentName(@PathVariable(name = "name") String name)
    {
        return "Hello!! from Hydra EU  <strong style=\"color: red;\">" + name + " </strong> Responsed on : " + new Date();
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}
