package com.rancho_smart.ms_animales.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ANIMAL")
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimal;

    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "GENERO")
    private char genero;

    @Column(name = "RAZA")
    private String raza;

    @Column(name = "FECHA_NACIMIENTO")
    private LocalDateTime fechaNacimiento;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    public Animal() {
    }

    public Animal(String nombre, char genero, String raza, LocalDateTime fechaNacimiento, String descripcion,
            Long idUsuario) {
        this.nombre = nombre;
        this.genero = genero;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}