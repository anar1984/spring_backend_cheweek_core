package com.cheweek.appcheweekspace.erp.service.core;

import com.cheweek.appcheweekspace.erp.repository.core.CityRepository;
import com.cheweek.appcheweekspace.erp.dto.core.CityDTO;
import com.cheweek.appcheweekspace.erp.entity.core.City;
import com.cheweek.appcheweekspace.erp.mapper.core.CityMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityReadService {

    final CityRepository repository;
    final CityMapper mapper;

    public List<CityDTO> getCityByCountry(CityDTO dto) {

        String fkCountryId = dto.getFkCountryId();


        List<City> entityList = repository.findAllByFkCountryIdAndStatus(fkCountryId, "A");
        List<CityDTO> cityDTOList = entityList.stream().map(mapper::cityEntityToDTO).toList();
        return cityDTOList;
    }
}
