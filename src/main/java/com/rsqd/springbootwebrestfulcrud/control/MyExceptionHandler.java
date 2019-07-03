package com.rsqd.springbootwebrestfulcrud.control;

import com.rsqd.springbootwebrestfulcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> handleException(Exception e){
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.not exist");
//        map.put("message",e.getMessage());
//
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        //get error code 4xx 5xx

        request.setAttribute("javax.servlet.error.status_code",400);
        map.put("code","user.not exist");
        map.put("message",e.getMessage());

        request.setAttribute("ext",map);
        return "forward:/error";
    }



}
