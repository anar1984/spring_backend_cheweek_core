package com.cheweek.spring_backend_cheweek_core.entity;

import com.cheweek.spring_backend_cheweek_core.utility.coreentity.ErpEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
@ToString
@Entity
@Table(name = "warehouse_flow")
public class WarehouseFlow extends ErpEntity {




}
