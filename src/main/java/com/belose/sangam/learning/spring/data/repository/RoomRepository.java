package com.belose.sangam.learning.spring.data.repository;

import com.belose.sangam.learning.spring.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findAll();
}
