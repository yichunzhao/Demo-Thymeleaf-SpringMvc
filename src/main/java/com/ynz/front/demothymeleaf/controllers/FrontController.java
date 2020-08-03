package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.Entities.Client;
import com.ynz.front.demothymeleaf.dto.ClientDto;
import com.ynz.front.demothymeleaf.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequiredArgsConstructor
public class FrontController {
    private final ClientRepository clientRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/createclient")
    public String createClient() {
        return "createclient";
    }

    @GetMapping("/showclients")
    public String showClients(Model model) {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(client -> clients.add(client));

        List<ClientDto> clientDtoList = clients.stream().map(client -> ClientDto.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .phone(client.getPhone()).build())
                .collect(toList());
        model.addAttribute("clients", clientDtoList);

        return "showclients";
    }

    @PostMapping("/clients")
    public String createClient(@Valid @ModelAttribute("clientDto") ClientDto clientDto, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "createclient";
        }

        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPhone(clientDto.getPhone());
        client.setEmail(clientDto.getEmail());
        clientRepository.save(client);

        model.addAttribute("name", client.getFirstName() + " " + client.getLastName());
        return "index";
    }

}
