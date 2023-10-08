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
@Table(name = "task_type_group")
public class TaskTypeGroupEntity extends CoreEntity {

    @Column(name = "group_name",nullable = false)
    String groupName;
    @Column(name = "group_name_ru",nullable = false)
    String groupNameRu;
    @Column(name = "group_name_en",nullable = false)
    String groupNameEn;
}
