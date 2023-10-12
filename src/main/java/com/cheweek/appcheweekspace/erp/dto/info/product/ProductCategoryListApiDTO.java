package com.cheweek.appcheweekspace.erp.dto.info.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor

public class ProductCategoryListApiDTO {
    String id;
    String createdBy ;
    String createdTime ;
    String status ;
    String insertDate ;
    String modificationDate;
    String modificationTime;
    String createdDate ;
    String modificationBy ;
    String isActive ;
    String direction ;
    String fkProductTypeId ;
    String categoryName ;
    String page;
}
