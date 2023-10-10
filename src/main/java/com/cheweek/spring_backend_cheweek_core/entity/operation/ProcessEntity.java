package com.cheweek.spring_backend_cheweek_core.entity.operation;

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
@SuperBuilder
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "process")

public class ProcessEntity extends CoreEntity {
    @Column(name = "process_key",nullable = false)
    String processKey;
    @Column(name = "process_name",nullable = false)
    String processName;
    @Column(name = "process_name_ru",nullable = false)
    String processNameRu;
    @Column(name = "process_name_en",nullable = false)
    String processNameEn;
    @Column(name = "fk_module_key")
    String fkModuleKey;

}
