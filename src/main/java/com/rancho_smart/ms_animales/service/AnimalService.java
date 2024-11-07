package com.rancho_smart.ms_animales.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_animales.entity.Animal;
import com.rancho_smart.ms_animales.repository.AnimalRepository;

@Service
public class AnimalService {
    
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAnimales() {
        return this.animalRepository.findAll();
    }

    public List<Animal> getAnimalesByIdFinca(Long idFinca){
        return this.animalRepository.findByIdFinca(idFinca);
    }   

    public List<Animal> getAnimalesByIdLote(Long idLote){
        return this.animalRepository.findByIdLote(idLote);
    }

    public List<Animal> getAnimalesByIdUsuario(Long idUsuario){
        return this.animalRepository.findByIdUsuario(idUsuario);
    }

    public Optional<Animal> getAnimalById(Long id) {
        return this.animalRepository.findById(id);
    }

    public Animal saveAnimal(Animal animal) {
        return this.animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        this.animalRepository.deleteById(id);
    }
}
