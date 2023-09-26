package com.cheweek.spring_backend_cheweek_core.utility.coreentity;


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
