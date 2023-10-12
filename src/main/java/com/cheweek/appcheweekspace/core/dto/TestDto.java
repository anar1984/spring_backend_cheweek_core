package com.cheweek.appcheweekspace.core.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class TestDto  {
    String propertyKey ;
    String propertyValue ;
    String orderNo ;
}
