package com.cheweek.spring_backend_cheweek_core.entity;

import com.cheweek.spring_backend_cheweek_core.utility.coreentity.CoreEntity;
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
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
@Builder
@Entity
@Table(name = "module")

public class ModuleEntity extends CoreEntity {
    @Column(name = "module_key",nullable = false)
    String moduleKey;
    @Column(name = "module_name",nullable = false)
    String moduleName;
    @Column(name = "module_name_ru",nullable = false)
    String moduleNameRu;
    @Column(name = "module_name_en",nullable = false)
    String moduleNameEn;
    @Column(name = "order_no")
    String orderNo;
}
