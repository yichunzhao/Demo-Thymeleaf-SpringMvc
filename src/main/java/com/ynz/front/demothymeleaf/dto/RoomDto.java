package com.ynz.front.demothymeleaf.dto;

import com.ynz.front.demothymeleaf.mapper.Presentable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto implements Presentable {
    private String name;
    private String roomNum;
    private String bedInfo;
}
