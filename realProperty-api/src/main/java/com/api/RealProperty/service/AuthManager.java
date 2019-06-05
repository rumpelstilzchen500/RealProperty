package com.api.RealProperty.service;

import com.api.RealProperty.entity.Role;
import com.api.RealProperty.entity.User;
import com.api.RealProperty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class AuthManager implements AuthenticationManager {

    private final UserRepository userRepository;

    @Autowired
    public AuthManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getPrincipal() + "";
        String loginPassword = authentication.getCredentials() + "";
        User expectedUser = userRepository.findUserByLogin(login);

        if (expectedUser == null) {
            throw new BadCredentialsException("error load user from data base");
        }

        if (!expectedUser.getPassword().equals(loginPassword)) {
            throw new BadCredentialsException("password invalid");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        Role role = expectedUser.getRole();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                login,
                expectedUser.getPassword(),
                grantedAuthorities);
        token.setDetails(authentication.getDetails());
        return token;
    }
}
