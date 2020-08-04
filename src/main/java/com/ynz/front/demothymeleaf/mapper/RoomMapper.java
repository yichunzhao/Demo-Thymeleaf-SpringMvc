package com.ynz.front.demothymeleaf.mapper;

import com.ynz.front.demothymeleaf.Entities.Room;
import com.ynz.front.demothymeleaf.dto.RoomDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "instance")
public class RoomMapper implements Mapper<Room, RoomDto> {

    @Override
    public RoomDto map(Room room) {
        return RoomDto.builder().name(room.getName()).bedInfo(room.getBedInfo()).roomNum(room.getRoomNum()).build();
    }

    @Override
    public Room invert(RoomDto roomDto) {
        Room room = new Room();
        room.setBedInfo(roomDto.getBedInfo());
        room.setName(roomDto.getName());
        room.setRoomNum(roomDto.getRoomNum());
        return room;
    }
}
