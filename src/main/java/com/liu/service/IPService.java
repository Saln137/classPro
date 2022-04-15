package com.liu.service;

import com.liu.domain.IPBean;
import com.liu.domain.Log;

import java.util.List;

public interface IPService {
    void saveLog( String ipRequest,String s_date,String address,String outerIP);

    void saveName(String name);

    List<Log> list();

}
