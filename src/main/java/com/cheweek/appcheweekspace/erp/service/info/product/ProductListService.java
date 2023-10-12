package com.cheweek.appcheweekspace.erp.service.info.product;

import com.cheweek.appcheweekspace.erp.repository.info.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductListService {
    final ProductRepository productRepository;

}
