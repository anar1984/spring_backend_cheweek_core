package com.cheweek.appcheweekspace.utility;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;

import java.io.Serializable;


import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Carrier implements Serializable {
    private static final long serialVersionUID = 1L;
    String apiId;
    Map<String, String> kv = new HashMap<>();
    Map<String, List<Object>> list = new HashMap<>();

    public Object getFields(Object dto) {

//         ObjectMapper mapper = new ObjectMapper();
//        dto = mapper.convertValue(this.fields,  dto.getClass());
        return convertDto(this.kv, dto);
    }
    public void setFields(Object dto) {

//         ObjectMapper mapper = new ObjectMapper();
//        dto = mapper.convertValue(this.fields,  dto.getClass());
        convertDto(this.kv, dto);
    }

    public void set(String key, String value) {
        this.kv.put(key, value);
    }

    public void setObjectForKv(Object dto) {
        Converter<String, Object> converter = new Converter<>();
        this.kv = converter.convertDto(dto);

    }


    public String get(String key) {

        return this.kv.get(key) == null ? "" : this.kv.get(key);
    }


    public List getList(String key, Object dto) {
        List<Object> list = new ArrayList<>();
        list = this.list.get(key);
        return list;
    }

    public void setList(String key, Object list) {
        Converter<String, CoreDto> converter = new Converter<>();
        this.list.put(key, converter.convertObject(list));
    }

    public List<Map> getList(String key) {
        return list.get(key).stream().map(v -> convertMap(v)).toList();

    }
//    public void setListFildsList(String key,List list){
//
//        this.list.put(key,list);
//    }

    private Object convertDto(Map<String, String> map, Object dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(map, dto);
        return dto;

    }

    private Map convertMap(Object dto) {
//        ObjectMapper oMapper = new ObjectMapper();
//        oMapper.convertValue(dto,Map.class);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Map.class);

    }


}
