package com.liu.controller;

import com.liu.domain.SRole;
import com.liu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/save")
    public String save(SRole sRole){
        roleService.save(sRole);
        return "redirect:/role/list";
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<SRole> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
//        System.out.println(roleList);
        return modelAndView ;
    }
}
