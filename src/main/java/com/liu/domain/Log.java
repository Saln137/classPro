package com.liu.domain;

public class Log {
    private int id;
    private String username;
    private String interIP;
    private  String outerIP;
    private  String address;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInterIP() {
        return interIP;
    }

    public void setInterIP(String interIP) {
        this.interIP = interIP;
    }

    public String getOuterIP() {
        return outerIP;
    }

    public void setOuterIP(String outerIP) {
        this.outerIP = outerIP;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
