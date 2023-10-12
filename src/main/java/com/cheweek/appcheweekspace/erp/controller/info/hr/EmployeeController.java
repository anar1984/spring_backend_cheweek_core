package com.cheweek.appcheweekspace.erp.controller.info.hr;

import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
import com.cheweek.appcheweekspace.erp.dto.info.hr.*;
import com.cheweek.appcheweekspace.erp.service.info.hr.EmployeeCreateService;
import com.cheweek.appcheweekspace.erp.service.info.hr.EmployeeReadInfoService;
import com.cheweek.appcheweekspace.erp.service.info.hr.EmployeeReadService;
import com.cheweek.appcheweekspace.erp.service.info.hr.EmployeeUpdateService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/info/hr/employee")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class EmployeeController {

    final EmployeeReadService employeeReadService;
    final EmployeeReadInfoService employeeReadInfoService;
    final EmployeeCreateService employeeCreateService;
    final EmployeeUpdateService employeeUpdateService;
    final com.cheweek.appcheweekspace.erp.service.info.hr.EmployeeCategoryByStatusReadService EmployeeCategoryByStatusReadService;

    @PostMapping("/read")
    public List<EmployeeReadDTO> getEmployeeList(@Valid @RequestBody EmployeeFilterDTO dto) {
        return employeeReadService.getEmployeeList(dto);
    }

    @PostMapping("/read-info")
    public EmployeeReadInfoDTO getEmployeeInfo(@Valid @RequestBody GetObjectById id) {
        return employeeReadInfoService.getEmployeeInfo(id);
    }
    @PostMapping("/create")
    public ResponseEntity createEmployee(@Valid @RequestBody EmployeeCreateDTO dto) {
        employeeCreateService.createEmployee(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity updateEmployee(@Valid @RequestBody EmployeeUpdateDTO dto) {
        employeeUpdateService.updateEmployee(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/category")
    public List<EmployeeCategoryDTO> getEmployeeCategoryByStatus(@Valid @RequestBody EmployeeCategoryDTO dto) {
        return EmployeeCategoryByStatusReadService.getEmployeeCategoryByStatus(dto);
    }
}
