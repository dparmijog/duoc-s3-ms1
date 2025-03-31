package com.example.demo.repository;

import com.example.demo.models.Event;
import com.example.demo.models.TimeBlock;
import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TimeBlockRepository {

    public static final List<TimeBlock> timeBlocks = createTimeBlocks();

    public TimeBlockRepository() {
    }

    public static List<TimeBlock> createTimeBlocks() {

        return EventRepository.getAll().stream()
                .map(e -> {
                    List<TimeBlock> timeBlocks = new ArrayList<>();
                    IntStream.range(0, 3).forEach(i -> {
                        int startHour = new Random().nextInt(9, 19);
                        int duration = new Random().nextInt(1, 4);
                        String id = UlidCreator.getUlid().toLowerCase();
                        String eventId = e.getId();
                        String title = "Time Block " + (i + 1);
                        String description = "Description for Time Block " + (i + 1);
                        String startTime = String.format("%d:%s", startHour, "00");
                        String endTime = String.format("%d:%s", startHour+duration, "00");
                        String location = String.format("%s %d", "LOC", new Random().nextInt(1000));

                        TimeBlock timeBlock = new TimeBlock(id, eventId, title, description, startTime, endTime, location);
                        timeBlocks.add(timeBlock);
                    });
                    return timeBlocks;
                })   .flatMap(List::stream).toList();
    }


    public static List<TimeBlock> getAll() {
        return timeBlocks;
    }

    public static List<TimeBlock> getAllByEventId(String eventId) {
        return timeBlocks.stream()
                .filter(e -> e.getEventId().equals(eventId))
                .toList();
    }

    public static Optional<TimeBlock> getOne(String id) {
        return timeBlocks.stream()
                .filter(guest  -> guest.getId().equals(id))
                .findFirst();
    }

    public static TimeBlock getRandom() {
        int index = new Random().nextInt(timeBlocks.size());
        return timeBlocks.get(index);
    }
}
