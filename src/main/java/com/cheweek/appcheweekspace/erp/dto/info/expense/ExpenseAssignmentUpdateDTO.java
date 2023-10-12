package com.cheweek.appcheweekspace.erp.dto.info.expense;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ExpenseAssignmentUpdateDTO {
    String name;
}
