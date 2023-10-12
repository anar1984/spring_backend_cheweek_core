package com.cheweek.appcheweekspace.core.dto.operation;


import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class TaskDto {
    String id;
    @NotBlank(message = "chw-20032")
    String fkTaskTypeKey;
    @NotBlank(message = "chw-20033")
    String fkRequestId;
    @NotBlank(message = "chw-20034")
    String fkAssigneeId;
    @NotBlank(message = "chw-20035")
    String fkActionId;
    String fkExecutorTaskId;
    String param1;
    String param2;
    String param3;
    String param4;
    String endDate;
    String endTime;
    String taskStatus;
    String taskNo;
    String taskPriority;
    String closedComment;
    String canceledComment;
    String startDate;
    String startTime;
    String closedTime;
    String closedDate;
    String closedBy;
    String operationDate;
    String operationTime;
    String carrierDescription;
    String carrierParam;
    String filterEmployee;
    String filterCounterAgent;
    String filterProduct;
    String filterInventory;
    String filterWarehouse;
    String filterBank;
    String filterCashBox;
    String filterDeposit;
    String filterSalesType;
    String filterSupplyType;
    String filterDocumentNo;
    String filterDocumentCategory;
    String filterCompany;
    String filterBranch;
    String canceledReason;
    String ongoingComment;
}
