package com.cheweek.appcheweekspace.erp.dto.info.income;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class IncomeAssignmentUpdateDTO {

    String name;
}
