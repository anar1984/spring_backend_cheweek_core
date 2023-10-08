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
@SuperBuilder
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "steps")

public class StepEntity extends CoreEntity {
    @Column(name = "step_key",nullable = false)
    String processKey;
    @Column(name = "step_name",nullable = false)
    String processName;
    @Column(name = "step_name_ru",nullable = false)
    String processNameRu;
    @Column(name = "step_name_en",nullable = false)
    String processNameEn;
    @Column(name = "fk_process_key")
    String fkProcessKey;
}
