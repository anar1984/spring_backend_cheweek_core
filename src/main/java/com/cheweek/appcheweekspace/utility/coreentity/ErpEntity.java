package com.cheweek.appcheweekspace.utility.coreentity;


import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
@ToString
@MappedSuperclass
public class ErpEntity extends CoreEntity{

}
