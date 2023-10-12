package com.cheweek.appcheweekspace.erp.service.info.hr;

import com.cheweek.appcheweekspace.erp.repository.info.hr.EmployeeRepository;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeeFilterDTO;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeeReadDTO;
import com.cheweek.appcheweekspace.erp.entity.info.hr.Employee;
import com.cheweek.appcheweekspace.erp.mapper.hr.EmployeeMapper;
import com.cheweek.appcheweekspace.erp.repository.info.CompanyRepository;
import com.cheweek.appcheweekspace.utility.coreentity.CorePagination;
import com.cheweek.appcheweekspace.utility.coreentity.CoreSpecification;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeReadService {

    final EmployeeRepository employeeRepository;
    final EmployeeMapper mapper;
    final CompanyRepository companyRepository;
    final CorePagination pagination;


    // TODO: List dto gondermelidir mutleq!

    public List<EmployeeReadDTO> getEmployeeList(EmployeeFilterDTO dto) {
        CoreSpecification<?> specification = CoreSpecification.getInstance();
        // filters
        String fkCompanyId = dto.getFkCompanyId();
        String fkBranchId = dto.getFkBranchId();
        String fkDepartmentId = dto.getFkDepartmentId();
        String fkSectorId = dto.getFkSectorId();

        String firstName = dto.getFirstName();
        String surname = dto.getSurname();
        String middleName = dto.getMiddleName();
        String isActive = dto.getIsActive();

        String page = dto.getPage();

        specification.setAnd("status", "A");

        if (fkCompanyId != null && !fkCompanyId.isEmpty()) {
            specification.setIn("fkCompanyId", Arrays.asList(fkCompanyId.split(",")));
        }

        if (fkBranchId != null && !fkBranchId.isEmpty()) {
            specification.setIn("fkBranchId", Arrays.asList(fkBranchId.split(",")));
        }

        if (fkDepartmentId != null && !fkDepartmentId.isEmpty()) {
            specification.setIn("fkDepartmentId", Arrays.asList(fkDepartmentId.split(",")));
        }

        if (fkSectorId != null && !fkSectorId.isEmpty()) {
            specification.setIn("fkSectorId", Arrays.asList(fkSectorId.split(",")));
        }

        specification.setAnd("isActive", isActive);


        specification.setAndLike("firstName", firstName);


        specification.setAndLike("surname", surname);


        specification.setAndLike("middleName", middleName);

        List<Employee> entityList = employeeRepository.findAll(specification.getSpecification(), pagination.getPagination(page,"50")).stream().toList();
        List<EmployeeReadDTO> employeeList = entityList.stream().map(mapper::employeeReadEntityToDTO).toList();

        return employeeList;
    }
}
