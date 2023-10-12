package com.cheweek.appcheweekspace.erp.entity.info.price_list_sale;

import com.cheweek.appcheweekspace.utility.coreentity.CoreEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@SuperBuilder
@Table(name = "product_circulation")
public class PriceListSale extends CoreEntity {

    @Column(name = "circulation_price")
    private String circulationPrice;
    @Column(name = "circulation_unit")
    private String circulationUnit;
    @Column(name = "fk_price_product_id")
    private String fkPriceProductId;
    @Column(name = "circulation_currency")
    private String circulationCurrency;
    @Column(name = "circulation_course")
    private String circulationCourse;
    @Column(name = "circulation_price_azn")
    private String circulationPriceAzn;
    @Column(name = "circulation_min")
    private String circulationMin;
    @Column(name = "circulation_max")
    private String circulationMax;
    @Column(name = "circulation_type")
    private String circulationType;
    @Column(name = "is_default")
    private String  isDefault;
    @Column(name = "fk_company_id")
    private String  fkCompanyId;
    @Column(name = "fk_branch_id")
    private String  fkBranchId;
    @Column(name = "discount_amount")
    private String  discountAmount;
    @Column(name = "discount_percent")
    private String  discountPercent;
    @Column(name = "main_price")
    private String  mainPrice;
    @Column(name = "fk_price_product_type_id")
    private String fkPriceProductTypeId;
}
