package com.liu.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();

        if (e instanceof EmptyResultDataAccessException) {
            modelAndView.setViewName("error");
        }
//        else {
//            modelAndView.setViewName("/404.jsp");
//        }
        return modelAndView;
    }
}
