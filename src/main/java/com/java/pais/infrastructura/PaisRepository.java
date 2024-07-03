package com.java.pais.infrastructura;

import java.util.List;
import java.util.Optional;

import com.java.pais.domain.model.Pais;

public interface PaisRepository {
    void save(Pais pais);
    void update(Pais pais);
    Optional<Pais>finById(int id_pais);
    void delete(int id_pais);
    List<Pais>findAll();
    

}
