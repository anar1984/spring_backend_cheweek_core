package com.cheweek.appcheweekspace.erp.dto.info.hr;


import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EmployeeReadInfoDTO {
    @NotBlank(message = "chw-20026")
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
    String pinCode;
    String surname;
    String firstName;
    String photo;
    String salarySum;
    String workExperienceSum;
    String laborBookNo;
    String laborContractNo;
    String documentNo;
    String fkEmployeeStatusKey;
    String fkActivityTypeKey;
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
