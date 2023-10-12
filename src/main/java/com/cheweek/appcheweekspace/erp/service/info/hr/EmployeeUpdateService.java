package com.cheweek.appcheweekspace.erp.service.info.hr;

import com.cheweek.appcheweekspace.erp.custom_exception.EmployeeCategoryIdNotFoundException;
import com.cheweek.appcheweekspace.erp.custom_exception.EmployeesIdNotFoundException;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeeUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.hr.Employee;
import com.cheweek.appcheweekspace.erp.mapper.hr.EmployeeMapper;
import com.cheweek.appcheweekspace.erp.repository.info.hr.EmployeeCategoryRepository;
import com.cheweek.appcheweekspace.erp.repository.info.hr.EmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeUpdateService {
    final EmployeeRepository employeeRepository;
    final EmployeeCategoryRepository categoryRepository;
    final EmployeeMapper mapper;

    public void updateEmployee(EmployeeUpdateDTO dto) {

        Employee employee = employeeRepository.findById(dto.getId()).orElseThrow(() -> {
            EmployeesIdNotFoundException idNotFoundException = new EmployeesIdNotFoundException();
            idNotFoundException.setMessage("Employee id not found!");
            throw idNotFoundException;
        });

        employee = mapper.employeeUpdateDTOToEntity(employee, dto);

        // check mandatory keys from data_base

        if (!categoryRepository.existsById(dto.getFkEmployeeCategoryId()) && !dto.getFkEmployeeCategoryId().isBlank()) {
            EmployeeCategoryIdNotFoundException categoryIdNotFoundException = new EmployeeCategoryIdNotFoundException();
            categoryIdNotFoundException.setMessage("Employee category id not found!");
            throw categoryIdNotFoundException;
        }

        employeeRepository.save(employee);
    }
}