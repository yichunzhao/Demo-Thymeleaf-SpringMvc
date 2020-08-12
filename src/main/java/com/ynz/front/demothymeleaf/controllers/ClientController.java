package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.Entities.Client;
import com.ynz.front.demothymeleaf.dto.ClientDto;
import com.ynz.front.demothymeleaf.mapper.ClientMapper;
import com.ynz.front.demothymeleaf.mapper.Mapper;
import com.ynz.front.demothymeleaf.repositories.ClientRepository;
import com.ynz.front.demothymeleaf.security.UserSecDetailRepository;
import com.ynz.front.demothymeleaf.security.UserSecurityDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientController {
    private final ClientRepository clientRepository;
    private final UserSecDetailRepository userSecDetailRepository;
    private final PasswordEncoder encoder;

    @GetMapping("/createclient")
    public String createClient() {
        return "createclient";
    }

    @GetMapping("/showclients")
    public String showClients(Model model) {
        Mapper<Client, ClientDto> mapper = ClientMapper.instance();
        List<ClientDto> clientDtoList = new ArrayList<>();
        clientRepository.findAll().forEach(client -> clientDtoList.add(mapper.map(client)));

        model.addAttribute("clients", clientDtoList);
        return "showclients";
    }

    @PostMapping("/clients")
    public String createClient(@Valid @ModelAttribute("clientDto") ClientDto clientDto, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "createclient";
        }

        //create an user
        Client client = ClientMapper.instance().invert(clientDto);
        clientRepository.save(client);

        //create user's security details
        UserSecurityDetails userSecurityDetails = UserSecurityDetails.builder().loginName(clientDto.getEmail())
                .password(encoder.encode(clientDto.getPassword())).accountNonExpired(true).accountNonLocked(true)
                .credentialsNonExpired(true).enabled(true).build();

        userSecDetailRepository.save(userSecurityDetails);

        model.addAttribute("name", client.getFirstName() + " " + client.getLastName());
        return "index";
    }

}
