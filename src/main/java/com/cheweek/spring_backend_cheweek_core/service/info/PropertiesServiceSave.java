package com.cheweek.spring_backend_cheweek_core.service.info;

import com.cheweek.spring_backend_cheweek_core.dto.CorePropertiesDTO;
import com.cheweek.spring_backend_cheweek_core.entity.CoreProperties;
import com.cheweek.spring_backend_cheweek_core.mapper.CorePropertiesMapper;
import com.cheweek.spring_backend_cheweek_core.repository.CorePropertiesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PropertiesServiceSave {
    final CorePropertiesRepository repository;
    final CorePropertiesMapper mapper;



    public void save(CorePropertiesDTO dto){
        log.info(dto);
        CoreProperties  entity = mapper.dtoToEntity(dto);
        log.info(entity);
        repository.save(entity);

    }
}
