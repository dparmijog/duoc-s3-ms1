package com.example.demo.service;

import com.example.demo.model.Event;
import com.example.demo.model.Guest;
import com.example.demo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private EventService eventService;


    @Override
    public Optional<Guest> findById(Long id) {

        return guestRepository.findById(id);
    }

    @Override
    public Guest createGuest(Guest guest) {
        Optional<Event> event = eventService.findEventById(guest.getEventId());
        if (!event.isPresent()) {
            throw new IllegalArgumentException("Evento no encontrado");

        }
        return guestRepository.save(guest);
    }

    @Override
    public Guest updateGuest(String id, Guest guest) {
        Optional<Guest> existingGuest = guestRepository.findById(Long.valueOf(id));
        Optional<Event> event = eventService.findEventById(guest.getEventId());
        if(!existingGuest.isPresent()) {
            throw new IllegalArgumentException("Invitado no encontrado");
        }
        if (!event.isPresent()) {
            throw new IllegalArgumentException("Evento no encontrado");
        }
        guest.setId(existingGuest.get().getId());
        return guestRepository.save(guest);
    }

    @Override
    public void deleteGuestById(String id) {
        guestRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public List<Guest> findAllGuests() {
        return guestRepository.findAll();
    }
}