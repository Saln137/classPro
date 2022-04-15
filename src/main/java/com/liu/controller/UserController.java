package com.liu.controller;

import com.liu.domain.PageBean;
import com.liu.domain.SRole;
import com.liu.domain.SUser;
import com.liu.service.IPService;
import com.liu.service.RoleService;
import com.liu.service.UserService;
import com.liu.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private IPService ipService;

    @RequestMapping("/list")
    public ModelAndView list() {
        List<SUser> sUserList = userService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sUserList", sUserList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/pageList")
    public ModelAndView pageList(ModelAndView modelAndView, HttpSession session, int currentPage, int rows) {
        if (currentPage == 0) {
            currentPage = 1;
        }
        if (rows == 0) {
            rows = 10;
        }
        PageBean<SUser> pb = userService.findUserByPage(currentPage, rows);
//        System.out.println(pb);
        modelAndView.addObject("pb", pb);
        modelAndView.setViewName("user-list");
        SUser user = (SUser) session.getAttribute("user");
        String name = user.getName();
//        ipService.saveName(name);
        return modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView save() {
        ModelAndView modelAndView = new ModelAndView();
        List<SRole> roleList = roleService.list();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String saveDo(SUser user, Long[] roleIds) {
        userService.save(user, roleIds);
        return "redirect:/user/pageList?currentPage=1&rows=10";
    }

    @RequestMapping("/del/{userId}")
    public String delUser(@PathVariable("userId") Long userId) {
        userService.delUser(userId);
        return "redirect:/user/pageList?currentPage=1&rows=10";
    }

    @RequestMapping("/PasswordLogin")
    public ModelAndView login(ModelAndView modelAndView, HttpSession session, String username, String password) throws EmptyResultDataAccessException {
        SUser sUser = userService.passwordLogin(username, password);
        if (sUser != null) {
            session.setAttribute("user",sUser);
//            System.out.println(session);
            modelAndView.addObject(sUser);
            modelAndView.setViewName("main");
        }else {
            modelAndView.setViewName("/login.jsp");
        }
        return modelAndView;
    }

    Random random = new Random();
    int code1 = random.nextInt(10);
    String value = code1+"";

    @RequestMapping(value = "/message" ,method = RequestMethod.POST)
    @ResponseBody
    public void message(@RequestParam(value = "phoneNumber") String phoneNumber) {
        String host = "https://jmsms.market.alicloudapi.com";
        String path = "/sms/send";
        String method = "POST";
        String appcode = "5e57fd9994df415d9a52f8bc5a22f0d1";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phoneNumber);
        querys.put("templateId", "M72CB42894");
        querys.put("value", value);
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return "<h1>验证码已发送,请返回登录!</h1>";
    }

    @RequestMapping("/check")
    public ModelAndView check(ModelAndView modelAndView,String checkCode,HttpSession session) throws Exception{
        if (checkCode.equals(value)) {
            session.setAttribute("value",value);
            modelAndView.setViewName("main");
        }
        return modelAndView;
    }
}
