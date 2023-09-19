package com.tdd.event.city.services;

import com.tdd.event.city.dto.EventDTO;
import com.tdd.event.city.entities.City;
import com.tdd.event.city.entities.Event;
import com.tdd.event.city.repositories.CityRepository;
import com.tdd.event.city.repositories.EventRepository;
import com.tdd.event.city.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.tdd.event.city.constants.Constants.IDENTIFIER_NOT_FOUND;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public EventDTO update(Long id, EventDTO dto) {
        try {
            Event entity = eventRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = eventRepository.save(entity);
            return new EventDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(IDENTIFIER_NOT_FOUND + id);
        }
    }

    private void copyDtoToEntity(EventDTO dto, Event entity) {
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        City city = cityRepository.getReferenceById(dto.getCityId());
        entity.setCity(city);
    }

}
