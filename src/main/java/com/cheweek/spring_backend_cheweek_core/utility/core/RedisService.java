package com.cheweek.spring_backend_cheweek_core.utility.core;

import com.cheweek.spring_backend_cheweek_core.filter.RequestCachingFilter;
import com.cheweek.spring_backend_cheweek_core.utility.Converter;
import com.cheweek.spring_backend_cheweek_core.utility.QLogger;
import com.cheweek.spring_backend_cheweek_core.utility.SessionManager;
import com.cheweek.spring_backend_cheweek_core.utility.UserInfo;
import org.json.JSONObject;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private final RedisTemplate<String, String> redisTemplate;
    private final HashOperations<String, String, String> hashOperations;
    private final SessionManager sessionManager;
    private final PropertyService propertyService;
    final QLogger logger = QLogger.getLogger(RedisService.class);

    public RedisService(RedisTemplate<String, String> redisTemplate, SessionManager sessionManager, PropertyService propertyService) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.sessionManager = sessionManager;
        this.propertyService = propertyService;
    }


    public void setRedis(String hashKey, String key, UserInfo info){
        if(key==null || key.trim().length()==0){
            return;
        }
        info.setKey(key);
        JSONObject jsonObject = new JSONObject(info);
//        addToHash("spring_dev_token",key,jsonObject.toString());
        addToHash(hashKey,key,jsonObject.toString());

    }
    public UserInfo getRedis(String hashKey,String key){
        logger.info("hashKey : "+hashKey);
        if(key==null || key.trim().length()==0){
            return null ;
        }
        UserInfo info = new UserInfo();
//        String obj  = getFromHash("spring_dev_token",key);
        String map = propertyService.getProperty("chw.hashKeyToken");
        logger.info("map : "+map);
        String obj  = getFromHash(map,key);
//        Gson  gson = new Gson();
//        info = gson.fromJson(gson.toJson(obj),UserInfo.class);

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
        String map = propertyService.getProperty("chw.hashKeyToken");
        logger.info("hashKeysajgkaj : "+map);
        UserInfo info =getRedis(map,key);
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