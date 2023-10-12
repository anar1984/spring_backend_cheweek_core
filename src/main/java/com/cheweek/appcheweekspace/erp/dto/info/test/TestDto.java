package com.cheweek.appcheweekspace.erp.dto.info.test;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class TestDto {
    List<TestDtoOne> products;
}
