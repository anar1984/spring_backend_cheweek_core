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
@Table(name = "branch")
public class Branch extends CoreEntity {
    @Column(name = "is_active")
    String isActive ;
    @Column(name = "fk_company_id")
    String fkCompanyId ;
    @Column(name = "branch_name")
    String branchName ;
}
