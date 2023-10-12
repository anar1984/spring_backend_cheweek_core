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
public class ExpenseAssignmentReadDTO {
    String name;
}
