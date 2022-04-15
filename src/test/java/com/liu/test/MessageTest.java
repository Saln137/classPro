package com.liu.test;

import com.liu.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MessageTest {
    @Test
    public void test(){
            String host = "https://jmsms.market.alicloudapi.com";
            String path = "/sms/send";
            String method = "POST";
            String appcode = "5e57fd9994df415d9a52f8bc5a22f0d1";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("mobile", "17762698447");
            querys.put("templateId", "M72CB42894");
            querys.put("value", "1");
            Map<String, String> bodys = new HashMap<String, String>();
            try {
                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                System.out.println(response.toString());
                //获取response的body
                System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
