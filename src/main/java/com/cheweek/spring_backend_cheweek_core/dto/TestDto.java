package com.cheweek.spring_backend_cheweek_core.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class TestDto {
    @Column(name = "property_value")
    String propertyKey ;
    @Column(name = "property_value")
    String propertyValue ;
    @Column(name = "order_no")
    String orderNo ;
}
