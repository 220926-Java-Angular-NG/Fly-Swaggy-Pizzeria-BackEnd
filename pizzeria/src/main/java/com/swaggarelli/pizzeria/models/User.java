package com.swaggarelli.pizzeria.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, length = 20)
    @NotNull
    private String username;

    @NotNull
    private String password;

    @Column(length = 24)
    private String firstName;

    @Column(length = 24)
    private String lastName;

    @Column(length = 64)
    private String email;

    @Column(length = 10)
    private String phoneNumber;

    @Column(length = 30)
    private String address;

    @Column(length = 30)
    private String address2;

    @Column(length = 5)
    private String zipCode;

    private auth level = auth.CUSTOMER;
    public enum auth implements GrantedAuthority{
        CUSTOMER("customer");

        public final String autho;
        auth(String autho){
            this.autho = autho;
        }
        public String getAuthority() {
            return this.autho;
        }
    }
    private boolean isActive = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(level);
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
