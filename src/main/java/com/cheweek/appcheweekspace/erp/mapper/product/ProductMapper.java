package com.cheweek.appcheweekspace.erp.mapper.product;

import com.cheweek.appcheweekspace.erp.dto.info.product.ProductInsertDTO;
import com.cheweek.appcheweekspace.erp.entity.info.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    Product dtoToEntityForSave(ProductInsertDTO dto);

}
