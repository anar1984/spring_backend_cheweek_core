package com.cheweek.spring_backend_cheweek_core.service.info;


import com.cheweek.spring_backend_cheweek_core.entity.CoreProperties;
import com.cheweek.spring_backend_cheweek_core.repository.CorePropertiesRepository;
import com.cheweek.spring_backend_cheweek_core.service.ApiService;
import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import com.cheweek.spring_backend_cheweek_core.utility.CarrierValidation;
import com.cheweek.spring_backend_cheweek_core.utility.coreentity.CorePagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class PropertiesGetService implements ApiService {
    private final CorePropertiesRepository properties;
    private final CarrierValidation validation;
    private final CorePagination pagination;

    @Override
    public Carrier run(Carrier carrier) {
        validation.addValidation(carrier,"propertyCode");
        validation.hasError();
        carrier.setList("properties",getList(carrier.get("propertyCode"),carrier.get("page"),carrier.get("page")));
        return carrier;
    }
    private List<CoreProperties> getList(String propertyCode,String page,String count ){
        return properties.findAllByPropertyCodeAndStatusAndIsActive(propertyCode,"A","A",pagination.getPagination(page,count)).stream().toList();

    }
}
