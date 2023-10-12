package com.cheweek.appcheweekspace.erp.controller.info.transaction;

import com.cheweek.appcheweekspace.erp.dto.info.transaction.Request.ChartOfAccountCreateRequestDTO;
import com.cheweek.appcheweekspace.erp.dto.info.transaction.Request.ChartOfAccountReadRequestDTO;
import com.cheweek.appcheweekspace.erp.dto.info.transaction.Request.ChartOfAccountUpdateRequestDTO;
import com.cheweek.appcheweekspace.erp.dto.info.transaction.Response.ChartOfAccountReadResponseDTO;
import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
import com.cheweek.appcheweekspace.erp.service.info.transaction.ChartOfAccountCreateService;
import com.cheweek.appcheweekspace.erp.service.info.transaction.ChartOfAccountDeleteService;
import com.cheweek.appcheweekspace.erp.service.info.transaction.ChartOfAccountReadService;
import com.cheweek.appcheweekspace.erp.service.info.transaction.ChartOfAccountUpdateService;
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

@RestController
@RequestMapping("/info/transaction/chart-of-account")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class ChartOfAccountController {

    private final ChartOfAccountCreateService createService;
    private final ChartOfAccountUpdateService updateService;
    private final ChartOfAccountDeleteService deleteService;
    private final ChartOfAccountReadService readService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid ChartOfAccountCreateRequestDTO requestDTO) {
        createService.create(requestDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid ChartOfAccountUpdateRequestDTO requestDTO) {
        updateService.update(requestDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> update(@RequestBody @Valid GetObjectById requestDTO) {
        deleteService.delete(requestDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/read")
    public ResponseEntity<List<ChartOfAccountReadResponseDTO>> listApi(
            @RequestBody ChartOfAccountReadRequestDTO requestDTO) {
        return ResponseEntity.ok(readService.listApi(requestDTO));
    }

}
