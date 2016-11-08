package net.javacafe.gaebal.repository;

import net.javacafe.gaebal.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 임형태
 * @since 2015.11.19
 */
@Repository
public class UserRepository {
    private static Map<String, User> REPOSITORY = new HashMap<String, User>();

    static {
        REPOSITORY.put("placebo", new User("placebo", "임형태", "password", "010-3535-1414", "경기도 성남시 분당구 삼평동"));
    }

    public User get(String name) {
        return REPOSITORY.get(name);
    }
}
