package com.cheweek.appcheweekspace.erp.entity.info.transaction;


import com.cheweek.appcheweekspace.utility.coreentity.CoreEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@SuperBuilder
@Table(name = "chart_of_account")
public class ChartOfAccount extends CoreEntity {
    @Column(name = "section")
    String section;
    @Column(name = "heading")
    String heading;
    @Column(name = "account_number")
    String accountNumber;
    @Column(name = "sub_account_number")
    String subAccountNumber;
    @Column(name = "sub_account_name")
    String subAccountName;
    @Column(name = "is_currency")
    String isCurrency;
    @Column(name = "fk_chart_of_account_sql_description_id")
    String fkChartOfAccountSqlDescriptionId;
    @PrePersist
    private  void  isCurrency(){
        if(isCurrency==null){
            isCurrency="0";
        }
    }
}
