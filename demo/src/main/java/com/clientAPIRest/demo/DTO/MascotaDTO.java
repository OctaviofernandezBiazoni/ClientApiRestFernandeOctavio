package com.clientAPIRest.demo.DTO;

public class MascotaDTO {
    private Long id;
    private String nombre;
    private String tipo;
    private String raza;
    private Long duenoId;
    private Long peluqueroId;

    public MascotaDTO() {}

    public MascotaDTO(Long id, String nombre, String tipo, String raza, Long duenoId, Long peluqueroId) {
        this.id = (Long)id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.duenoId = duenoId;
        this.peluqueroId = peluqueroId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Long getDuenoId() {
        return duenoId;
    }

    public void setDuenoId(Long duenoId) {
        this.duenoId = duenoId;
    }

    public Long getPeluqueroId() {
        return peluqueroId;
    }

    public void setPeluqueroId(Long peluqueroId) {
        this.peluqueroId = peluqueroId;
    }
}