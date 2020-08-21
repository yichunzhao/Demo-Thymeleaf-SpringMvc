package com.ynz.front.demothymeleaf.security;

import lombok.RequiredArgsConstructor;
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
        return userSecDetailRepository.findByLoginName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("UserName is not found: " + userName));
    }

}
