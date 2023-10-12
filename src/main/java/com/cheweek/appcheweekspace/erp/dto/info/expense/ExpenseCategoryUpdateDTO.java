package com.cheweek.appcheweekspace.erp.dto.info.expense;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ExpenseCategoryUpdateDTO {
    String fk_expense_type_id;
    String fk_cashflow_type_id;
    String name;
}
