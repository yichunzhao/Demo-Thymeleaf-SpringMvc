package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.Entities.Client;
import com.ynz.front.demothymeleaf.dto.ClientDto;
import com.ynz.front.demothymeleaf.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Controller
@RequiredArgsConstructor
public class FrontController {
    private final ClientRepository clientRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/clients")
    public String createClient(@Valid @ModelAttribute ClientDto clientDto, Model model) {
        String nextPage = null;

        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPhone(clientDto.getPhone());
        Client persisted = clientRepository.save(client);
        if (persisted == null) nextPage = "error";

        model.addAttribute("name", client.getFirstName() + " " + client.getLastName());
        nextPage = "saved";

        return nextPage;
    }

    @GetMapping("/names")
    public String getNames(Model model) {
        List<String> names = Stream.of("Mike", "Mia", "Chris", "Evan", "Merry").collect(toList());
        model.addAttribute("names", names);
        return "names";
    }

}
