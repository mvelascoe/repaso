package com.java.pais.application;

import java.util.List;
import java.util.Optional;

import com.java.pais.domain.model.Pais;
import com.java.pais.infrastructura.PaisRepository;

public class PaisService {
    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public void save(Pais pais) {
        paisRepository.save(pais);
    }

    public void update(Pais pais) {
        paisRepository.update(pais);
    }

    public Optional<Pais> finById(int id_pais) {
        return paisRepository.finById(id_pais);
    }

    public void delete(int id_pais) {
        paisRepository.delete(id_pais);
    }

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    
}
