package com.cheweek.appcheweekspace.security.service;



import com.cheweek.appcheweekspace.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private final PasswordEncoder encoder;
    private static final String username = "baxtiyar03";
    private static final String password = "123456";

    public UserServiceImpl(PasswordEncoder encoder) {
        this.encoder = encoder;
    }
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(username);
        user.setId(username);
        user.setAccountNonExpired("A");
        user.setCredentialsNonExpired("A");
        user.setAccountNonLocked("A");
        user.setPassword(encoder.encode(password));
        user.setEnabled("A");
        return user;
    }

    public User login(String userName, String pass){
        if(userName.equals(username)){
            User user = new User();
            String encodePass = encoder.encode(password);
            if(encoder.matches(pass,encodePass)){
                user.setUsername(userName);
                user.setId(userName);
                user.setPassword(encodePass);
                user.setAccountNonExpired("A");
                user.setCredentialsNonExpired("A");
                user.setAccountNonLocked("A");
                user.setEnabled("A");
            }

            return user;
        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }


}

