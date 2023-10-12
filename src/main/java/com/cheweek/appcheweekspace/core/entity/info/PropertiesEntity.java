package com.cheweek.appcheweekspace.core.entity.info;

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
@FieldDefaults(level = AccessLevel.PROTECTED)
@ToString
@SuperBuilder
@Builder
@Entity
@Table(name = "properties")
public class PropertiesEntity extends CoreEntity  {
    @Column(name = "is_active")
    String isActive ;
    @Column(name = "property_code")
    String propertyCode ;
    @Column(name = "property_key")
    String propertyKey ;
    @Column(name = "property_value")
    String propertyValue ;
    @Column(name = "property_value_ru")
    String propertyValueRu ;
    @Column(name = "property_value_en")
    String propertyValueEn ;
    @Column(name = "order_no")
    String orderNo ;


}
