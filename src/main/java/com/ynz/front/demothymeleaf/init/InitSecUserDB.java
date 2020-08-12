package com.ynz.front.demothymeleaf.init;

import com.ynz.front.demothymeleaf.Entities.Client;
import com.ynz.front.demothymeleaf.repositories.ClientRepository;
import com.ynz.front.demothymeleaf.security.UserSecDetailRepository;
import com.ynz.front.demothymeleaf.security.UserSecurityDetails;
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
    private final ClientRepository clientRepository;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        UserSecurityDetails defaultUser = new UserSecurityDetails();
        defaultUser.setPassword(encoder.encode("test"));
        defaultUser.setLoginName("test@test.com");
        defaultUser.setAccountNonExpired(true);
        defaultUser.setCredentialsNonExpired(true);
        defaultUser.setEnabled(true);
        defaultUser.setAccountNonLocked(true);
        userSecDetailRepository.save(defaultUser);

        Client defaultClient = Client.builder().firstName("Mike").lastName("Jones").email("test@test.com")
                .phone("55558888").build();
        clientRepository.save(defaultClient);
    }
}
