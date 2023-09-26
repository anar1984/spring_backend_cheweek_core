package com.cheweek.spring_backend_cheweek_core.utility.coreentity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class EntityControl {
    String entityName;
    String tableName;
    String controlFields;
    int controlCount;
}
