package com.cheweek.appcheweekspace.utility;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Data
@Component
public class SessionManager {
    private static final String SEPERATOR = "__";
    private static final String LI_USER_PERMISSION_TYPE_ADMIN = "admin";
    private static final String LI_USER_PERMISSION_TYPE_USER = "user";
    public static final String DEFAULT_LANG = "ENG";


    String userId;
    String currentUserId;
    String currentUserName;
    String currentThreadId;
    String currentRoleId;
    String domain;
    String lang = DEFAULT_LANG;
    String token;



}
