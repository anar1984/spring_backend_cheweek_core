package com.cheweek.appcheweekspace.erp.dto.info.hr;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EmployeeUpdateDTO {
    @NotBlank(message = "chw_20026")
    String id;
    String currentWorkExperience;
    String previousWorkExperience;
    String unofficialSalary;
    String officialSalary;
    String contractExecutionDate;
    String startDate;
    String contractDate;
    String systemCreatedDate;
    String contractNotificationNo;
    String contractExpiredDate;
    String fkPositionId;
    String fkBranchId;
    String fkDepartmentId;
    String fkCompanyId;
    String idNumber;
    @NotBlank(message = "chw-20005")
    String pinCode;
    @NotBlank(message = "chw-20003")
    String surname;
    @NotBlank(message = "chw-20002")
    String firstName;
    String photo;
    String salarySum;
    String workExperienceSum;
    String laborBookNo;
    String laborContractNo;
    String documentNo;
    String fkEmployeeStatusKey;
    String fkActivityTypeKey;
    @NotBlank(message = "chw-20004")
    String middleName;
    String fkSectorId;
    String isActive;
    String laborContractFile;
    String vacationMain;
    String vacationWorkExperience;
    String vacationChildren;
    String vacationGrave;
    String vacationSum;
    String fkEmployeeCategoryId;
    String fkFamilyStatusKey;
    String fkWorkGraphKey;
    String workHours;
    String fkWorkStateKey;
}
