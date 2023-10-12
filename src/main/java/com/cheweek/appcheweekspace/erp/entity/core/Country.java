package com.cheweek.appcheweekspace.erp.entity.core;

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
@SuperBuilder
@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "country")
public class Country extends CoreEntity {
    @Column(name = "country_name")
    String countryName;
    @Column(name = "country_name_en")
    String countryNameEn;
    @Column(name = "country_name_ru")
    String countryNameRu;
}
