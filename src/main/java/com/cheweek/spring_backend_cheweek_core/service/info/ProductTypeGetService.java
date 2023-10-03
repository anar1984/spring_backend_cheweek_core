package com.cheweek.spring_backend_cheweek_core.service.info;

import com.cheweek.spring_backend_cheweek_core.entity.ProductType;
import com.cheweek.spring_backend_cheweek_core.repository.ProductTypeRepository;
import com.cheweek.spring_backend_cheweek_core.service.ApiService;
import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import com.cheweek.spring_backend_cheweek_core.utility.coreentity.CorePagination;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductTypeGetService implements ApiService {
    final  ProductTypeRepository productTypeRepository;
    final CorePagination pagination;
    @Override
    public Carrier run(Carrier carrier) {
        Page<ProductType> list =  productTypeRepository.findAll(pagination.getPagination("",""));
        log.info("log "+list.get().toList());
        carrier.setList("product_type",list.stream().toList());
        return carrier;
    }
}
