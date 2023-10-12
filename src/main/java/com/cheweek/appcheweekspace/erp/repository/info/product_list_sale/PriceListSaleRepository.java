package com.cheweek.appcheweekspace.erp.repository.info.product_list_sale;

import com.cheweek.appcheweekspace.erp.entity.info.price_list_sale.PriceListSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PriceListSaleRepository extends JpaRepository<PriceListSale,String> , JpaSpecificationExecutor<PriceListSale>{

    PriceListSale findByIdAndStatus(String id, String status);
}
