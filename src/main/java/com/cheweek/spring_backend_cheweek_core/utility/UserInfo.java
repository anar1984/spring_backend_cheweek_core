package com.cheweek.spring_backend_cheweek_core.utility;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author baxtiyar03
 */
public class UserInfo {

    private String key ;
    private String currentUserId;
    private String currentUserName;
    private String currentThreadId;
    private String currentRoleId;
    private  String domain;

    public UserInfo(String key, String currentUserId, String currentUserName, String currentThreadId, String currentRoleId, String domain) {
        this.key = key;
        this.currentUserId = currentUserId;
        this.currentUserName = currentUserName;
        this.currentThreadId = currentThreadId;
        this.currentRoleId = currentRoleId;
        this.domain = domain;
    }

    public UserInfo() {
    }



    public void setKey(String key) {
        this.key = key;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public void setCurrentThreadId(String currentThreadId) {
        this.currentThreadId = currentThreadId;
    }

    public void setCurrentRoleId(String currentRoleId) {
        this.currentRoleId = currentRoleId;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getKey() {
        return this.key;
    }

    public String getCurrentUserId() {
        return this.currentUserId;
    }

    public String getCurrentUserName() {
        return this.currentUserName;
    }

    public String getCurrentThreadId() {
        return this.currentThreadId;
    }

    public String getCurrentRoleId() {
        return this.currentRoleId;
    }

    public String getDomain() {
        return this.domain;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "key=" + key + ", currentUserId=" + currentUserId + ", currentUserName=" + currentUserName + ", currentThreadId=" + currentThreadId + ", currentRoleId=" + currentRoleId + ", domain=" + domain + '}';
    }



}
