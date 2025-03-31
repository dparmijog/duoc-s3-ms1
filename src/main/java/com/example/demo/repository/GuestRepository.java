package com.example.demo.repository;

import com.example.demo.models.Guest;
import com.github.f4b6a3.ulid.UlidCreator;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GuestRepository {

    private final static List<String> names = List.of(
            "El Rincón del Michi",
            "Bigotes & Co.",
            "Patas de Seda",
            "Cola Feliz",
            "Ronroneo Boutique",
            "Delicias Caninas",
            "GourPet",
            "Croquetas & Mimos",
            "La Cocina del Perro",
            "Snacks con Huella",
            "Peluches y Correas",
            "Pets & Outfits",
            "Moda en 4 Patas",
            "Doggie Chic",
            "Gatrunks",
            "Spa Ládreme",
            "Peluquería Woof",
            "Dr. Pets - Farmacia Veterinaria",
            "Hotel Para Bigotes",
            "Pet Lovers Paradise"
    );

    private static final List<Guest> guests = createGuests();

    private static List<Guest> createGuests() {
        return EventRepository.getAll().stream().map(e -> {
            return nRandoms(3, 11).stream().map(i -> {
                String id = UlidCreator.getUlid().toLowerCase();
                String eventId = e.getId();
                String name = names.get(i);
                String location = "Location " + i;
                return new Guest(id, eventId, name, location);
            }).toList();
        }).flatMap(List::stream).toList();
    }

    private static List<Integer> nRandoms (int n0, int n1) {
        return IntStream.range(n0, n1)
                .map(i -> new Random().nextInt(names.size()))
                .distinct()
                .boxed()
                .toList();
    }

    public GuestRepository() {
    }

    public static List<Guest> getAll() {
        return guests;
    }

    public static Optional<Guest> getOne(String id) {
        return guests.stream()
                .filter(guest -> guest.getId().equals(id))
                .findFirst();
    }

    public static List<Guest> getAllByEventId(String eventId) {
        return guests.stream()
                .filter(guest -> guest.getEventId().equals(eventId))
                .collect(Collectors.toList());
    }

    public static Optional<Guest> getRandom() {
        int index = new Random().nextInt(guests.size());
        return Optional.of(guests.get(index));
    }
}
