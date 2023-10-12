package com.cheweek.appcheweekspace.erp.dto.core;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CityDTO {
    String id;
    @NotBlank(message = "chw_20025")
    String fkCountryId;
    String cityName;
    String cityNameEn;
    String cityNameRu;
}
