package com.cheweek.appcheweekspace.erp.entity.info.hr;

import com.cheweek.appcheweekspace.utility.coreentity.CoreEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "employee")
public class Employee extends CoreEntity {

    @Column(name = "current_work_experience")
    String currentWorkExperience;
    @Column(name = "previous_work_experience")
    String previousWorkExperience;
    @Column(name = "unofficial_salary")
    String unofficialSalary;
    @Column(name = "official_salary")
    String officialSalary;
    @Column(name = "contract_execution_date")
    String contractExecutionDate;
    @Column(name = "start_date")
    String startDate;
    @Column(name = "contract_date")
    String contractDate;
    @Column(name = "system_created_date")
    String systemCreatedDate;
    @Column(name = "contract_notification_no")
    String contractNotificationNo;
    @Column(name = "contract_expired_date")
    String contractExpiredDate;
    @Column(name = "fk_position_id")
    String fkPositionId;
    @Column(name = "fk_branch_id")
    String fkBranchId;
    @Column(name = "fk_department_id")
    String fkDepartmentId;
    @Column(name = "fk_company_id")
    String fkCompanyId;
    @Column(name = "id_number")
    String idNumber;
    @Column(name = "pin_code", nullable = false)
    String pinCode;
    @Column(name = "surname", nullable = false)
    String surname;
    @Column(name = "first_name", nullable = false)
    String firstName;
    @Column(name = "photo")
    String photo;
    @Column(name = "salary_sum")
    String salarySum;
    @Column(name = "work_experience_sum")
    String workExperienceSum;
    @Column(name = "labor_book_no")
    String laborBookNo;
    @Column(name = "labor_contract_no")
    String laborContractNo;
    @Column(name = "document_no")
    String documentNo;
    @Column(name = "fk_employee_status_key")
    String fkEmployeeStatusKey;
    @Column(name = "fk_activity_type_key")
    String fkActivityTypeKey;
    @Column(name = "fk_user_id")
    String fkUserId;
    @Column(name = "middle_name", nullable = false)
    String middleName;
    @Column(name = "fk_sector_id")
    String fkSectorId;
    @Column(name = "is_active")
    String isActive;
    @Column(name = "labor_contract_file", columnDefinition = "TEXT")
    String laborContractFile;
    @Column(name = "vacation_main")
    String vacationMain;
    @Column(name = "vacation_work_experience")
    String vacationWorkExperience;
    @Column(name = "vacation_children")
    String vacationChildren;
    @Column(name = "vacation_grave")
    String vacationGrave;
    @Column(name = "vacation_sum")
    String vacationSum;
    @Column(name = "fk_employee_category_id")
    String fkEmployeeCategoryId;
    @Column(name = "fk_work_graph_key")
    String fkWorkGraphKey;
    @Column(name = "work_hours")
    String workHours;
    @Column(name = "fk_work_state_key")
    String fkWorkStateKey;

    @PrePersist
    private void preInsert() {
        if (this.isActive == null || this.isActive.isBlank()) {
            this.isActive = this.status;
        }

    }
}
