package com.cheweek.spring_backend_cheweek_core.utility.coreentity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
@ToString
@SuperBuilder
@MappedSuperclass
public class FlowEntity extends CoreEntity{
    @Column(name = "operation_date",nullable = false)
    String operationDate;
    @Column(name = "operation_time",nullable = false)
    String operationTime;
    @Column(name = "fk_request_id",nullable = false)
    String fkRequestId;
    @Column(name = "request_code",nullable = false)
    String requestCode;
    @Column(name = "fk_task_id",nullable = false)
    String fkTaskId;
    @Column(name = "task_no",nullable = false)
    String taskNo;
    @Column(name = "fk_task_type_key",nullable = false)
    String fkTaskTypeKey;
    @Column(name = "fk_action_id",nullable = false)
    String fkActionId;
    @Column(name = "fk_company_id",nullable = false)
    String fkCompanyId;
    @Column(name = "fk_branch_id",nullable = true)
    String fkBranchId;
    @Column(name = "fk_counter_agent_id",nullable = false)
    String fkCounterAgentId;
    @Column(name = "fk_counter_agent_type_id")
    String fkCounterAgentTypeId;
    @Column(name = "fk_product_id")
    String fkProductId;
    @Column(name = "fk_unit_id")
    String fkUnitId;
    @Column(name = "fk_product_type_id")
    String fkProductTypeId;
    @Column(name = "fk_currency_id")
    String fkCurrencyId;
    @Column(name = "rate")
    String rate;
    @Column(name = "total_price")
    String totalPrice;
    @Column(name = "total_price_in")
    String totalPriceIn;
    @Column(name = "total_price_out")
    String totalPriceOut;
    @Column(name = "quantity")
    String quantity;
    @Column(name = "quantity_in")
    String quantityIn;
    @Column(name = "quantity_out")
    String quantityOut;
    @Column(name = "operation_type")
    String operationType;
    @Column(name = "unit_price")
    String unitPrice;
    @Column(name = "unit_price_azn")
    String unitPriceAzn;
    @Column(name = "fk_expense_item_id")// xərc madde
    String fkExpenseGroupId;
    @Column(name = "fk_income_item_id")// gəlir madde
    String fkIncomeGroupId;


}
