package com.liu.service.impl;

import com.liu.dao.IPDao;
import com.liu.domain.IPBean;
import com.liu.domain.Log;
import com.liu.service.IPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPServiceImpl implements IPService {

    @Autowired
    private IPDao ipDao;

    public void setIpDao(IPDao ipDao) {
        this.ipDao = ipDao;
    }

    @Override
    public void saveLog(String ipRequest,String s_date,String address,String outerIP) {
        ipDao.saveLog(ipRequest,s_date,address,outerIP);
    }

    @Override
    public void saveName(String name) {
        ipDao.saveName(name);
    }

    @Override
    public List<Log> list() {
        return ipDao.list();
    }
}
