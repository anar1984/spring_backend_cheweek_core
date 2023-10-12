package com.cheweek.appcheweekspace.erp.dto.info.expense;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ExpenseItemUpdateDTO {
    String fk_expense_category_id;
    String expense_group_name;
}
