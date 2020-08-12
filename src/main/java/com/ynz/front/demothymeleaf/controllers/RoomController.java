package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.backingbeans.Login;
import com.ynz.front.demothymeleaf.dto.RoomDto;
import com.ynz.front.demothymeleaf.exceptions.NotFoundException;
import com.ynz.front.demothymeleaf.mapper.RoomMapper;
import com.ynz.front.demothymeleaf.repositories.ClientRepository;
import com.ynz.front.demothymeleaf.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class RoomController {
    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;

    @GetMapping("/showrooms")
    public String getAllRooms(@SessionAttribute("login") Login login, Model model, HttpSession session) {
        List<RoomDto> roomDtoList = new ArrayList<>();
        roomRepository.findAll().forEach(room -> roomDtoList.add(RoomMapper.instance().map(room)));
        model.addAttribute("rooms", roomDtoList);

        String clientName = clientRepository.findByEmail(login.getLoginName())
                .orElseThrow(() -> new NotFoundException(login.getLoginName() + " is not found!")).getFirstName();

        model.addAttribute("loginName", clientName);
        //status.setComplete();
        return "showrooms";
    }

    @PostMapping("/showRooms")
    public String showAllRooms(Model model) {
        List<RoomDto> roomDtoList = new ArrayList<>();
        roomRepository.findAll().forEach(room -> roomDtoList.add(RoomMapper.instance().map(room)));

        model.addAttribute("rooms", roomDtoList);

        return "showrooms";
    }

}
