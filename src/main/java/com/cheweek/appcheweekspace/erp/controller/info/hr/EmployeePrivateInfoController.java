package com.cheweek.appcheweekspace.erp.controller.info.hr;

import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeeCategoryDTO;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeePrivateInfoCreateUpdateDTO;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeePrivateInfoReadInfoDTO;
import com.cheweek.appcheweekspace.erp.service.info.hr.EmployeePrivateInfoReadInfoService;
import com.cheweek.appcheweekspace.erp.service.info.hr.EmployeePrivateInfoUpdateService;
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
@RequestMapping("/info/hr/employee-private-info")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeePrivateInfoController {

    final EmployeePrivateInfoReadInfoService employeePrivateInfoReadInfoService;
    final EmployeePrivateInfoUpdateService employeePrivateInfoUpdateService;
    final com.cheweek.appcheweekspace.erp.service.info.hr.EmployeeCategoryByStatusReadService EmployeeCategoryByStatusReadService;

    @PostMapping("/read-info")
    public EmployeePrivateInfoReadInfoDTO getEmployeePrivateInfo(@Valid @RequestBody GetObjectById id) {
        return employeePrivateInfoReadInfoService.getEmployeePrivateInfo(id);
    }

    @PostMapping("/save")
    public ResponseEntity createUpdateEmployeePrivateInfo(@RequestBody EmployeePrivateInfoCreateUpdateDTO dto) {
        employeePrivateInfoUpdateService.createUpdateEmployeePrivateInfo(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/disability")
    public List<EmployeeCategoryDTO> getEmployeeDisabilityList(@RequestBody EmployeeCategoryDTO dto) {
        return EmployeeCategoryByStatusReadService.getEmployeeCategoryByStatus(dto);
    }
}

