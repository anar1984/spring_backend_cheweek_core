package com.cheweek.appcheweekspace.erp.dto.info.income;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class IncomeItemUpdateDTO {
    String fk_income_category_id;
    String name;
}
