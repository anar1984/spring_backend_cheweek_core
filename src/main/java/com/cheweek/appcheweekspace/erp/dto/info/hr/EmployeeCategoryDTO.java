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
public class EmployeeCategoryDTO {
    String id;
    String categoryName;
    @NotBlank(message = "chw-20008")
    String employeeStatus;
}
