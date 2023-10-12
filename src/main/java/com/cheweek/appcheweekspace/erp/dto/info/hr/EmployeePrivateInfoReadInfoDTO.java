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
public class EmployeePrivateInfoReadInfoDTO {
    String id;
    String fkFamilyStatusKey;
    String disabilityAmount;
    String birthDate;
    String employeeDisability;
    String email;
    String homeAddress;
    String mobile;
    String mobileOffice;
    String registrationAddress;
    String fkEmployeeEducationKey;
    String fkCityId;
    String fkCountryId;
    @NotBlank(message = "chw-20026")
    String fkUserId;
    String fkCitizenshipKey;
    String fkEmployeeGenderKey;
}
