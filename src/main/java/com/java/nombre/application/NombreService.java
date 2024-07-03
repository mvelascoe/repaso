package com.java.nombre.application;

import java.util.List;
import java.util.Optional;

import com.java.nombre.domain.model.Nombre;
import com.java.nombre.insfrastructure.NombreRepository;

public class NombreService {
    private final NombreRepository nombreRepository;

    public NombreService(NombreRepository nombreRepository) {
        this.nombreRepository = nombreRepository;
    }

    public void save(Nombre nombre) {
        nombreRepository.save(nombre);
    }

    public void update(Nombre nombre) {
        nombreRepository.update(nombre);
    }

    public Optional<Nombre> findById(int id_nombre) {
        return nombreRepository.findById(id_nombre);
    }

    public void delete(int id_nombre) {
        nombreRepository.delete(id_nombre);
    }

    public List<Nombre> finAll() {
        return nombreRepository.finAll();
    }
    
    
}
