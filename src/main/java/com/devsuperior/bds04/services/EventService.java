package com.devsuperior.bds04.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventReposity;

@Service
public class EventService {
	
	@Autowired
	private EventReposity repository;
	
	@Transactional(readOnly = true)
	public Page<EventDTO> findAllPaged(Pageable pageable){
		
		Page<Event> result = repository.findAll(pageable);
		
		return result.map(event -> new EventDTO(event));
	}
	
	@Transactional
	public EventDTO insert(EventDTO dto) {
		
		Event entity = copyToEntity(dto);
		entity = repository.save(entity);
		
		return new EventDTO(entity);
	}

	private Event copyToEntity(EventDTO dto) {
		City city = new City(dto.getCityId(), null);
		
		return new Event(dto.getId(), dto.getName(), dto.getDate(), dto.getUrl(), city);
	}
}
