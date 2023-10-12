package com.cheweek.appcheweekspace.erp.dto.info.transaction.Response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ChartOfAccountReadResponseDTO {
    String id;
    String section;
    String heading;
    String accountNumber;
    String subAccountNumber;
    String subAccountName;
    String isCurrency;
}
