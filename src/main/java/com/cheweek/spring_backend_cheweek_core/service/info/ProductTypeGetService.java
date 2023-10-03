package com.cheweek.spring_backend_cheweek_core.service.info;

import com.cheweek.spring_backend_cheweek_core.entity.ProductType;
import com.cheweek.spring_backend_cheweek_core.repository.ProductTypeRepository;
import com.cheweek.spring_backend_cheweek_core.service.ApiService;
import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductTypeGetService implements ApiService {
    final  ProductTypeRepository productTypeRepository;
    @Override
    public Carrier run(Carrier carrier) {
        List<ProductType> list =  productTypeRepository.findAll();
        carrier.setList("product_type",list);
        return carrier;
    }
}
