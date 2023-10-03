package com.cheweek.spring_backend_cheweek_core.entity;

import com.cheweek.spring_backend_cheweek_core.utility.CoreDto;
import com.cheweek.spring_backend_cheweek_core.utility.coreentity.CoreEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
@ToString
@Entity
@Table(name = "properties")
public class CoreProperties extends CoreEntity implements CoreDto {
    @Column(name = "is_active")
    String isActive ;
    @Column(name = "property_code")
    String propertyCode ;
    @Column(name = "property_key")
    String propertyKey ;
    @Column(name = "property_value")
    String propertyValue ;
    @Column(name = "order_no")
    String orderNo ;


}
