package com.java.ciudad.application;

import java.util.List;
import java.util.Optional;

import com.java.ciudad.domain.model.Ciudad;
import com.java.ciudad.infrastructure.CiudadRepository;

public class CiudadService {
    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public void save(Ciudad ciudad) {
        ciudadRepository.save(ciudad);
    }

    public void update(Ciudad ciudad) {
        ciudadRepository.update(ciudad);
    }

    public Optional<Ciudad> findById(int id_ciudad) {
        return ciudadRepository.findById(id_ciudad);
    }

    public void delete(int id_ciudad) {
        ciudadRepository.delete(id_ciudad);
    }

    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

    
}
