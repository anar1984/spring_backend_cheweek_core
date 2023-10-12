package com.cheweek.appcheweekspace.utility.core;

import com.cheweek.appcheweekspace.utility.SessionManager;
import com.cheweek.appcheweekspace.utility.Converter;
import com.cheweek.appcheweekspace.utility.UserInfo;
import org.json.JSONObject;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceUser {
    private final RedisTemplate<String, String> redisTemplate;
    private final HashOperations<String, String, String> hashOperations;
    private final SessionManager sessionManager;
    private final PropertyService propertyService;

    public RedisServiceUser(RedisTemplate<String, String> redisTemplate, SessionManager sessionManager, PropertyService propertyService) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.sessionManager = sessionManager;
        this.propertyService = propertyService;
    }


    public void setRedis(String hashKey,String key,UserInfo info){
        if(key==null || key.trim().length()==0){
            return;
        }
        info.setKey(key);
        JSONObject jsonObject = new JSONObject(info);
        addToHash(hashKey,key,jsonObject.toString());
    }
    public UserInfo getRedis(String hashKey,String key){
        if(key==null || key.trim().length()==0){
            return null ;
        }
        UserInfo info = new UserInfo();
        String obj  = getFromHash(hashKey,key);
        Converter<String, UserInfo> converter = new Converter<>();
        info = converter.convertMap(obj,info);
        return info;
    }
    public void addToHash(String hashKey, String field, String value) {
        hashOperations.put(hashKey, field, value);
    }

    public String getFromHash(String hashKey, String field) {
        return hashOperations.get(hashKey, field);
    }
    public void setSession(String key ,String lang){
        if(key==null || key.trim().length()==0){
            return;
        }
        UserInfo info =getRedis(propertyService.getProperty("chw.hashKeyToken"),key);
        sessionManager.setCurrentUserId(info.getCurrentUserId());
        sessionManager.setToken(key);
        sessionManager.setCurrentUserName(info.getCurrentUserName());
        sessionManager.setUserId(info.getCurrentUserId());
        if(lang == null || lang.length()==0){
            return;
        }
        sessionManager.setLang(info.getCurrentUserId());

    }

}