package com.cheweek.appcheweekspace.erp.dto.info.expense;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseItemReadDTO {
    String fk_expense_category_id;
    String expense_group_name;
}
