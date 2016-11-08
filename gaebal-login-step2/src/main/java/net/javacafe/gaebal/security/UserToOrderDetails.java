package net.javacafe.gaebal.security;

import net.javacafe.gaebal.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author 임형태
 * @since 2015.11.19
 */
public class UserToOrderDetails implements UserDetails {
    private String id;
    private String name;
    private String password;
    private String cellphone;
    private String address;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public UserToOrderDetails(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.password = u.getPassword();
        this.cellphone = u.getCellphone();
        this.address = u.getAddress();
    }

    public String getName() {
        return name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
