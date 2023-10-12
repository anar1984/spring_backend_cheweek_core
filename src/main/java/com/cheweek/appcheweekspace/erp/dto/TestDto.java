package com.cheweek.appcheweekspace.erp.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class TestDto  implements  Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "chw-20007")
    String fkCompanyId;
    String fkTaskTypeId;
    String month;
    String fkRequestId;
    String year;
    String fkActionId;



}
