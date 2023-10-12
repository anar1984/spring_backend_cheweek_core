package com.cheweek.appcheweekspace.core.service.impl;

import com.cheweek.appcheweekspace.utility.Carrier;
import com.cheweek.appcheweekspace.utility.CarrierValidation;
import com.cheweek.appcheweekspace.core.mapper.TestDtoMapper;
import com.cheweek.appcheweekspace.core.repository.info.PropertiesEntityRepository;
import com.cheweek.appcheweekspace.core.service.ApiService;
import com.cheweek.appcheweekspace.utility.coreentity.CorePagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestDtoGetService implements ApiService {
    private final PropertiesEntityRepository properties;
    private final CarrierValidation validation;
    private final TestDtoMapper mapper;
    private final CorePagination pagination;

    @Override
    public Carrier run(Carrier carrier) {
//        validation.addValidation(carrier,"propertyCode");
//        validation.hasError();
//        Page<PropertiesEntity> list = properties.findAllByPropertyCodeAndStatusAndIsActive(carrier.get("propertyCode"),"A","A",pagination.getPagination(carrier.get("page"),carrier.get("count")));
//
//        carrier.setList("propertyKey",list.stream().toList());
        return carrier;
    }


}
