package com.cheweek.spring_backend_cheweek_core.dto;

import com.cheweek.spring_backend_cheweek_core.utility.CoreDto;
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
public class TestDto implements CoreDto {
    String propertyKey ;
    String propertyValue ;
    String orderNo ;
}
