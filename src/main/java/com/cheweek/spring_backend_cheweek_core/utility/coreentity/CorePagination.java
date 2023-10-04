package com.cheweek.spring_backend_cheweek_core.utility.coreentity;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class CorePagination {

    public Pageable getPagination(String page,String count){
        int pageInt = Integer.parseInt((page==null|| page.trim().isEmpty())?"0":page);
        int pageCount = Integer.parseInt((count==null|| count.trim().isEmpty())?"50":count);
        return  PageRequest.of(pageInt,pageCount).withSort(Sort.by("id").descending());


    }
}
