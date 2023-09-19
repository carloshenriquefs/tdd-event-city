package com.tdd.event.city.services;

import com.tdd.event.city.dto.CityDTO;
import com.tdd.event.city.entities.City;
import com.tdd.event.city.repositories.CityRepository;
import com.tdd.event.city.services.exceptions.DatabaseException;
import com.tdd.event.city.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.tdd.event.city.constants.Constants.FAILURE_OF_REFERENTIAL_INTEGRITY;
import static com.tdd.event.city.constants.Constants.RESOURCE_NOT_FOUND;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public CityDTO findById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        City entity = city.orElseThrow(
                () -> new ResourceNotFoundException(RESOURCE_NOT_FOUND));
        return new CityDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<CityDTO> findAllName() {
        List<City> list = cityRepository.findAll(Sort.by("name"));
        return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
    }
    
    public CityDTO insert(CityDTO cityDTO) {
        City entity = new City();
        entity.setName(cityDTO.getName());
        cityRepository.save(entity);
        return new CityDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new ResourceNotFoundException(RESOURCE_NOT_FOUND);
        }
        try {
            cityRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(FAILURE_OF_REFERENTIAL_INTEGRITY);
        }
    }

//    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
//    public void delete(Long id) {
//        try {
//            cityRepository.deleteById(id);
//        } catch (EmptyResultDataAccessException e) {
//            throw new ResourceNotFoundException("City not found");
//        } catch (DataIntegrityViolationException e) {
//            throw new DatabaseException("Referential integrity failure");
//        }
//    }

}
