package com.cheweek.appcheweekspace.erp.dto.info.income;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class IncomeCategoryUpdateDTO {
    String fk_income_type_id;
    String fk_cashflow_type_id;
    String name;
}
