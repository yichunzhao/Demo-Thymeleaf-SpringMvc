package com.ynz.front.demothymeleaf.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Ticket {
    private String num;
    private LocalDateTime dateTime;
}
