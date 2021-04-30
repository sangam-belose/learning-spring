package com.belose.sangam.learning.spring.data.repository;

import com.belose.sangam.learning.spring.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

    List<Guest> findAll();

}
