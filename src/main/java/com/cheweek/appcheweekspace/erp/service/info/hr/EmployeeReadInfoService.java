package com.cheweek.appcheweekspace.erp.service.info.hr;


import com.cheweek.appcheweekspace.erp.repository.info.hr.EmployeeRepository;
import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeeReadInfoDTO;
import com.cheweek.appcheweekspace.erp.entity.info.hr.Employee;
import com.cheweek.appcheweekspace.erp.mapper.hr.EmployeeMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeReadInfoService {

    final EmployeeRepository employeeRepository;
    final EmployeeMapper mapper;

    public EmployeeReadInfoDTO getEmployeeInfo(GetObjectById id) {

        Employee employee = employeeRepository.findByIdAndStatus(id.getId(), "A").orElse(null);

        EmployeeReadInfoDTO employeeReadInfoDTO = mapper.employeeReadInfoEntityToDTO(employee);

        return employeeReadInfoDTO;
    }
}
