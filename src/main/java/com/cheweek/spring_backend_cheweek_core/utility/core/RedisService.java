package com.cheweek.spring_backend_cheweek_core.utility.core;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisService {

    private final HashOperations<String, String, String> hashOperations;
    private final PropertyService propertyService;

    public RedisService(HashOperations<String, String, String> hashOperations, PropertyService propertyService) {
        this.hashOperations = hashOperations;
        this.propertyService = propertyService;
    }
    public void addToHash(String hashKey, String field, String value) {
        hashOperations.put(hashKey, field, value);
    }
    public String getFromHash(String hashKey, String field) {
        return hashOperations.get(hashKey, field);
    }

    public void setRedis(String hashKey, String key, Object info){
        if(key==null || key.trim().length()==0){
            return;
        }
        JSONObject jsonObject = new JSONObject(info);
        addToHash(hashKey,key,jsonObject.toString());
    }
    public Object getRedis(String hashKey,String key){
        if(key==null || key.trim().length()==0){
            return null ;
        }
        String obj  = getFromHash(hashKey,key);
        ModelMapper mapper = new ModelMapper();
        return mapper.map(obj,Object.class);
    }

    public List<Object>  getValueList(String hashTable,List<String>keyList){
        List<Object> list  = new ArrayList<>();
        for (String key : keyList){
            Object o = new Object();
            o = getRedis(hashTable ,key);
            list.add(o);
        }
        return list;
    }
}
