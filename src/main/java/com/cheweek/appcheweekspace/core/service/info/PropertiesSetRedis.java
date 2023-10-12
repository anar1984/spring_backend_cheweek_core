package com.cheweek.appcheweekspace.core.service.info;

import com.cheweek.appcheweekspace.utility.core.PropertyService;
import com.cheweek.appcheweekspace.core.dto.PropertiesDTO;
import com.cheweek.appcheweekspace.core.entity.info.PropertiesEntity;
import com.cheweek.appcheweekspace.core.mapper.PropertiesMapper;
import com.cheweek.appcheweekspace.core.repository.info.PropertiesEntityRepository;
import com.cheweek.appcheweekspace.utility.core.RedisService;
import com.cheweek.appcheweekspace.utility.coreentity.CoreSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class PropertiesSetRedis {
    private final PropertiesEntityRepository properties;
    private final CoreSpecification<PropertiesEntity> specification;
    private final PropertiesMapper mapper;
    private final RedisService redisService;
    private final PropertyService propertyService;

    public void setPropertiesToRedis(){
        specification.setAnd("status","A");
        specification.setAnd("isActive","A");
        List<PropertiesEntity> list = properties.findAll(specification.getSpecification());
        List<PropertiesDTO> listDto = list.stream().map(mapper::entityToDto).toList();

        for (PropertiesDTO dto : listDto){
            log.info(dto.getPropertyCode()+"-"+dto.getPropertyKey());
            log.info(propertyService.getProperty("chw.propertiesList"));
            redisService.setRedis("chw.propertiesList",dto.getPropertyCode()+"-"+dto.getPropertyKey(),dto);


        }



    }
}
