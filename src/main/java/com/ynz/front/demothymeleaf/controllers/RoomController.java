package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.dto.RoomDto;
import com.ynz.front.demothymeleaf.mapper.RoomMapper;
import com.ynz.front.demothymeleaf.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class RoomController {
    private final RoomRepository roomRepository;

//    @GetMapping("/showrooms")
//    public String getAllRooms(Model model, Principal principal) {
//        List<RoomDto> roomDtoList = new ArrayList<>();
//        roomRepository.findAll().forEach(room -> roomDtoList.add(RoomMapper.instance().map(room)));
//
//        model.addAttribute("rooms", roomDtoList);
//
//        String user = null;
//        if (principal instanceof UserDetails) {
//            user = ((UserDetails) principal).getUsername();
//        }
//        model.addAttribute("loginName", user);
//
//        return "showrooms";
//    }

    @PostMapping("/showRooms")
    public String showAllRooms(Model model, Principal principal) {
        List<RoomDto> roomDtoList = new ArrayList<>();
        roomRepository.findAll().forEach(room -> roomDtoList.add(RoomMapper.instance().map(room)));

        model.addAttribute("rooms", roomDtoList);

        String user = null;
        if (principal instanceof UserDetails) {
            user = ((UserDetails) principal).getUsername();
        }
        model.addAttribute("user", user);

        return "showrooms";
    }

}
