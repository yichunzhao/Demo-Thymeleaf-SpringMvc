package com.ynz.front.demothymeleaf.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Ticket {
    private String num;
    private LocalDateTime dateTime;
}
