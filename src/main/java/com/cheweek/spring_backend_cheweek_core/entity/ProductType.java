package com.cheweek.spring_backend_cheweek_core.entity;

import com.cheweek.spring_backend_cheweek_core.utility.coreentity.CoreEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
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
