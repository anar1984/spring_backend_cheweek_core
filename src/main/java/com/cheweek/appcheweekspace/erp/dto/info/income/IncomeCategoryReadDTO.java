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
public class IncomeCategoryReadDTO {

    String fk_income_type_id;
    String fk_cashflow_type_id;
    String name;

}
