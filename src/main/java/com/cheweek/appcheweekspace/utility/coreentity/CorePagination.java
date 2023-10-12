package com.cheweek.appcheweekspace.utility.coreentity;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class CorePagination {

    public Pageable getPagination(String page,String count){
        int pageInt = Integer.parseInt((page==null|| page.trim().isEmpty())?"0":page);
        if(pageInt<0){
            pageInt=0;
        }
        int pageCount = Integer.parseInt((count==null|| count.trim().isEmpty())?"50":count);
        return  PageRequest.of(pageInt,pageCount).withSort(Sort.by("id").descending());
    }
}