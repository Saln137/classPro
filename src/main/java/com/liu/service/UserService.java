package com.liu.service;

import com.liu.domain.PageBean;
import com.liu.domain.SUser;

import java.util.List;

public interface UserService {
    List<SUser> list();

    void save(SUser user, Long[] roleIDs);

    void delUser(Long userId);

    PageBean<SUser> findUserByPage(int currentPage, int rows);

    SUser passwordLogin(String username, String password);
}
