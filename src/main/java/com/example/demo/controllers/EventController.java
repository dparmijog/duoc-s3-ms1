package com.example.demo.controllers;


import com.example.demo.model.Event;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("events")
@CrossOrigin
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {

        return eventService.findAllEvents();
        /*.stream().peek(e -> {
            e.setGuests(List.of());
            e.setTimeBlocks(List.of());
        }).toList();*/
    }

    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable Long id) {
        return eventService.findEventById(id);
        /*.map(e -> {
            e.setGuests(GuestRepository.getAllByEventId(e.getId()));
            e.setTimeBlocks(TimeBlockRepository.getAllByEventId(e.getId()));
            return e;
        });*/
    }

    @PostMapping
    public Event postEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public Event postEvent(@PathVariable ("id") Long id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable ("id") Long id) {
        eventService.deleteEventById(id);
    }
}
