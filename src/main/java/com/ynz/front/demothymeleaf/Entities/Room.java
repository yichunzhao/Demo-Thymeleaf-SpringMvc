package com.ynz.front.demothymeleaf.Entities;

import com.ynz.front.demothymeleaf.mapper.Domain;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ROOM")
@Getter
@Setter
public class Room implements Domain {
    @Id
    @GeneratedValue
    @Column(name = "ROOM_ID")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROOM_NUMBER")
    private String roomNum;

    @Column(name = "BED_INFO")
    private String bedInfo;
}
