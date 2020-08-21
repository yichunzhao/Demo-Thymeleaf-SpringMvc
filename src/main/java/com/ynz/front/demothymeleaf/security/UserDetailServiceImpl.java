package com.ynz.front.demothymeleaf.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserSecDetailRepository userSecDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return mapToUserDetails(userSecDetailRepository.findByLoginName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("UserName is not found: " + userName))
        );
    }

    private UserDetails mapToUserDetails(UserSecurityDetails securityDetails) {
        return User.builder().username(securityDetails.getLoginName()).password(securityDetails.getPassword())
                .roles(securityDetails.getRoles().stream().map(role -> role.name()).toArray(String[]::new))
                .disabled(false).accountLocked(false).credentialsExpired(false).accountExpired(false).build();
    }

}
