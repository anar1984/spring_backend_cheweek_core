package com.cheweek.appcheweekspace.erp.dto.info.income;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class IncomeItemReadDTO {
    String fk_income_category_id;
    String name;

}
