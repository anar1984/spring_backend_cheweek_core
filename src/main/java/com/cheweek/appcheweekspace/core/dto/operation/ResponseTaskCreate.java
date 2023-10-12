package com.cheweek.appcheweekspace.core.dto.operation;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ResponseTaskCreate {
    String id ;
    String fkTaskId;
}
