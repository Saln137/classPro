package com.liu.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.liu.dao.RoleDao;
import com.liu.dao.UserDao;
import com.liu.domain.PageBean;
import com.liu.domain.SRole;
import com.liu.domain.SUser;
import com.liu.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.io.PipedReader;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<SUser> list() {
        List<SUser> sUserList = userDao.findAll();
        //封装SUserList中的每一个User的roles数据
        for (SUser sUser : sUserList) {
            //获取user的id
            Integer id = sUser.getId();
            //将id作为参数,查询当前userID对应的SRole集合数据
            List<SRole> roles = roleDao.findRoleByUserID(id);
            sUser.setRoles(roles);
        }
        return sUserList;
    }

    @Override
    public PageBean<SUser> findUserByPage(int currentPage, int rows) {
        PageBean<SUser> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        int totalCount = userDao.findTotalCount();
        pb.setTotalCount(totalCount);
        int start =(currentPage -1 )*rows;
        List<SUser> list = userDao.findByPage(start,rows);
        pb.setList(list);
        for (SUser sUser : list) {
            Integer id = sUser.getId();
            List<SRole> roles = roleDao.findRoleByUserID(id);
            sUser.setRoles(roles);
        }
        int totalPage = (totalCount % rows) == 0 ? (totalCount/rows) : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void save(SUser user, Long[] roleIDs) {
        Long userId = userDao.save(user);
        userDao.saveUserRoleRelation(userId, roleIDs);
    }

    @Override
    public void delUser(Long userId) {
        userDao.delUserRoleRelation(userId);
        userDao.delUser(userId);
    }


    @Override
    public SUser passwordLogin(String username, String password) throws EmptyResultDataAccessException {
            return  userDao.findUserByUsernameAndPassword(username,password);
        }
}
