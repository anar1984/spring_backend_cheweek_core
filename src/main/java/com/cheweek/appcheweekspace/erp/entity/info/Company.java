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
@Table(name = "company")
public class Company extends CoreEntity {

    @Column(name = "is_active")
    String isActive ;
    @Column(name = "permanent_address")
    String permanentAddress ;
    @Column(name = "legal_address")
    String legalAddress ;
    @Column(name = "approve_date")
    String approveDate;
    @Column(name = "company_mobile")
    String companyMobile ;
    @Column(name = "company_tin")
    String companyTin ; // company_voen
    @Column(name = "company_ceo")
    String companyCeo ;
    @Column(name = "company_owner")
    String companyOwner ;
    @Column(name = "company_status")
    String companyStatus ;
    @Column(name = "company_full_name")
    String companyFullName ;
    @Column(name = "company_name")
    String companyName ;
    @Column(name = "company_mobile_alternative1")
    String companyMobileAlternative1 ;
    @Column(name = "company_mobile_alternative2")
    String companyMobileAlternative2 ;
    @Column(name = "insurance_account_number")
    String insuranceAccountNumber ;
    @Column(name = "fk_city_id")
    String fkCityId ;
    @Column(name = "tax_code")
    String taxCode ;
    @Column(name = "tax_name")
    String taxName ;
    @Column(name = "start_date")
    String startDate ;
    @Column(name = "notification_no")
    String notificationNo ;
    @Column(name = "vat_payer")
    String vatPayer ;
    @Column(name = "notification_start_date")
    String notificationStartDate ;
    @Column(name = "fk_country_id")
    String fkCountryId ;
    @Column(name = "fixed_number")
    String fixedNumber ;
    @Column(name = "logo")
    String logo ;
    @Column(name = "web_site")
    String webSite ;
    @Column(name = "email")
    String email ;
    @Column(name = "email2")
    String email2 ;

}
