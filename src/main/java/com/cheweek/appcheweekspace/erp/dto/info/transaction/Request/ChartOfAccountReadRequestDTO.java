package com.cheweek.appcheweekspace.erp.dto.info.transaction.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ChartOfAccountReadRequestDTO {
    String id;
    String section;
    String heading;
    String accountNumber;
    String subAccountNumber;
    String subAccountName;
}
