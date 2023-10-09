package com.cheweek.spring_backend_cheweek_core.service.info;

import com.cheweek.spring_backend_cheweek_core.dto.PropertiesDTO;
import com.cheweek.spring_backend_cheweek_core.entity.PropertiesEntity;
import com.cheweek.spring_backend_cheweek_core.mapper.PropertiesMapper;
import com.cheweek.spring_backend_cheweek_core.repository.PropertiesEntityRepository;
import com.cheweek.spring_backend_cheweek_core.utility.core.PropertyService;
import com.cheweek.spring_backend_cheweek_core.utility.core.RedisService;
import com.cheweek.spring_backend_cheweek_core.utility.coreentity.CoreSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
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
