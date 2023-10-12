package com.cheweek.appcheweekspace.erp.service.info.price_list_sale;

import com.cheweek.appcheweekspace.erp.repository.info.product_list_sale.PriceListSaleRepository;
import com.cheweek.appcheweekspace.erp.custom_exception.IdNotFoundException;
import com.cheweek.appcheweekspace.erp.dto.info.price_list_sale.PriceListCirculationUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.price_list_sale.PriceListSale;
import com.cheweek.appcheweekspace.erp.mapper.price_list_sale.PriceListCirculationMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class PriceListCirculationUpdateService {
    final PriceListSaleRepository priceListSaleRepository;
    final PriceListCirculationMapper mapper;
    public void update(PriceListCirculationUpdateDTO priceListCirculationUpdateDTO) {
        PriceListSale priceListSale = priceListSaleRepository
                .findByIdAndStatus(priceListCirculationUpdateDTO.getId(), "A");

        if (priceListSale == null) {
            IdNotFoundException idNotFoundException = new IdNotFoundException();
            idNotFoundException.setMessage("This id doesn't exist");
            throw idNotFoundException;
        }

        priceListSale = mapper.priceListUpdateRequestDTOToEntity(priceListSale, priceListCirculationUpdateDTO);
        priceListSaleRepository.save(priceListSale);
    }
}
