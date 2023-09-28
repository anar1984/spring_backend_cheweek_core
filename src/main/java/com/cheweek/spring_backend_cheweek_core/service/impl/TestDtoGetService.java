package com.cheweek.spring_backend_cheweek_core.service.impl;

import com.cheweek.spring_backend_cheweek_core.dto.TestDto;
import com.cheweek.spring_backend_cheweek_core.mapper.TestDtoMapper;
import com.cheweek.spring_backend_cheweek_core.projection.TestMyProjection;
import com.cheweek.spring_backend_cheweek_core.repository.CorePropertiesRepository;
import com.cheweek.spring_backend_cheweek_core.service.ApiService;
import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import com.cheweek.spring_backend_cheweek_core.utility.CarrierValidation;
import lombok.RequiredArgsConstructor;
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

    @Override
    public Carrier run(Carrier carrier) {
        validation.addValidation(carrier,"propertyCode");
        validation.hasError();
        List<TestDto>  list = new ArrayList<>();
        List<TestMyProjection> cp = properties.getAllByPropertyCodeAndStatusAndIsActive(carrier.get("propertyCode"),"A","A");
        if (cp != null) {

             list =  cp.stream().map(mapper::testMyProjectionToTestDto).collect(Collectors.toList());


        }
        carrier.setList("propertyKey",list );
        return carrier;
    }

}
