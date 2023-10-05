package com.cheweek.spring_backend_cheweek_core.utility;


import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
public class CoreDto {

    String id;

    String createdBy ;

    String createdTime ;
    String status ;

    String insertDate;

    String modificationDate;

    String modificationTime;
    String createdDate ;

    String modificationBy ;

}
