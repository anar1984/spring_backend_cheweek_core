package com.cheweek.appcheweekspace.erp.dto.info.product;

import jakarta.persistence.Column;

public class ProductInsertDTO {
    String isActive;
    String direction;
    String fkProductTypeId;
    String fkProductCategoryId;
    String fkUnitId;
    String fkParentProductId;
    String productName;
    String customProductNo;
    String fileUrl;
    String productDescription;
}
