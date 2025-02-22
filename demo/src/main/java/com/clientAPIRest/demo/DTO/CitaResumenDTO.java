package com.clientAPIRest.demo.DTO;

import java.util.List;

public class CitaResumenDTO {
    private String nombrePeluquero;
    private int cantidadCitas;
    private List<DetalleCita> citas;

    public CitaResumenDTO(String nombrePeluquero, int cantidadCitas, List<DetalleCita> citas) {
        this.nombrePeluquero = nombrePeluquero;
        this.cantidadCitas = cantidadCitas;
        this.citas = citas;
    }

    public static class DetalleCita {
        private String nombreDueno;
        private String nombreMascota;
        private String telefono;

        public DetalleCita(String nombreDueno, String nombreMascota, String telefono) {
            this.nombreDueno = nombreDueno;
            this.nombreMascota = nombreMascota;
            this.telefono = telefono;
        }
    }

    public String getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    public String getTipo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipo'");
    }

    public Object getUltimaCita() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUltimaCita'");
    }

    public String getNombrePeluquero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombrePeluquero'");
    }

    public String getNombreDueno() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombreDueno'");
    }

    public String getNombreMascota() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombreMascota'");
    }

    public String getTelefono() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTelefono'");
    }
}
