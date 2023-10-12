package com.cheweek.appcheweekspace.core.service.info;

import com.cheweek.appcheweekspace.core.dto.PropertiesDTO;
import com.cheweek.appcheweekspace.core.entity.info.PropertiesEntity;
import com.cheweek.appcheweekspace.core.mapper.PropertiesMapper;
import com.cheweek.appcheweekspace.core.repository.info.PropertiesEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PropertiesServiceSave {
    final PropertiesEntityRepository repository;
    final PropertiesMapper mapper;



    public void save(PropertiesDTO dto){
        log.info(dto);
        PropertiesEntity entity = mapper.dtoToEntity(dto);
        log.info(entity);
        repository.save(entity);

    }
}
