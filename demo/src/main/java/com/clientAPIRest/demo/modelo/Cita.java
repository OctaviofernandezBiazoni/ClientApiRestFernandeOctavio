package com.clientAPIRest.demo.modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Mascota mascota;

    @ManyToOne
    private Peluquero peluquero;

    private LocalDateTime fecha;

    public Cita(LocalDateTime localDateTime, Mascota mascota2, Peluquero peluquero2) {}


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((mascota == null) ? 0 : mascota.hashCode());
        result = prime * result + ((peluquero == null) ? 0 : peluquero.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cita other = (Cita) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (mascota == null) {
            if (other.mascota != null)
                return false;
        } else if (!mascota.equals(other.mascota))
            return false;
        if (peluquero == null) {
            if (other.peluquero != null)
                return false;
        } else if (!peluquero.equals(other.peluquero))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        return true;
    }


    public Long getId() {
        return id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Peluquero getPeluquero() {
        return peluquero;
    }

    public void setPeluquero(Peluquero peluquero) {
        this.peluquero = peluquero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", mascota=" + mascota +
                ", peluquero=" + peluquero +
                ", fecha=" + fecha +
                '}';
    }
}
