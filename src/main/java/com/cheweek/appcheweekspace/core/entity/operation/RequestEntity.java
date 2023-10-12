package com.cheweek.appcheweekspace.core.entity.operation;

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
@ToString
@SuperBuilder
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "request")
public class RequestEntity extends CoreEntity {
    @Column(name = "request_description",nullable = false)
    String requestDescription;
    @Column(name = "request_code",nullable = false)
    String requestCode;
    @Column(name = "request_status",nullable = false)
    String requestStatus;
    @Column(name = "fk_company_id",nullable = false)
    String fkCompanyId;
    @Column(name = "fk_branch_id",nullable = false)
    String fkBranchId;
    @Column(name = "fk_counter_agent_id",nullable = false)
    String fkCounterAgentId;
    @Column(name = "fk_counter_agent_type_id")
    String fkCounterAgentTypeId;
    @Column(name = "carrier_description")
    String carrierDescription;
    @Column(name = "carrier_param")
    String carrierParam;
    @Column(name = "last_step")
    String lastStep;
    @Column(name = "param_1")
    String param1;
    @Column(name = "param_2")
    String param2;
    @Column(name = "param_3")
    String param3;
    @Column(name = "param_4")
    String param4;
    @Column(name = "fk_process_key")
    String fkProcessKey;
}
