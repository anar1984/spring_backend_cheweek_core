package com.cheweek.appcheweekspace.erp.entity.info.expense;

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
@Table(name = "expense_category")
public class ExpenseCategory extends CoreEntity {

    @Column(name = "fk_expense_type_id")
    String fk_expense_type_id;

    @Column(name = "fk_cashflow_type_id")
    String fk_cashflow_type_id;

    @Column(name = "name")
    String name;


}
