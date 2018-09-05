package com.apm29.yjw.redis_demo.controller;

import com.apm29.yjw.redis_demo.domain.BaseResp;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;

@ControllerAdvice
@RestController
public class AspectErrorController {

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResp e1(Model model, Exception ex, HandlerMethod method){
        return BaseResp.err("记录已存在",null);
    }



}
