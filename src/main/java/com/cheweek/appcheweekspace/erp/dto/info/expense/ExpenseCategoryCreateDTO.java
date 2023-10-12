package com.cheweek.appcheweekspace.erp.dto.info.expense;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ExpenseCategoryCreateDTO {

    String fk_expense_type_id;
    String fk_cashflow_type_id;
    String name;
}
