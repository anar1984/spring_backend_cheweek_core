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
public class ExpenseItemCreateDTO {

    String fk_expense_category_id;
    String expense_group_name;
}
