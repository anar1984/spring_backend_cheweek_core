package com.cheweek.spring_backend_cheweek_core.utility.coreentity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
@ToString
@MappedSuperclass
public class ErpEntity extends CoreEntity{
    @Column(name = "operation_date",nullable = false)
    String operationDate;
    @Column(name = "operation_time",nullable = false)
    String operationTime;
    @Column(name = "fk_request_id",nullable = false)
    String fkRequestId;
    @Column(name = "request_code",nullable = false)
    String requestCode;
    @Column(name = "fkTaskId",nullable = false)
    String fkTaskId;
    @Column(name = "task_no",nullable = false)
    String taskNo;
    @Column(name = "fk_task_type_id",nullable = false)
    String fkTaskTypeId;
    @Column(name = "fk_company_id",nullable = false)
    String fkCompanyId;
    @Column(name = "fk_branch_id",nullable = true)
    String fkBranchId;




}
