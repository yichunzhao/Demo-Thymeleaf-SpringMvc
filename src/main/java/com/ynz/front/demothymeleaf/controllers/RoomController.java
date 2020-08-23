package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.dto.RoomDto;
import com.ynz.front.demothymeleaf.mapper.RoomMapper;
import com.ynz.front.demothymeleaf.repositories.ClientRepository;
import com.ynz.front.demothymeleaf.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class RoomController {
    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;

    @GetMapping("/showRooms")
    public String getAllRooms(Model model, Principal principal) {
        List<RoomDto> roomDtoList = new ArrayList<>();
        roomRepository.findAll().forEach(room -> roomDtoList.add(RoomMapper.instance().map(room)));

        model.addAttribute("rooms", roomDtoList);

        if (principal instanceof UsernamePasswordAuthenticationToken) {
            String userName = principal.getName().trim();

            clientRepository.findByEmail(userName)
                    .ifPresent(client -> model.addAttribute("currentUser", client.getFirstName()));
        }

        return "showrooms";
    }

}
