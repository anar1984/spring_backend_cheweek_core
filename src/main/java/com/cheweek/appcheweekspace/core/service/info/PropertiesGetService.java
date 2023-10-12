package com.cheweek.appcheweekspace.core.service.info;


import com.cheweek.appcheweekspace.utility.Carrier;
import com.cheweek.appcheweekspace.utility.CarrierValidation;
import com.cheweek.appcheweekspace.core.dto.PropertiesDTO;
import com.cheweek.appcheweekspace.core.mapper.PropertiesMapper;
import com.cheweek.appcheweekspace.core.repository.info.PropertiesEntityRepository;
import com.cheweek.appcheweekspace.core.service.ApiService;
import com.cheweek.appcheweekspace.utility.coreentity.CorePagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertiesGetService implements ApiService {
    private final PropertiesEntityRepository properties;
    private final CarrierValidation validation;
    private final CorePagination pagination;
    private  final PropertiesMapper mapper;

    @Override
    public Carrier run(Carrier carrier) {
        validation.addValidation(carrier,"propertyCode");
        validation.hasError();
        carrier.setList("properties",getList(carrier.get("propertyCode"),carrier.get("page"),carrier.get("page")));
        return carrier;
    }
    private List<PropertiesDTO> getList(String propertyCode, String page, String count ){
        return properties.findAllByPropertyCodeAndStatusAndIsActive(propertyCode,"A","A",pagination.getPagination(page,count)).stream().map(mapper::entityToDto).toList();

    }


}
