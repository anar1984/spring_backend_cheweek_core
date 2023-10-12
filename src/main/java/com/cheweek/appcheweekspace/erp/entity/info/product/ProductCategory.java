package com.cheweek.appcheweekspace.erp.entity.info.product;

import com.cheweek.appcheweekspace.utility.coreentity.CoreEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "product_category")
public class ProductCategory extends CoreEntity {
    @Column(name = "is_active")
    String isActive ;
    @Column(name = "direction")
    String direction ;
    @Column(name = "fk_product_type_id")
    String fkProductTypeId ;
    @Column(name = "category_name")
    String categoryName ;
}
