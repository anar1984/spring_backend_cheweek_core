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
@Table(name = "expense_item ")
public class ExpenseItem extends CoreEntity {

    @Column(name = "expense_item_name")
    String expense_group_name;

    @Column(name = "fk_expense_category_id ")
    String fk_expense_category_id ;

}
