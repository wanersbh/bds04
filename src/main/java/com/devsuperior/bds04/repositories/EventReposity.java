package com.devsuperior.bds04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.bds04.entities.Event;

@Repository
public interface EventReposity extends JpaRepository<Event, Long> {

}
