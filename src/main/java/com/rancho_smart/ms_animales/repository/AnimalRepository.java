package com.rancho_smart.ms_animales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rancho_smart.ms_animales.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
    
}
