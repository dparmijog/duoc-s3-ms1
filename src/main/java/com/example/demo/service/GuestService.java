package com.example.demo.service;

import com.example.demo.model.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestService {
    Optional<Guest> findById(Long id);
    Guest createGuest(Guest guest);
    Guest updateGuest(String id, Guest guest);
    void deleteGuestById(String id);
    List<Guest> findAllGuests();
}
