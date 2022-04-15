package com.liu.domain;

import com.alibaba.fastjson.JSONObject;
//{"area":"华中","country":"中国","long_ip":"454123740","city":"武汉","ip":"27.17.96.220","isp":"电信",
// "region_id":"420000","region":"湖北","country_id":"CN","city_id":"420100"}
public class IPBean {
    private String area;
    private String country;
    private String long_ip;
    private String city;
    private String ip;
    private String isp;
    private String region_id;
    private String region;
    private String country_id;
    private String city_id;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLong_ip() {
        return long_ip;
    }

    public void setLong_ip(String long_ip) {
        this.long_ip = long_ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }
}
