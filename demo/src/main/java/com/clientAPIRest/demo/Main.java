package com.clientAPIRest.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clientAPIRest.demo.DTO.CitaResumenDTO;
import com.clientAPIRest.demo.DTO.DuenoFichaDTO;
import com.clientAPIRest.demo.modelo.Cita;
import com.clientAPIRest.demo.modelo.Dueno;
import com.clientAPIRest.demo.modelo.Mascota;
import com.clientAPIRest.demo.modelo.Peluquero;
import com.clientAPIRest.demo.modelo.Tipo;
import com.clientAPIRest.demo.repository.CitaRepository;
import com.clientAPIRest.demo.repository.DuenoRepository;
import com.clientAPIRest.demo.repository.MascotaRepository;
import com.clientAPIRest.demo.repository.PeluqueroRepository;
import com.clientAPIRest.demo.service.CitaService;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private DuenoRepository duenoRepository;
    
    @Autowired
    private PeluqueroRepository peluqueroRepository;
    
    @Autowired
    private MascotaRepository mascotaRepository;
    
    @Autowired
    private CitaRepository citaRepository;
    
    @Autowired
    private CitaService citaService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("\n========= Iniciando aplicación =========\n");

        // 📌 1. Crear datos de prueba
        cargarDatosIniciales();

        // 📌 2. Consultar citas por peluquero en una fecha específica
        LocalDate fechaConsulta = LocalDate.now();
        System.out.println("\n📆 Citas para el día: " + fechaConsulta);
        List<CitaResumenDTO> citasPorDia = citaService.getCitasPorDia(fechaConsulta);
        mostrarCitasPorDia(citasPorDia);

        // 📌 3. Consultar fichas de dueños con mascotas y última fecha de baño
        System.out.println("\n📝 Ficha de dueños y última cita de baño:");
        List<DuenoFichaDTO> fichaDuenos = citaService.getFichaDuenos();
        mostrarFichaDuenos(fichaDuenos);

        System.out.println("\n========= Aplicación finalizada =========");
    }

    private void cargarDatosIniciales() {
        System.out.println("📌 Creando datos de prueba...");

        // Crear dueños
        Dueno dueno1 = new Dueno("Juan", "Gómez", "12345678");
        Dueno dueno2 = new Dueno("María", "López", "87654321");
        duenoRepository.saveAll(Arrays.asList(dueno1, dueno2));

        // Crear peluqueros
        Peluquero peluquero1 = new Peluquero("Carlos Pérez");
        Peluquero peluquero2 = new Peluquero("Ana Ramírez");
        peluqueroRepository.saveAll(Arrays.asList(peluquero1, peluquero2));

        // Crear mascotas
        Mascota mascota1 = new Mascota("Firulais", Tipo.PERRO, "Labrador", dueno1);
        Mascota mascota2 = new Mascota("Michi", Tipo.GATO, "Siames", dueno2);
        mascotaRepository.saveAll(Arrays.asList(mascota1, mascota2));

        // Crear citas
        Cita cita1 = new Cita(LocalDateTime.now().minusDays(5), mascota1, peluquero1);
        Cita cita2 = new Cita(LocalDateTime.now().minusDays(10), mascota2, peluquero2);
        citaRepository.saveAll(Arrays.asList(cita1, cita2));

        System.out.println("✅ Datos de prueba cargados correctamente.");
    }

    private void mostrarCitasPorDia(List<CitaResumenDTO> citas) {
        if (citas.isEmpty()) {
            System.out.println("❌ No hay citas para este día.");
        } else {
            for (CitaResumenDTO cita : citas) {
                System.out.println("\n🔹 Peluquero: " + cita.getNombrePeluquero());
                System.out.println("   📌 Dueño: " + cita.getNombreDueno());
                System.out.println("   🐶 Mascota: " + cita.getNombreMascota());
                System.out.println("   📞 Teléfono: " + cita.getTelefono());
            }
        }
    }

    private void mostrarFichaDuenos(List<DuenoFichaDTO> fichas) {
        if (fichas.isEmpty()) {
            System.out.println("❌ No hay fichas de dueños registradas.");
        } else {
            for (DuenoFichaDTO ficha : fichas) {
                System.out.println("\n👤 Dueño: " + ficha.getNombreDueno());
                System.out.println("   📞 Teléfono: " + ficha.getTelefono());
                for (DuenoFichaDTO.MascotaFicha mascotaFicha : ficha.getMascotas()) {
                    System.out.println("   🐾 Mascota: " + mascotaFicha.getNombreMascota() + " (" + mascotaFicha.getTipo() + ")");
                    System.out.println("   🛁 Última cita de baño: " + (mascotaFicha.getUltimaCita() != null ? mascotaFicha.getUltimaCita() : "Nunca"));
                }
            }
        }
    }
}
