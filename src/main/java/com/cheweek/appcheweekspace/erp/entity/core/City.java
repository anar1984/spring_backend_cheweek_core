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
@Table(name = "city")
public class City extends CoreEntity {
    @Column(name = "fk_country_id")
    String fkCountryId;
    @Column(name = "city_name")
    String cityName;
    @Column(name = "city_name_en")
    String cityNameEn;
    @Column(name = "city_name_ru")
    String cityNameRu;
}
