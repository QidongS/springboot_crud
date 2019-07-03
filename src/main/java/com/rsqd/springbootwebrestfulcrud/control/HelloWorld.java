package com.rsqd.springbootwebrestfulcrud.control;

import com.rsqd.springbootwebrestfulcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloWorld {
    @RequestMapping({"/","/index.html"})
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(@RequestParam("user") String user){
        if (user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "hello world";
    }

    @RequestMapping("success")
    public String success(Map<String,Object> map){
        //classpath:/templates/success.html
        map.put("hello","good morning");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

}
