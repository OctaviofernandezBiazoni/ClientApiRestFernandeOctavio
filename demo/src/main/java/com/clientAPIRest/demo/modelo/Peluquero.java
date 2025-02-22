package com.clientAPIRest.demo.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Peluquero {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

   @OneToMany(fetch = FetchType.EAGER)
   private List<Mascota> mascotas;
   

    public Peluquero() {}

    // Constructor
    public Peluquero(String nombre) {
        this.nombre = nombre;
        this.mascotas = new ArrayList<>();
    }

    // Método para asignar mascota a peluquero
    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    @Override
    public String toString() {
        return "Peluquero{" +
                "nombre='" + nombre + '\'' +
                ", mascotas=" + mascotas +
                '}';
    }

    public Long getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
