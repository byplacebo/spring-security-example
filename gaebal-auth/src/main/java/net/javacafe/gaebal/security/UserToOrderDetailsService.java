package net.javacafe.gaebal.security;

import net.javacafe.gaebal.domain.User;
import net.javacafe.gaebal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 임형태
 * @since 2015.11.19
 */
@Service
public class UserToOrderDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User u = userRepository.get(id);
        if (u == null) {
            throw new UsernameNotFoundException(id);
        }
        return new UserToOrderDetails(u);
    }
}
