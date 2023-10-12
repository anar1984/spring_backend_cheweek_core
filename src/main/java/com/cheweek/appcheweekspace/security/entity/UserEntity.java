package com.cheweek.appcheweekspace.security.entity;

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
@Table(name = "users")
public class UserEntity extends CoreEntity {
    @Column(name = "user_type")
    String userType;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "user_image")
    String userImage;
    @Column(name = "full_name")
    String fullName;
    @Column(name = "email")
    String email;
    @Column(name = "expire_date")
    String expireDate;
    @Column(name = "is_active")
    String isActive;
    @Column(name = "fk_company_id")
    String fkCompanyId;

}
