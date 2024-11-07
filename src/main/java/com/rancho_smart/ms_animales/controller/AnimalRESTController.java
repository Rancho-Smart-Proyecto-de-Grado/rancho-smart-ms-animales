package com.rancho_smart.ms_animales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_animales.entity.Animal;
import com.rancho_smart.ms_animales.service.AnimalService;

@RestController
@RequestMapping(path = "/animales")
public class AnimalRESTController {
    
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> listado = this.animalService.getAnimales();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        Optional<Animal> animal = this.animalService.getAnimalById(id);
        return animal.map(ResponseEntity::ok)
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/finca/{idFinca}")
    public ResponseEntity<List<Animal>> getAnimalByIdFinca(@PathVariable Long idFinca){
        List<Animal> animalesFinca = this.animalService.getAnimalesByIdFinca(idFinca);
        if(!animalesFinca.isEmpty()){
            return new ResponseEntity<>(animalesFinca, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    } 

    @GetMapping("/lote/{idLote}")
    public ResponseEntity<List<Animal>> getAnimalByIdLote(@PathVariable Long idLote){
        List<Animal> animalesLote = this.animalService.getAnimalesByIdLote(idLote);
        if(!animalesLote.isEmpty()){
            return new ResponseEntity<>(animalesLote, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Animal>> getAnimalByIdUsuario(@PathVariable Long idUsuario){
        List<Animal> animalesUsuario = this.animalService.getAnimalesByIdUsuario(idUsuario);
        if(!animalesUsuario.isEmpty()){
            return new ResponseEntity<>(animalesUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Animal> saveAnimal(@RequestBody Animal animal) {
        Animal animalCreado = this.animalService.saveAnimal(animal);
        return new ResponseEntity<>(animalCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        if (!this.animalService.getAnimalById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            animal.setIdAnimal(id);
            Animal animalActualizado = this.animalService.saveAnimal(animal);
            return new ResponseEntity<>(animalActualizado, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        if (!this.animalService.getAnimalById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.animalService.deleteAnimal(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
