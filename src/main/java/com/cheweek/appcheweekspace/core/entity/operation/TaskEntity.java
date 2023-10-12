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
@Table(name = "task")
public class TaskEntity extends CoreEntity {

    @Column(name = "fk_task_type_id",nullable = false)
    String fkTaskTypeId;
    @Column(name = "task_status",nullable = false)
    String taskStatus;
    @Column(name = "task_no",nullable = false)
    String taskNo;
    @Column(name = "task_priority")
    String taskPriority;
    @Column(name = "fk_request_id",nullable = false)
    String fkRequestId;
    @Column(name = "fk_assignee_id",nullable = false)
    String fkAssigneeId;
    @Column(name = "fk_action_id")
    String fkActionId;
    @Column(name = "fk_executor_task_id")
    String fkExecutorTaskId;
    @Column(name = "closed_comment")
    String closedComment;
    @Column(name = "canceled_comment")
    String canceledComment;
    @Column(name = "param_1")
    String param1;
    @Column(name = "param_2")
    String param2;
    @Column(name = "param_3")
    String param3;
    @Column(name = "param_4")
    String param4;
    @Column(name = "start_date")
    String startDate;
    @Column(name = "start_time")
    String startTime;
    @Column(name = "end_date")
    String endDate;
    @Column(name = "end_time")
    String endTime;
    @Column(name = "closed_time")
    String closedTime;
    @Column(name = "closed_date")
    String closedDate;
    @Column(name = "closed_by")
    String closedBy;
    @Column(name = "operation_date")
    String operationDate;
    @Column(name = "operation_time")
    String operationTime;
    @Column(name = "carrier_description")
    String carrierDescription;
    @Column(name = "carrier_param")
    String carrierParam;
    @Column(name = "filter_employee")
    String filterEmployee;
    @Column(name = "filter_counter_agent")
    String filterCounterAgent;
    @Column(name = "filter_product")
    String filterProduct;
    @Column(name = "filter_inventory")
    String filterInventory;
    @Column(name = "filter_warehouse")
    String filterWarehouse;
    @Column(name = "filter_bank")
    String filterBank;
    @Column(name = "filter_cash_box")
    String filterCashBox;
    @Column(name = "filter_deposit")
    String filterDeposit;
    @Column(name = "filter_sales_type")
    String filterSalesType;
    @Column(name = "filter_supply_type")
    String filterSupplyType;
    @Column(name = "filter_document_no")
    String filterDocumentNo;
    @Column(name = "filter_document_category")
    String filterDocumentCategory;
    @Column(name = "filter_company")
    String filterCompany;
    @Column(name = "filter_branch")
    String filterBranch;
    @Column(name = "canceled_reason")
    String canceledReason;
    @Column(name = "ongoing_comment")
    String ongoingComment;




}
