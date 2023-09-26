package com.cheweek.spring_backend_cheweek_core.utility;


import com.cheweek.spring_backend_cheweek_core.exception.ConverterException;
import com.google.gson.Gson;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Converter <T, V>{

    public V convertMap(Map<T,T> t, V v){
        try {
            Gson gson = new Gson();
            String str  = gson.toJson(t);
            v = (V) gson.fromJson(str,v.getClass());
            System.out.println("test 1 "+v);
            return v;
        }catch (Exception ex){
            throw new ConverterException();
        }

    }

    public V convertMap(String t, V v){
        try {
            Gson gson = new Gson();

            v = (V) gson.fromJson(t,v.getClass());
            return v;
        }catch (Exception ex){
            ConverterException converterException = new ConverterException();
            converterException.setErrorType("error");
            converterException.setMessageCode("chw-"+converterException.getStatusCode());
            converterException.setMessage("Convert exception");
            throw new ConverterException();
        }

    }


    public Map<T, T> convertDto(V v ){
        try {
            Gson gson = new Gson();
            String str  = gson.toJson(v);
            Map<T,T> t = new HashMap<>();
            t = gson.fromJson((String) str, Map.class);
            return t;
        }catch (Exception ex){
            ConverterException converterException = new ConverterException();
            converterException.setErrorType("error");
            converterException.setMessageCode("chw-"+converterException.getStatusCode());
            converterException.setMessage("Convert exception");
            throw new ConverterException();
        }


    }
    public List convertObject( Object o){
        try {
            Gson gson = new Gson();
            String str  = gson.toJson(o);
            List<Map<T,T>> t = new ArrayList<>();
            t = gson.fromJson((String) str, List.class);
            return t;
        }catch (Exception ex){
            ConverterException converterException = new ConverterException();
            converterException.setErrorType("error");
            converterException.setMessageCode("chw-"+converterException.getStatusCode());
            converterException.setMessage("Convert exception");
            throw new ConverterException();
        }


    }



    public List<Map<T,T>> convertListDto(List<V> list){
        List<Map<T,T>> rs = new ArrayList<>();
        for (V v :list){
            rs.add(convertDto(v));
        }
        return rs;

    }


    public List<V> convertListMap( List<Map<T, T>> list,V v){
        List<V> rs  = new ArrayList<>();
        for (Map<T,T> t :list){
            rs.add(convertMap(t,v));
        }
        return rs;


    }

}
