package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.Entities.Client;
import com.ynz.front.demothymeleaf.Entities.Room;
import com.ynz.front.demothymeleaf.dto.ClientDto;
import com.ynz.front.demothymeleaf.dto.RoomDto;
import com.ynz.front.demothymeleaf.mapper.ClientMapper;
import com.ynz.front.demothymeleaf.mapper.Mapper;
import com.ynz.front.demothymeleaf.mapper.RoomMapper;
import com.ynz.front.demothymeleaf.repositories.ClientRepository;
import com.ynz.front.demothymeleaf.repositories.RoomRepository;
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

@Controller
@RequiredArgsConstructor
public class FrontController {
    private final ClientRepository clientRepository;
    private final RoomRepository roomRepository;

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

        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPhone(clientDto.getPhone());
        client.setEmail(clientDto.getEmail());
        clientRepository.save(client);

        model.addAttribute("name", client.getFirstName() + " " + client.getLastName());
        return "index";
    }

    @GetMapping("showrooms")
    public String getAllRooms(Model model) {
        Mapper<Room, RoomDto> mapper = RoomMapper.instance();

        List<RoomDto> roomDtoList = new ArrayList<>();
        roomRepository.findAll().forEach(room -> roomDtoList.add(mapper.map(room)));

        model.addAttribute("rooms", roomDtoList);
        return "showrooms";
    }

}
