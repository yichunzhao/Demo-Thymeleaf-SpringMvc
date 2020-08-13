package com.ynz.front.demothymeleaf.security;

import com.ynz.front.demothymeleaf.backingbeans.Login;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private UserSecDetailRepository userSecDetailRepository;
    private PasswordEncoder passwordEncoder;

    public UserDetailServiceImpl(UserSecDetailRepository userSecDetailRepository, PasswordEncoder passwordEncoder) {
        this.userSecDetailRepository = userSecDetailRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional.ofNullable(userName).orElseThrow(() -> new IllegalArgumentException("UserName is null"));

        return userSecDetailRepository.findByLoginName(userName)
                .orElse(null);
    }

    public boolean match(Login login) {
        Optional.ofNullable(login).orElseThrow(() -> new IllegalArgumentException("Must provide a Login instance"));

        UserDetails found = loadUserByUsername(login.getLoginName());
        if (found == null) return false;

        String encodedPwd = found.getPassword();
        return passwordEncoder.matches(login.getPassword(), encodedPwd);
    }
}
