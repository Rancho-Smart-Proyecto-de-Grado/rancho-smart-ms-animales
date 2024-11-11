package com.rancho_smart.ms_animales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rancho_smart.ms_animales.entity.Animal;
import java.util.List;


public interface AnimalRepository extends JpaRepository<Animal, Long>{
    public List<Animal> findByIdFinca(Long idFinca);
    public List<Animal> findByIdLote(Long idLote);
    public List<Animal> findByIdUsuario(Long idUsuario);
}
