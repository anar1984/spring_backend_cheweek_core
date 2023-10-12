package com.cheweek.appcheweekspace.erp.service.info.hr;

import com.cheweek.appcheweekspace.erp.repository.info.hr.EmployeePrivateInfoRepository;
import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeePrivateInfoReadInfoDTO;
import com.cheweek.appcheweekspace.erp.entity.info.hr.EmployeePrivateInfo;
import com.cheweek.appcheweekspace.erp.mapper.hr.EmployeePrivateInfoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeePrivateInfoReadInfoService {
    final EmployeePrivateInfoRepository employeePrivateInfoRepository;
    final EmployeePrivateInfoMapper mapper;

    public EmployeePrivateInfoReadInfoDTO getEmployeePrivateInfo(GetObjectById id) {

        String fkUserId = id.getId();
        System.out.println("fkUserId " + fkUserId);

        EmployeePrivateInfo privateInfo = employeePrivateInfoRepository.findByFkUserIdAndStatus(fkUserId, "A").orElse(null);

        EmployeePrivateInfoReadInfoDTO privateInfoReadInfoDTO = mapper.employeePrivateInfoReadInfoEntityToDTO(privateInfo);
        return privateInfoReadInfoDTO;

    }
}

