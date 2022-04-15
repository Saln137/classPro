package com.liu.dao;

import com.liu.domain.SUser;

import java.util.List;

public interface UserDao {
    List<SUser> findAll();

    Long save(SUser user);

    void saveUserRoleRelation(Long id, Long[] roleIDs);

    void delUser(Long userId);

    void delUserRoleRelation(Long userId);

    int findTotalCount();

    List<SUser> findByPage(int start, int rows);

    SUser findUserByUsernameAndPassword(String username, String password);

}
