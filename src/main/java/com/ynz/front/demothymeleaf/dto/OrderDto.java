package com.ynz.front.demothymeleaf.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderDto {
    private String orderId;
    private ClientDto client;
    private List<RoomDto> bookedRooms;
    private LocalDateTime entryTime;
    private LocalDateTime quitTime;
}
