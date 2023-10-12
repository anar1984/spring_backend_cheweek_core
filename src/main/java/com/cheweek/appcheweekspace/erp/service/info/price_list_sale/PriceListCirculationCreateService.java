package com.cheweek.appcheweekspace.erp.service.info.price_list_sale;

import com.cheweek.appcheweekspace.erp.repository.info.product_list_sale.PriceListSaleRepository;
import com.cheweek.appcheweekspace.erp.dto.info.price_list_sale.PriceListCirculationCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.price_list_sale.PriceListSale;
import com.cheweek.appcheweekspace.erp.mapper.price_list_sale.PriceListCirculationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class PriceListCirculationCreateService {
    final PriceListSaleRepository priceListSaleRepository;
    final PriceListCirculationMapper mapper;

    public void createCirculation(PriceListCirculationCreateDTO priceListCirculationCreateDTO) {

        PriceListSale priceListSale = mapper.priceCreateCirculationDTOToEntity(priceListCirculationCreateDTO);
        priceListSaleRepository.save(priceListSale);
    }
}