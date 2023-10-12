package com.cheweek.appcheweekspace.erp.dto;

import com.cheweek.appcheweekspace.utility.coreentity.CoreEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class TestDto2 extends CoreEntity {
    String name;
    String surname;
    String password;
    String username;
}
