package com.cheweek.spring_backend_cheweek_core.utility;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
@ToString
public class CoreDto {
    String id;
    String createdBy ;
    String createdTime ;
    String status ;
    String insertDate ;
    String modificationDate;
    String modificationTime;
    String createdDate ;
    String modificationBy ;
}
