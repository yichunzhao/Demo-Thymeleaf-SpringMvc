package com.ynz.front.demothymeleaf.dto;

import com.ynz.front.demothymeleaf.mapper.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto implements Dto {
    private String name;
    private String roomNum;
    private String bedInfo;
}
