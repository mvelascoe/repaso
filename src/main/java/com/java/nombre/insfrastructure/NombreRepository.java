package com.java.nombre.insfrastructure;

import java.util.List;
import java.util.Optional;

import com.java.nombre.domain.model.Nombre;

public interface NombreRepository {
    void save (Nombre nombre);
    void update (Nombre nombre);
    Optional<Nombre>findById(int id_nombre);
    void delete (int id_nombre);
    List<Nombre>finAll();
}
