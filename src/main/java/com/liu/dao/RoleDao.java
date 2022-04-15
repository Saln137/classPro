package com.liu.dao;

import com.liu.domain.SRole;

import java.util.List;

public interface RoleDao {
    List<SRole> findAll();

    void save(SRole sRole);

    List<SRole> findRoleByUserID(Integer id);
}
