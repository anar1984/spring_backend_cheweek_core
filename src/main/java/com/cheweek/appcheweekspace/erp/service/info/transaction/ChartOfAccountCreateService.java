package com.cheweek.appcheweekspace.erp.service.info.transaction;

import com.cheweek.appcheweekspace.erp.dto.info.transaction.Request.ChartOfAccountCreateRequestDTO;
import com.cheweek.appcheweekspace.erp.repository.info.transaction.ChartOfAccountRepository;
import com.cheweek.appcheweekspace.erp.entity.info.transaction.ChartOfAccount;
import com.cheweek.appcheweekspace.erp.mapper.transaction.ChartOfAccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChartOfAccountCreateService {
    private final ChartOfAccountRepository repository;
    private final ChartOfAccountMapper mapper;

    public void create(ChartOfAccountCreateRequestDTO createRequestDTO) {
        ChartOfAccount chartOfAccount = mapper.createRequestDTOToEntity(createRequestDTO);
        repository.save(chartOfAccount);
    }
}
