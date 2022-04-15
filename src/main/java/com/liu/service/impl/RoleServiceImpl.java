package com.liu.service.impl;

import com.liu.dao.RoleDao;
import com.liu.domain.SRole;
import com.liu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<SRole> list() {
        List<SRole> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(SRole sRole) {
        roleDao.save(sRole);
    }
}
