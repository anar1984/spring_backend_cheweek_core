package com.cheweek.appcheweekspace.erp.dto.info.transaction.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ChartOfAccountCreateRequestDTO {
    @NotBlank(message = "chw-20010")
    String section;
    @NotBlank(message = "chw-20011")
    String heading;
    @NotBlank(message = "chw-20012")
    String accountNumber;
    @NotBlank(message = "chw-20013")
    String subAccountNumber;
    @NotBlank(message = "chw-20014")
    String subAccountName;

    String isCurrency;
    String fkChartOfAccountSqlDescriptionId;
}
