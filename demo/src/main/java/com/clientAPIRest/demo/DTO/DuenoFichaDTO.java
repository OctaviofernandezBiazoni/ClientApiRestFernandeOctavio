package com.clientAPIRest.demo.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class DuenoFichaDTO {
    private String nombre;
    private String apellido;
    private String telefono;
    private List<DetalleMascota> mascotas;

    public DuenoFichaDTO(String nombre, String apellido, String telefono, List<DetalleMascota> mascotas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mascotas = mascotas;
    }

    public static class DetalleMascota {
        private String nombreMascota;
        private LocalDateTime ultimaCita;

        public DetalleMascota(String nombreMascota, LocalDateTime ultimaCita) {
            this.nombreMascota = nombreMascota;
            this.ultimaCita = ultimaCita;
        }
    }

    public String getTelefono() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTelefono'");
    }

    public String getNombreDueno() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombreDueno'");
    }

    public class MascotaFicha {

        public String getNombreMascota() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getNombreMascota'");
        }

        public String getTipo() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getTipo'");
        }

        public Object getUltimaCita() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getUltimaCita'");
        }
    }

    public MascotaFicha[] getMascotas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMascotas'");
    }
}
