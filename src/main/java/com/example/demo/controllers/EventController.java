package com.example.demo.controllers;


import com.example.demo.models.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.GuestRepository;
import com.example.demo.repository.TimeBlockRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("events")
public class EventController {


    public EventController() {
    }

    @GetMapping
    public List<Event> getAll() {

        return EventRepository.getAll().stream().peek(e -> {
            e.setGuests(List.of());
            e.setTimeBlocks(List.of());
        }).toList();
    }

    @GetMapping("/{id}")
    public Optional<Event> getOne(@PathVariable String id) {
        Optional<Event> event = EventRepository.getOne(id);
        return event.map(e -> {
            e.setGuests(GuestRepository.getAllByEventId(e.getId()));
            e.setTimeBlocks(TimeBlockRepository.getAllByEventId(e.getId()));
            return e;
        });
    }

    @GetMapping("/random")
    public Event getAny() {
        Event event = EventRepository.getRandom();
        event.setGuests(GuestRepository.getAllByEventId(event.getId()));
        event.setTimeBlocks(TimeBlockRepository.getAllByEventId(event.getId()));
        return event;
    }
}
