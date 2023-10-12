package com.cheweek.appcheweekspace.erp.security;


import com.cheweek.appcheweekspace.utility.QLogger;
import com.cheweek.appcheweekspace.utility.Converter;
import com.cheweek.appcheweekspace.utility.SessionManager;
import com.cheweek.appcheweekspace.utility.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class OldProjectSecurity {
    final RedisTemplate<String, String> redis;
    final QLogger logger = QLogger.getLogger(OldProjectSecurity.class);
    private final SessionManager sessionManager;

    public boolean checkToken(String token) {
        if (token.length() == 0) {
            logger.info("Token is empty");
            return false;
        }
        UserInfo userInfo = getUserInfo(token);
        if (userInfo == null) {
            logger.info("token is invalid");
            return false;
        }
//        String encodedKey = userInfo.getKey();
//        setSession(userInfo);
//        if (encodedKey == null) {
//            logger.info("token is invalid");
//            return false;
//        }
//
//        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
//        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
//        jwe.setKey(originalKey);
//        try {
//            jwe.setCompactSerialization(token);
//            int l = jwe.getPayload().length();
//            return l>1;
//        } catch (JoseException e) {
//            logger.info("ex "+e.getMessage());
//           return false;
//        }
//
        return true;
    }

    public boolean checkTokenLocal(String token) {
        UserInfo userInfo = getUserInfo(token);
        if (userInfo != null && userInfo.getKey() != null) {
            setSession(userInfo,token);
            return true;

        }
        return false;
    }

    private UserInfo getUserInfo(String token) {
        Converter<String, UserInfo> converter = new Converter<>();
        HashOperations<String, String, String> userInfoRedis = redis.opsForHash();
        UserInfo userInfo = new UserInfo();
        if (token.length() == 0) {
            return null;
        }
        String info = userInfoRedis.get("spring_dev_token", token);
        userInfo = converter.convertMap(info, userInfo);
        return userInfo;

    }

    private void setSession(UserInfo userInfo,String token) {
        String currentUserId = userInfo.getCurrentUserId();
        String currentUserName = userInfo.getCurrentUserName();
        String userId = userInfo.getCurrentUserId();
        String currentThreadId = userInfo.getCurrentThreadId();
        String currentRoleId = userInfo.getCurrentRoleId();
        String domain = userInfo.getDomain();
        sessionManager.setCurrentUserId(currentUserId);
        sessionManager.setCurrentUserName(currentUserName);
        sessionManager.setCurrentThreadId(currentThreadId);
        sessionManager.setCurrentRoleId(currentRoleId);
        sessionManager.setUserId(userId);
        sessionManager.setDomain(domain);
        sessionManager.setToken(token);
    }
}
