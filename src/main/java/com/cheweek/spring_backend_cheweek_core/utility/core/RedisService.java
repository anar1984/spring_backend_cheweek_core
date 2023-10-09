package com.cheweek.spring_backend_cheweek_core.utility.core;

import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Log4j2
public class RedisService {

    private final HashOperations<String, String, String> hashOperations;
    private final PropertyService propertyService;

    public RedisService(RedisTemplate<String, String> redisTemplate, PropertyService propertyService) {
        this.hashOperations = redisTemplate.opsForHash();
        this.propertyService = propertyService;
    }
    public void addToHash(String hashKey, String field, String value) {
        if(hashKey == null || field == null ){
            return;
        }
        hashOperations.put(hashKey, field, value);
    }
    public String getFromHash(String hashKey, String field) {
        return hashOperations.get(hashKey, field);
    }

    public void setRedis(String hashKey, String key, Object info){
        if(key==null || key.trim().length()==0){
            return;
        }
        String hash= propertyService.getProperty(hashKey);
        JSONObject jsonObject = new JSONObject(info);
        addToHash(hash,key,jsonObject.toString());
    }
    public Object getRedis(String hashKey,String key){
        if(key==null || key.trim().length()==0){
            return null ;
        }
        final String hash= propertyService.getProperty(hashKey);
        String obj  = getFromHash(hash,key);
        ModelMapper mapper = new ModelMapper();
        return mapper.map(obj,Object.class);
    }

    public List<Object>  getValueList(String hashTable, Set<String> keyList){
        List<Object> list  = new ArrayList<>();
        for (String key : keyList){
            Object o = new Object();
            o = getRedis(hashTable ,key);
            list.add(o);
        }
        return list;
    }
}
