package com.cheweek.appcheweekspace.erp.service.info.price_list_sale;

import com.cheweek.appcheweekspace.erp.repository.info.product_list_sale.PriceListSaleRepository;
import com.cheweek.appcheweekspace.erp.custom_exception.IdNotFoundException;
import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
import com.cheweek.appcheweekspace.erp.entity.info.price_list_sale.PriceListSale;
import com.cheweek.appcheweekspace.erp.mapper.price_list_sale.PriceListCirculationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceListCirculationReadInfoService {
    private final PriceListSaleRepository priceListSaleRepository;
    private final PriceListCirculationMapper priceListCirculationMapper;

    public PriceListSale readInfo(GetObjectById getObjectById){
        PriceListSale priceListSale = priceListSaleRepository
                .findByIdAndStatus(getObjectById.getId(), "A");
        if (priceListSale == null) {
            IdNotFoundException idNotFoundException = new IdNotFoundException();
            idNotFoundException.setMessage("This id doesn't exist");
            throw idNotFoundException;
        }
        return priceListSale;

    }

}
