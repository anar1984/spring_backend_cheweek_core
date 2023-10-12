package com.cheweek.appcheweekspace.erp.service.info.hr;

import com.cheweek.appcheweekspace.erp.custom_exception.EmployeeCategoryIdNotFoundException;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeeCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.hr.Employee;
import com.cheweek.appcheweekspace.erp.mapper.hr.EmployeeMapper;
import com.cheweek.appcheweekspace.erp.repository.info.hr.EmployeeCategoryRepository;
import com.cheweek.appcheweekspace.erp.repository.info.hr.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class EmployeeCreateService {

    final EmployeeRepository employeeRepository;
    final EmployeeCategoryRepository categoryRepository;
    final EmployeeMapper mapper;

    public void createEmployee(EmployeeCreateDTO dto) {

        // check mandatory keys from data_base
        if (!categoryRepository.existsById(dto.getFkEmployeeCategoryId()) && !dto.getFkEmployeeCategoryId().isBlank()) {
            EmployeeCategoryIdNotFoundException categoryIdNotFoundException = new EmployeeCategoryIdNotFoundException();
            categoryIdNotFoundException.setMessage("Employee category id not found!");
            throw categoryIdNotFoundException;
        }

        Employee employee = mapper.employeeCreateDTOToEntity(dto);
        employeeRepository.save(employee);
    }
}
