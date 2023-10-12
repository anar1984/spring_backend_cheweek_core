package com.cheweek.appcheweekspace.erp.entity;

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
@Table(name = "test_spring")
public class TestSpring extends CoreEntity {
    @Column(name = "test")
    String test ;
}
