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
@Table(name = "task_type")
public class TaskTypeEntity extends CoreEntity {

    @Column(name = "task_type_key",nullable = false)
    String processKey;
    @Column(name = "task_type_name",nullable = false)
    String processName;
    @Column(name = "task_type_name_ru",nullable = false)
    String processNameRu;
    @Column(name = "task_type_name_en",nullable = false)
    String processNameEn;
    @Column(name = "fk_process_key",nullable = false)
    String fkProcessKey;
    @Column(name = "fk_story_card_id",nullable = false)
    String fkStoryCardId;
    @Column(name = "fk_task_type_group_id")
    String fkTaskTypeGroupId;
    @Column(name = "is_payment")
    String isPayment;
    @Column(name = "is_last")
    String isLast;
    @Column(name = "is_budget")
    String isBudget;
    @Column(name = "is_flowable")
    String isFlowable;
    @Column(name = "is_related")
    String isRelated;
}
