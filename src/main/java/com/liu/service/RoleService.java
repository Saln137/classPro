package com.liu.service;

import com.liu.domain.SRole;

import java.util.List;

public interface RoleService {
    List<SRole> list();

    void save(SRole sRole);
}
