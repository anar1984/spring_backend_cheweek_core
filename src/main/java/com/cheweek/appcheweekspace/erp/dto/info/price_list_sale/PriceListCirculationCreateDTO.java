package com.cheweek.appcheweekspace.erp.dto.info.price_list_sale;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PriceListCirculationCreateDTO {

    @NotBlank(message = "chw-20016")
    private String  fkCompanyId;
    private String  fkBranchId;
    @NotBlank(message = "chw-20019")
    private String circulationType;
    @NotBlank(message = "chw-20018")
    private String circulationMin;
    private String circulationMax;
    @NotBlank(message = "chw-20017")
    private String circulationUnit;
    private String circulationPrice;
    private String  discountAmount;
    private String  discountPercent;
    @NotBlank(message = "chw-20020")
    private String  mainPrice;
    @NotBlank(message = "chw-20015")
    private String circulationCurrency;
    private String circulationCourse;
    private String circulationPriceAzn;
    private String  isDefault;
    private String fkPriceProductTypeId;
    private String fkPriceProductId;



}
