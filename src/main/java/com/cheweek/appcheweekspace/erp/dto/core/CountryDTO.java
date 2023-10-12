package com.cheweek.appcheweekspace.erp.dto.core;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CountryDTO {
    String id;
    String countryName;
    String countryNameEn;
    String countryNameRu;
}
