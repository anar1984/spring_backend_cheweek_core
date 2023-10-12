package com.cheweek.appcheweekspace.erp.dto.info.hr;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EmployeeFilterDTO {

    String fkBranchId;
    String fkDepartmentId;

    String fkCompanyId;

    String surname;
    String firstName;
    String middleName;
    String fkSectorId;
    String isActive;
    String page;

}
