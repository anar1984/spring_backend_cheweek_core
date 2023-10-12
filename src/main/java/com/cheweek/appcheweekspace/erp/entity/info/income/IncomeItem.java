package com.cheweek.appcheweekspace.erp.entity.info.income;

import com.cheweek.appcheweekspace.utility.coreentity.CoreEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "income_item")
public class IncomeItem extends CoreEntity {

    @Column(name = "fk_income_category_id")
    String fk_cashflow_type_id;

    @Column(name = "name")
    String name;
}
