package com.cheweek.appcheweekspace.erp.service.info.product;

import com.cheweek.appcheweekspace.erp.dto.info.product.ProductInsertDTO;
import com.cheweek.appcheweekspace.erp.entity.info.product.Product;
import com.cheweek.appcheweekspace.erp.mapper.product.ProductMapper;
import com.cheweek.appcheweekspace.erp.repository.info.ProductRepository;
import com.cheweek.appcheweekspace.utility.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ProductInsertService {

    final ProductRepository productRepository;
    final SessionManager sessionManager;
    final ProductMapper productMapper;

    public void insertProduct(ProductInsertDTO dto){
        Product product = productMapper.dtoToEntityForSave(dto);
        if(product!=null) productRepository.save(product);

    }


}
