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
        Optional.ofNullable(userName).orElseThrow(() -> new IllegalArgumentException("Must provide a user name"));
        return userSecDetailRepository.findByLoginName(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName + " is not found."));
    }

    public boolean match(Login login) {
        Optional.ofNullable(login).orElseThrow(() -> new IllegalArgumentException("Must provide a Login instance"));
        String encodedPwd = loadUserByUsername(login.getUserName()).getPassword();
        return passwordEncoder.matches(login.getPassword(), encodedPwd);
    }
}
