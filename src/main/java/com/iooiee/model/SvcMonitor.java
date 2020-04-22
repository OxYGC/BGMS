package com.iooiee.model;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * Time: 16:51
 */
public class SvcMonitor {
    String id;
    String ip;
    String port;
    String isLined;
    String online;
    String iafStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIsLined() {
        return isLined;
    }

    public void setIsLined(String isLined) {
        this.isLined = isLined;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getIafStatus() {
        return iafStatus;
    }

    public void setIafStatus(String iafStatus) {
        this.iafStatus = iafStatus;
    }
}
