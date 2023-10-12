package com.cheweek.appcheweekspace.erp.service.info.hr;

import com.cheweek.appcheweekspace.erp.repository.info.hr.EmployeeCategoryRepository;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeeCategoryDTO;
import com.cheweek.appcheweekspace.erp.entity.info.hr.EmployeeCategory;
import com.cheweek.appcheweekspace.erp.mapper.hr.EmployeeCategoryMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeCategoryByStatusReadService {
    final EmployeeCategoryRepository employeeCategoryRepository;
    final EmployeeCategoryMapper mapper;


    public List<EmployeeCategoryDTO> getEmployeeCategoryByStatus(EmployeeCategoryDTO dto) {

        String employeeStatus = dto.getEmployeeStatus();

        List<EmployeeCategory> entityList = employeeCategoryRepository.findAllByEmployeeStatusAndStatus(employeeStatus, "A");
        List<EmployeeCategoryDTO> categoryDTOList = entityList.stream().map(mapper::employeeCategoryEntityToDTO).toList();

        return categoryDTOList;
    }
}

