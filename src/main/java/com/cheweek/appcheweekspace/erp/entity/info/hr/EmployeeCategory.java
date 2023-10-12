package com.cheweek.appcheweekspace.erp.entity.info.hr;

import com.cheweek.appcheweekspace.utility.coreentity.CoreEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "employee_category")
public class EmployeeCategory extends CoreEntity {

    @Column(name = "category_name")
    String categoryName;
    @Column(name = "employee_status")
    String employeeStatus;
}
