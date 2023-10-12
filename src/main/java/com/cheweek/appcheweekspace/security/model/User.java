package com.cheweek.appcheweekspace.security.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements UserDetails {

    String  password;
    String  username;
    String  id;
    String accountNonExpired;
    String accountNonLocked;
    String credentialsNonExpired;
    String enabled;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        if(this.accountNonExpired.equals("A")) return true;
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {

        if(this.accountNonLocked.equals("A")) return true;
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if(this.credentialsNonExpired.equals("A")) return true;
        return false;
    }

    @Override
    public boolean isEnabled() {
        if(this.enabled.equals("A")) return true;
        return false;
    }
}
