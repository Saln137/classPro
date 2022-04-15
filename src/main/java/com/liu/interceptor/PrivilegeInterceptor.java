package com.liu.interceptor;

import com.liu.domain.SUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        SUser user = (SUser) session.getAttribute("user");
        String value = (String) session.getAttribute("value");
        if (user == null && value == null) {
            /*为空,重定向到登录界面*/
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
        /*不为空放行*/
        return true;
    }
}
