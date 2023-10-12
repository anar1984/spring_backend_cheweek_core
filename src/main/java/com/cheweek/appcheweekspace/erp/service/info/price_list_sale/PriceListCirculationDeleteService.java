package com.cheweek.appcheweekspace.erp.service.info.price_list_sale;

import com.cheweek.appcheweekspace.erp.repository.info.product_list_sale.PriceListSaleRepository;
import com.cheweek.appcheweekspace.erp.custom_exception.IdNotFoundException;
import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
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
public class PriceListCirculationDeleteService {
    final PriceListSaleRepository priceListSaleRepository;
    final PriceListCirculationMapper mapper;

    public void delete(GetObjectById getObjectById) {
        PriceListSale priceListSale = priceListSaleRepository
                .findByIdAndStatus(getObjectById.getId(), "A");
        if (priceListSale == null) {
            IdNotFoundException idNotFoundException = new IdNotFoundException();
            idNotFoundException.setMessage("This id doesn't exist");
            throw idNotFoundException;
        }
        priceListSale = mapper.priceListDeleteRequestDTOToEntity(priceListSale, getObjectById);
        priceListSaleRepository.delete(priceListSale);
    }
}
