package com.liu.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.domain.IPBean;
import com.liu.domain.Log;
import com.liu.service.IPService;
import com.liu.utils.CheckIpUtils;
import com.liu.utils.HttpUtils;
import com.liu.utils.IPUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.DataInput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private IPService ipService;

    @RequestMapping(value = "/ip", produces ="application/json;charset=utf-8")
    public String getIP(HttpServletRequest request) throws Exception {
        String ipRequest = IPUtils.getIpRequest(request);
        String interIP1 = CheckIpUtils.getInterIP1();
        String interIP2 = CheckIpUtils.getInterIP2();
        String outIPV4 = CheckIpUtils.getOutIPV4();
        String address = "";
        String outerIP = "";
        System.out.println(ipRequest+"\t"+outIPV4);
//        System.out.println(interIP1+"\t"+interIP2+"\t"+outIPV4);
        String host = "https://ipaddquery.market.alicloudapi.com";
        String path = "/ip/address-query";
        String method = "POST";
        String appcode = "5e57fd9994df415d9a52f8bc5a22f0d1";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("ip", outIPV4);
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
//            System.out.println(response.getEntity().toString());
            String json = EntityUtils.toString(response.getEntity(),"utf-8");
            //获取response的body
            System.out.println(json);
            JSONObject jsonObject1 = JSONObject.parseObject(json);
            JSONObject data = jsonObject1.getJSONObject("data");
            System.out.println(data);
            IPBean ipBean = data.toJavaObject(IPBean.class);
            address = ipBean.getCountry()+ipBean.getArea()+"-"+ipBean.getRegion()+ipBean.getCity()+"-"+ipBean.getIsp();
            outerIP = ipBean.getIp();
            System.out.println(ipBean.getCity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s_date = format.format(date);
//        String s_date =
        System.out.println(s_date);
        ipService.saveLog(ipRequest,s_date,address,outerIP);
        return "redirect:/login.jsp";
    }

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView){
        List<Log> logList = ipService.list();
        modelAndView.addObject("logList",logList);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }

}
