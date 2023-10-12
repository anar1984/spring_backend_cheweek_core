package com.cheweek.appcheweekspace.erp.mapper.transaction;

import com.cheweek.appcheweekspace.erp.dto.info.transaction.Request.ChartOfAccountCreateRequestDTO;
import com.cheweek.appcheweekspace.erp.dto.info.transaction.Request.ChartOfAccountUpdateRequestDTO;
import com.cheweek.appcheweekspace.erp.dto.info.transaction.Response.ChartOfAccountReadResponseDTO;
import com.cheweek.appcheweekspace.erp.entity.info.transaction.ChartOfAccount;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChartOfAccountMapper {
    ChartOfAccount createRequestDTOToEntity(ChartOfAccountCreateRequestDTO createRequestDTO);

    ChartOfAccount updateRequestDTOToEntity(@MappingTarget ChartOfAccount chartOfAccount, ChartOfAccountUpdateRequestDTO updateRequestDTO);

    ChartOfAccountReadResponseDTO readEntityToResponseDTO(ChartOfAccount chartOfAccount);
}
