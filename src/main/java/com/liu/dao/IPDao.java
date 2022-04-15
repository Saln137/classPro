package com.liu.dao;

import com.liu.domain.IPBean;
import com.liu.domain.Log;

import java.util.List;

public interface IPDao {
    void saveLog(String ipRequest,String s_date,String address,String outerIP);

    void saveName(String name);

    List<Log> list();
}
