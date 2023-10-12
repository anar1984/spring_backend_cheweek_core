package com.cheweek.appcheweekspace.erp.service.core;

import com.cheweek.appcheweekspace.erp.repository.core.CountryRepository;
import com.cheweek.appcheweekspace.erp.dto.core.CountryDTO;
import com.cheweek.appcheweekspace.erp.entity.core.Country;
import com.cheweek.appcheweekspace.erp.mapper.core.CountryMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryReadService {

    final CountryRepository repository;
    final CountryMapper mapper;

    public List<CountryDTO> getCountryList() {
        List<Country> entityList = repository.findAllByStatus("A");
        List<CountryDTO> countryDTOList = entityList.stream().map(mapper::countryEntityToDTO).toList();

        return countryDTOList;
    }
}