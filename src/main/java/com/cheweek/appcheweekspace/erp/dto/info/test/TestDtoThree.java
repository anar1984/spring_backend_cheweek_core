package com.cheweek.appcheweekspace.erp.dto.info.test;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class TestDtoThree
{
    String id;
    String fkProductId;
    String amount;
}
