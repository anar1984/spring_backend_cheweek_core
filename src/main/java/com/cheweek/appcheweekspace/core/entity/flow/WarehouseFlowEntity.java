package com.cheweek.appcheweekspace.core.entity.flow;

import com.cheweek.appcheweekspace.utility.coreentity.FlowEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
@ToString
@SuperBuilder
@Entity
@Table(name = "warehouse_flow")
public class WarehouseFlowEntity extends FlowEntity {
}
