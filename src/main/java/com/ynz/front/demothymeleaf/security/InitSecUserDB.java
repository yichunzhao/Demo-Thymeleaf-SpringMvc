package com.ynz.front.demothymeleaf.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "security.user.init-db", havingValue = "true")
@RequiredArgsConstructor
public class InitSecUserDB implements CommandLineRunner {
    private final UserSecDetailRepository userSecDetailRepository;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        UserSecurityDetails defaultUser = new UserSecurityDetails();
        defaultUser.setPassword(encoder.encode("test"));
        defaultUser.setUserName("test");
        defaultUser.setAccountNonExpired(true);
        defaultUser.setCredentialsNonExpired(true);
        defaultUser.setEnabled(true);
        defaultUser.setAccountNonLocked(true);

        userSecDetailRepository.save(defaultUser);
    }
}
