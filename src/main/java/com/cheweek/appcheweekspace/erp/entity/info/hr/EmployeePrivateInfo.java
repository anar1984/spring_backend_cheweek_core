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
@Table(name = "employee_private_info")
public class EmployeePrivateInfo extends CoreEntity {
    @Column(name = "fk_family_status_key")
    String fkFamilyStatusKey ;
    @Column(name = "disability_amount")
    String disabilityAmount;
    @Column(name = "birth_date")
    String birthDate;
    @Column(name = "employee_disability")
    String employeeDisability;
    @Column(name = "email")
    String email;
    @Column(name = "home_address", columnDefinition = "TEXT")
    String homeAddress;
    @Column(name = "mobile")
    String mobile;
    @Column(name = "mobile_office")
    String mobileOffice;
    @Column(name = "registration_address", columnDefinition = "TEXT")
    String registrationAddress;
    @Column(name = "fk_employee_education_key")
    String fkEmployeeEducationKey;
    @Column(name = "fk_city_id")
    String fkCityId;
    @Column(name = "fk_country_id")
    String fkCountryId;
    @Column(name = "fk_user_id")
    String fkUserId;
    @Column(name = "fk_citizenship_key")
    String fkCitizenshipKey;
    @Column(name = "fk_employee_gender_key")
    String fkEmployeeGenderKey;
}
