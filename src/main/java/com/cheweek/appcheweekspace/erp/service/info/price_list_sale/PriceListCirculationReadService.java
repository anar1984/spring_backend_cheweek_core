package com.cheweek.appcheweekspace.erp.service.info.price_list_sale;

import com.cheweek.appcheweekspace.erp.repository.info.product_list_sale.PriceListSaleRepository;
import com.cheweek.appcheweekspace.erp.custom_exception.ProductNotFoundException;
import com.cheweek.appcheweekspace.erp.custom_exception.ProductTypeNotFoundException;
import com.cheweek.appcheweekspace.erp.dto.info.price_list_sale.PriceListCirculationReadRequestDTO;
import com.cheweek.appcheweekspace.erp.dto.info.price_list_sale.PriceListCirculationReadResponseDTO;
import com.cheweek.appcheweekspace.erp.entity.info.price_list_sale.PriceListSale;
import com.cheweek.appcheweekspace.erp.mapper.price_list_sale.PriceListCirculationMapper;
import com.cheweek.appcheweekspace.utility.coreentity.CoreSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceListCirculationReadService {
    private final PriceListSaleRepository priceListSaleRepository;
    private final PriceListCirculationMapper priceListCirculationMapper;

    public List<PriceListCirculationReadResponseDTO> readApi(PriceListCirculationReadRequestDTO priceListCirculationReadRequestDTO) {
        CoreSpecification<?> coreSpecification = new CoreSpecification<>();
        coreSpecification.setAnd("status", "A");
        coreSpecification.setAnd("fkPriceProductId", priceListCirculationReadRequestDTO.getFkPriceProductId());
        coreSpecification.setAnd("fkPriceProductTypeId", priceListCirculationReadRequestDTO.getFkPriceProductTypeId());
        coreSpecification.setAndLike("fkCompanyId", priceListCirculationReadRequestDTO.getFkCompanyId());
        coreSpecification.setAndLike("fkBranchId", priceListCirculationReadRequestDTO.getFkBranchId());
        coreSpecification.setAndLike("circulationType", priceListCirculationReadRequestDTO.getCirculationType());
        coreSpecification.setAndLike("circulationMin", priceListCirculationReadRequestDTO.getCirculationMin());
        coreSpecification.setAndLike("circulationMax", priceListCirculationReadRequestDTO.getCirculationMax());
        coreSpecification.setAndLike("circulationUnit", priceListCirculationReadRequestDTO.getCirculationUnit());
        coreSpecification.setAndLike("mainPrice", priceListCirculationReadRequestDTO.getMainPrice());
        coreSpecification.setAndLike("discountAmount", priceListCirculationReadRequestDTO.getDiscountAmount());
        coreSpecification.setAndLike("discountPercent", priceListCirculationReadRequestDTO.getDiscountPercent());
        coreSpecification.setAndLike("circulationCurrency", priceListCirculationReadRequestDTO.getCirculationCurrency());
        coreSpecification.setAndLike("circulationCourse", priceListCirculationReadRequestDTO.getCirculationCourse());
        coreSpecification.setAndLike("circulationPriceAzn", priceListCirculationReadRequestDTO.getCirculationPriceAzn());

        if(priceListCirculationReadRequestDTO.getFkPriceProductId() == null || priceListCirculationReadRequestDTO.getFkPriceProductId().trim().length() == 0){
            ProductNotFoundException productNotFoundException = new ProductNotFoundException();
            productNotFoundException.setMessage("Product id is empty");
            throw productNotFoundException;
        }

        if(priceListCirculationReadRequestDTO.getFkPriceProductTypeId() == null || priceListCirculationReadRequestDTO.getFkPriceProductTypeId().trim().length() == 0){
            ProductTypeNotFoundException productTypeNotFoundException = new ProductTypeNotFoundException();
            productTypeNotFoundException.setMessage("Product type id is empty");
            throw productTypeNotFoundException;
        }



        List<PriceListSale> priceListSales = priceListSaleRepository.findAll(coreSpecification.getSpecification());
        return priceListSales.stream()
                .map(priceListCirculationMapper::readEntityToResponseDTO)
                .toList();
    }
         }


