package com.cheweek.appcheweekspace.erp.service.info.transaction;

import com.cheweek.appcheweekspace.erp.repository.info.transaction.ChartOfAccountRepository;
import com.cheweek.appcheweekspace.erp.custom_exception.IdNotFoundException;
import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
import com.cheweek.appcheweekspace.erp.entity.info.transaction.ChartOfAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChartOfAccountDeleteService {
    private final ChartOfAccountRepository repository;

    public void delete(GetObjectById dto) {
        ChartOfAccount chartOfAccount = repository.findByIdAndStatus(dto.getId(), "A");

        if (chartOfAccount == null) {
            IdNotFoundException idNotFoundException = new IdNotFoundException();
            idNotFoundException.setMessage("Id Not found");
            throw idNotFoundException;
        }

        chartOfAccount.setStatus("D");
        repository.save(chartOfAccount);
    }

}
