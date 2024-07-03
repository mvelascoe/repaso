package com.java.ciudad.infrastructure;

import java.util.List;
import java.util.Optional;

import com.java.ciudad.domain.model.Ciudad;

public interface CiudadRepository {
    void save (Ciudad ciudad);
    void update(Ciudad ciudad);
    Optional<Ciudad> findById(int id_ciudad);
    void delete(int id_ciudad);
    List<Ciudad>findAll();

}
