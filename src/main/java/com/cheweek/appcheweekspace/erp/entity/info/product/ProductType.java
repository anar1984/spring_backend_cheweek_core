package com.cheweek.appcheweekspace.erp.entity.info.product;

import com.cheweek.appcheweekspace.utility.coreentity.CoreEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "product_type")
public class ProductType extends CoreEntity {
    @Column(name = "is_active")
    String isActive ;
    @Column(name = "direction")
    String direction ;
    @Column(name = "type_name")
    String typeName ;
    @Column(name = "type_key")
    String typeKey ;
}
