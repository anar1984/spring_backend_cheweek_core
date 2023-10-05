package com.cheweek.spring_backend_cheweek_core.dto;

import com.cheweek.spring_backend_cheweek_core.utility.CoreDto;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CorePropertiesDTO extends CoreDto {
    String isActive ;
    String propertyCode ;
    String propertyKey ;
    String propertyValue ;
    String orderNo ;
}
