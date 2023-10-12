package com.cheweek.appcheweekspace.erp.service.info.transaction;

import com.cheweek.appcheweekspace.erp.dto.info.transaction.Request.ChartOfAccountReadRequestDTO;
import com.cheweek.appcheweekspace.erp.dto.info.transaction.Response.ChartOfAccountReadResponseDTO;
import com.cheweek.appcheweekspace.erp.repository.info.transaction.ChartOfAccountRepository;
import com.cheweek.appcheweekspace.erp.entity.info.transaction.ChartOfAccount;
import com.cheweek.appcheweekspace.erp.mapper.transaction.ChartOfAccountMapper;
import com.cheweek.appcheweekspace.utility.coreentity.CoreSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChartOfAccountReadService {
    private final ChartOfAccountRepository repository;
    private final ChartOfAccountMapper mapper;

    public List<ChartOfAccountReadResponseDTO> listApi(ChartOfAccountReadRequestDTO requestDTO) {
        CoreSpecification<?> specification = new CoreSpecification<>();
        specification.setAnd("status", "A");
        specification.setAndLike("section", requestDTO.getSection());
        specification.setAndLike("heading", requestDTO.getHeading());
        specification.setAndLike("accountNumber", requestDTO.getAccountNumber());
        specification.setAndLike("subAccountNumber", requestDTO.getSubAccountNumber());
        specification.setAndLike("subAccountName", requestDTO.getSubAccountName());

        List<ChartOfAccount> chartOfAccounts = repository.findAll(specification.getSpecification());
        return chartOfAccounts.stream()
                .map(mapper::readEntityToResponseDTO)
                .toList();
    }
}
