package com.example.demo.controllers;

import com.example.demo.models.Guest;
import com.example.demo.repository.GuestRepository;
import jakarta.annotation.Nullable;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private GuestRepository guestRepository;

    public GuestController() {
    }

    @GetMapping
    public List<Guest> getAll(@RequestParam("e") String eventId) {
        if (eventId != null) {
            return GuestRepository.getAllByEventId(eventId);
        }
        return List.of();
    }

    @GetMapping("/{id}")
    public Optional<Guest> getOne(@PathVariable("id") String id) {
        return GuestRepository.getOne(id);
    }

    @GetMapping("/random")
    public Optional<Guest> getAny() {
        return GuestRepository.getRandom();
    }
}
