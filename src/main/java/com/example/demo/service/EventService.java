package com.example.demo.service;

import com.example.demo.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface EventService {
    Optional<Event> findEventById(Long id);
    Event createEvent(Event event);
    Event updateEvent(Long id, Event event);
    void deleteEventById(Long id);
    List<Event> findAllEvents();
}
