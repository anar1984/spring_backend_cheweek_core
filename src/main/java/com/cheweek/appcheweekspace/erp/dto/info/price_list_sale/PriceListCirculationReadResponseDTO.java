package com.cheweek.appcheweekspace.erp.dto.info.price_list_sale;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PriceListCirculationReadResponseDTO {
    private String  fkCompanyId;
    private String  fkBranchId;
    private String circulationType;
    private String circulationMin;
    private String circulationMax;
    private String circulationUnit;
    private String  mainPrice;
    private String  discountAmount;
    private String  discountPercent;
    private String circulationCurrency;
    private String circulationCourse;
    private String circulationPriceAzn;
}
