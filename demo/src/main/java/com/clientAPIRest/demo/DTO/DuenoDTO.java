package com.clientAPIRest.demo.DTO;

public class DuenoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;

    public DuenoDTO() {}

    public DuenoDTO(Object id, String nombre, String apellido, String telefono) {
        this.id = (Long) id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}