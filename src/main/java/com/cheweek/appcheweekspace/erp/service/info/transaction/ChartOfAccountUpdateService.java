package com.cheweek.appcheweekspace.erp.service.info.transaction;

import com.cheweek.appcheweekspace.erp.dto.info.transaction.Request.ChartOfAccountUpdateRequestDTO;
import com.cheweek.appcheweekspace.erp.repository.info.transaction.ChartOfAccountRepository;
import com.cheweek.appcheweekspace.erp.custom_exception.IdNotFoundException;
import com.cheweek.appcheweekspace.erp.entity.info.transaction.ChartOfAccount;
import com.cheweek.appcheweekspace.erp.mapper.transaction.ChartOfAccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChartOfAccountUpdateService {
    private final ChartOfAccountRepository repository;
    private final ChartOfAccountMapper mapper;

    public void update(ChartOfAccountUpdateRequestDTO updateRequestDTO) {
        ChartOfAccount chartOfAccount = repository
                .findByIdAndStatus(updateRequestDTO.getId(), "A");

        if (chartOfAccount == null) {
            IdNotFoundException idNotFoundException = new IdNotFoundException();
            idNotFoundException.setMessage("Id Not found");
            throw idNotFoundException;
        }

        chartOfAccount = mapper.updateRequestDTOToEntity(chartOfAccount, updateRequestDTO);
        repository.save(chartOfAccount);
    }
}
