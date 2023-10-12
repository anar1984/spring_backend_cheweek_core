package com.cheweek.appcheweekspace.erp.mapper.price_list_sale;

import com.cheweek.appcheweekspace.erp.dto.info.price_list_sale.PriceListCirculationCreateDTO;
import com.cheweek.appcheweekspace.erp.dto.info.price_list_sale.PriceListCirculationReadResponseDTO;
import com.cheweek.appcheweekspace.erp.dto.info.price_list_sale.PriceListCirculationUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.price_list_sale.PriceListSale;
import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PriceListCirculationMapper {
    PriceListSale priceCreateCirculationDTOToEntity(PriceListCirculationCreateDTO dto);

    PriceListSale priceListUpdateRequestDTOToEntity(@MappingTarget PriceListSale priceListSale, PriceListCirculationUpdateDTO priceListCirculationUpdateDTO);
    PriceListSale priceListDeleteRequestDTOToEntity(@MappingTarget PriceListSale priceListSale, GetObjectById getObjectById);

    PriceListCirculationReadResponseDTO readEntityToResponseDTO(PriceListSale priceListSale);


}
