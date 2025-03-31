package com.example.demo.repository;

import com.example.demo.models.Event;
import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

public class EventRepository {
    public static List<Event> events = List.of(
            // Adopciones
            new Event(createId(), "Adopción Masiva de Perritos",
                    "Evento de adopción con +50 perros rescatados", "Parque Central", "Ciudad de México",
                    "Adopción", "2023-12-03", "10:00", "16:00"),

            // Competencias
            new Event(createId(), "Concurso de Agility para Perros",
                    "Competencia de obstáculos para perros entrenados", "Canódromo Municipal", "Bogotá",
                    "Competencia", "2023-11-19", "09:30", "14:00"),

            // Educativos
            new Event(createId(), "Taller de Primeros Auxilios para Mascotas",
                    "Aprende RCP y cuidados básicos para emergencias", "Clínica Veterinaria Central", "Medellín",
                    "Taller", "2023-11-25", "15:00", "18:00"),

            // Sociales
            new Event(createId(), "Yappy Hour - Bar para Perros",
                    "Socialización canina con snacks saludables", "DogBar Terraza", "Buenos Aires",
                    "Social", "2023-12-09", "17:00", "20:00"),

            // Terapias
            new Event(createId(), "Terapia Asistida con Perros en Hospital",
                    "Visita de perros de terapia a niños enfermos", "Hospital Infantil", "Santiago",
                    "Terapia", "2023-12-15", "11:00", "13:00"),

            // Exposiciones
            new Event(createId(), "Expo Gatos 2023",
                    "Exhibición de razas felinas con jueces internacionales", "Centro de Convenciones", "Lima",
                    "Exposición", "2023-11-26", "10:00", "19:00"),

            // Baños comunitarios
            new Event(createId(), "Día del Baño Gratis para Mascotas",
                    "Estaciones de baño y grooming patrocinadas", "Plaza de Armas", "Montevideo",
                    "Servicio", "2023-12-10", "09:00", "13:00"),

            // Eventos temáticos
            new Event(createId(), "Halloween para Perros",
                    "Concurso de disfraces y búsqueda de tesoros canina", "PetPark", "Sao Paulo",
                    "Fiesta", "2023-10-29", "16:00", "19:00"),

            // Voluntariado
            new Event(createId(), "Jornada de Vacunación Antirrábica",
                    "Vacunación gratuita para perros y gatos", "Unidad Deportiva", "Guadalajara",
                    "Salud", "2023-11-12", "08:00", "14:00"),

            // Deportes
            new Event(createId(), "Carrera Canina 5K",
                    "Carrera donde correrás con tu perro", "Bosque Urbano", "Córdoba",
                    "Deporte", "2023-12-17", "07:30", "11:00"),

            // Exóticos
            new Event(createId(), "Encuentro de Aves Exóticas",
                    "Charlas sobre cuidado de loros y aves tropicales", "Jardín Botánico", "Caracas",
                    "Educativo", "2023-11-18", "13:00", "17:00")
    );

    private static String createId() {
        return UlidCreator.getUlid().toLowerCase();
    }



    public static List<Event> getAll() {
        return events;
    }

    public static Optional<Event> getOne(String id) {
        return events.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public static Event getRandom() {
        int index = new Random().nextInt(events.size());
        return events.get(index);
    }


}
