package com.example.demo.controllers;

import com.example.demo.model.Guest;
import com.example.demo.repository.GuestRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping
    public List<Guest> getAllGuests(@RequestParam(required = false) @Nullable Long eventId) {
        if (eventId != null) {
            return guestRepository.findByEventId(eventId);
        }
        return guestRepository.findAll();
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestRepository.save(guest);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable("id") Long id, @RequestBody Guest guest) {
        if(id != null) {
            guest.setId(id);
            return guestRepository.save(guest);
        }
        return null;
    }

    @DeleteMapping
    public void deleteGuest(@RequestParam String id) {
        guestRepository.deleteById(Long.valueOf(id));
    }



}
