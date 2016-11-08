package net.javacafe.gaebal.repository;

import net.javacafe.gaebal.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 임형태
 * @since 2015.11.19
 */
@Repository
public class UserRepository {
    @Autowired
    PasswordEncoder passwordEncoder;

    private static Map<String, User> REPOSITORY = new HashMap<String, User>();

    @PostConstruct
    public void init() {
        REPOSITORY.put("placebo", new User("placebo", "임형태", passwordEncoder.encode("password"), "010-3535-1414", "경기도 성남시 분당구 삼평동", "ROLE_USER"));
        REPOSITORY.put("spiderman", new User("spiderman", "배달원", passwordEncoder.encode("password"), "010-1234-5678", "경기도 용인시 기흥구 동백동", "ROLE_DELIVERY"));
        REPOSITORY.put("staff", new User("staff", "카운터", passwordEncoder.encode("password"), "010-1112-1119", "서울 강남구 세곡동", "ROLE_STAFF"));
    }

    public User get(String name) {
        return REPOSITORY.get(name);
    }
}
