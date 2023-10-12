package com.cheweek.appcheweekspace.erp.service.info.hr;

import com.cheweek.appcheweekspace.erp.repository.info.hr.EmployeePrivateInfoRepository;
import com.cheweek.appcheweekspace.erp.custom_exception.EmployeePrivateInfoFkUserIdNotFoundException;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeePrivateInfoCreateUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.hr.EmployeePrivateInfo;
import com.cheweek.appcheweekspace.erp.mapper.hr.EmployeePrivateInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeePrivateInfoUpdateService {
    final EmployeePrivateInfoRepository employeePrivateInfoRepository;
    final EmployeePrivateInfoMapper mapper;

    public void createUpdateEmployeePrivateInfo(EmployeePrivateInfoCreateUpdateDTO dto) {

        // check mandatory keys from data_base

        String id = dto.getId();
        System.out.println("id " + id);
        EmployeePrivateInfo privateInfo = employeePrivateInfoRepository.findById(id).orElse(null);

        if (privateInfo == null && id.isBlank()) {
            System.out.println("create " + id);
            privateInfo = mapper.employeePrivateInfoCreateDTOToEntity(dto);
            employeePrivateInfoRepository.save(privateInfo);
        } else if (privateInfo != null && !id.isBlank()) {
            System.out.println("update " + id);
            privateInfo = mapper.employeePrivateInfoUpdateDTOToEntity(privateInfo, dto);
            employeePrivateInfoRepository.save(privateInfo);
        } else {
            EmployeePrivateInfoFkUserIdNotFoundException idNotFoundException = new EmployeePrivateInfoFkUserIdNotFoundException();
            idNotFoundException.setMessage("Employee private info id not found!");
            throw idNotFoundException;
        }
    }
}
