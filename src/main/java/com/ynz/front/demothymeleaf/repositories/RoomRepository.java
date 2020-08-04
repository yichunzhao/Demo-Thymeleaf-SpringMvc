package com.ynz.front.demothymeleaf.repositories;

import com.ynz.front.demothymeleaf.Entities.Room;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {
}
