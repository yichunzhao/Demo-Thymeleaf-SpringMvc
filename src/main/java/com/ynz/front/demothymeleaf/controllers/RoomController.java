package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.dto.RoomDto;
import com.ynz.front.demothymeleaf.mapper.RoomMapper;
import com.ynz.front.demothymeleaf.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class RoomController {
    private final RoomRepository roomRepository;

    @GetMapping("/showrooms")
    public String getAllRooms(@SessionAttribute("currentUser") String user, Model model, HttpServletRequest request,
                              @CurrentSecurityContext(expression = "authentication.principal")Principal principal){
        List<RoomDto> roomDtoList = new ArrayList<>();
        roomRepository.findAll().forEach(room -> roomDtoList.add(RoomMapper.instance().map(room)));
        model.addAttribute("rooms", roomDtoList);
        model.addAttribute("loginName", user);

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
