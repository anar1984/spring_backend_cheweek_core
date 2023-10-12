package com.cheweek.appcheweekspace.erp.service.info.product;


import com.cheweek.appcheweekspace.erp.repository.info.ProductRepository;
import com.cheweek.appcheweekspace.utility.QLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUpdateService  {
    final ProductRepository productRepository;
    final QLogger logger = QLogger.getLogger(ProductInsertService.class);
//    @Override
//    public Carrier run(Carrier carrier) {
//
//        Product product1 = new Product();
//        carrier.setFields(product1);
//        Optional<Product> product = productRepository.findById(carrier.get("id"));
//        if (!product.isPresent()){
//            return carrier;
//        }
//        productRepository.save(product1);
//
//
//
//        return carrier;
//    }
}
