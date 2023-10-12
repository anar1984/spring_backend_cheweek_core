package com.cheweek.appcheweekspace.erp.entity.info;

import com.cheweek.appcheweekspace.utility.coreentity.CoreEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "unit")
public class Unit extends CoreEntity {
    @Column(name = "is_active")
    String isActive ;
    @Column(name = "short_name")
    String shortName ;
    @Column(name = "long_name")
    String longName ;
    @Column(name = "order_no")
    String orderNo ;
}
