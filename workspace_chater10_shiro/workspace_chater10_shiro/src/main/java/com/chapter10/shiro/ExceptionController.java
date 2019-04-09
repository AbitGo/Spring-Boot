package com.chapter10.shiro;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AuthenticationException.class)
    public ModelAndView error(AuthenticationException e)
    {
        ModelAndView mv = new ModelAndView("unauthorized");
        mv.addObject("error",e.getMessage());
        return mv;
    }


}
