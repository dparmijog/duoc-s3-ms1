package com.example.demo.service;

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


    @Override
    public Optional<Guest> findById(Long id) {

        return guestRepository.findById(id);
    }

    @Override
    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest updateGuest(String id, Guest guest) {
        Optional<Guest> existingGuest = guestRepository.findById(Long.valueOf(id));
        if (existingGuest.isPresent()) {
            Guest updatedGuest = existingGuest.get();
            updatedGuest.setName(guest.getName());
            updatedGuest.setDescription(guest.getDescription());
            updatedGuest.setLocation(guest.getLocation());
            return guestRepository.save(updatedGuest);
        }
        throw new IllegalArgumentException("Guest with ID " + id + " not found");
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