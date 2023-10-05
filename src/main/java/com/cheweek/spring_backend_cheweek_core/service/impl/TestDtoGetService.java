package com.cheweek.spring_backend_cheweek_core.service.impl;

import com.cheweek.spring_backend_cheweek_core.dto.TestDto;
import com.cheweek.spring_backend_cheweek_core.entity.CoreProperties;
import com.cheweek.spring_backend_cheweek_core.mapper.TestDtoMapper;
import com.cheweek.spring_backend_cheweek_core.projection.TestMyProjection;
import com.cheweek.spring_backend_cheweek_core.repository.CorePropertiesRepository;
import com.cheweek.spring_backend_cheweek_core.repository.ProductTypeRepository;
import com.cheweek.spring_backend_cheweek_core.service.ApiService;
import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import com.cheweek.spring_backend_cheweek_core.utility.CarrierValidation;
import com.cheweek.spring_backend_cheweek_core.utility.coreentity.CorePagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestDtoGetService implements ApiService {
    private final CorePropertiesRepository properties;
    private final CarrierValidation validation;
    private final TestDtoMapper mapper;
    private final CorePagination pagination;
    private final ProductTypeRepository productTypeRepository;

    @Override
    public Carrier run(Carrier carrier) {
//        validation.addValidation(carrier,"propertyCode");
//        validation.hasError();
//        Page<CoreProperties> list = properties.findAllByPropertyCodeAndStatusAndIsActive(carrier.get("propertyCode"),"A","A",pagination.getPagination(carrier.get("page"),carrier.get("count")));
//
//        carrier.setList("propertyKey",list.stream().toList());
        return carrier;
    }


}
