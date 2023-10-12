package com.cheweek.appcheweekspace.erp.dto.info.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProductCategorySaveDTO {

    String isActive;
    String diection;
    String fkProductTypeId;
    String categoryName;
    String createdBy;
    String createdTime;
    String createdDate;
    String status;
}
