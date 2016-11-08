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
        REPOSITORY.put("placebo", new User("placebo", "임형태", passwordEncoder.encode("password"), "010-3535-1414", "경기도 성남시 분당구 삼평동"));
        System.out.println("encoded password of placebo is " + REPOSITORY.get("placebo").getPassword());
    }

    public User get(String name) {
        return REPOSITORY.get(name);
    }
}
