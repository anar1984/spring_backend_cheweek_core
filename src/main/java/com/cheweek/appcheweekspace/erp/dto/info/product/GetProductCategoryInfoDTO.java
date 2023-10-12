package com.cheweek.appcheweekspace.erp.dto.info.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class GetProductCategoryInfoDTO {

    String isActive;
    String direction;
    String fkProductTypeId;
    String categoryName;
}
