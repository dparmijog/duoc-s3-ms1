package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class Event {
    private String id;
    private String name;
    private String description;
    private String address;
    private String city;
    private String type;
    private String date;
    private String startTime;
    private String endTime;

    private List<TimeBlock> timeBlocks;
    private List<Guest> guests;

    public Event() {
    }

    public Event(String id, String name, String description, String address, String city, String type, String date, String startTime, String endTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.type = type;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<TimeBlock> getTimeBlocks() {
        return timeBlocks;
    }

    public void setTimeBlocks(List<TimeBlock> timeBlocks) {
        this.timeBlocks = timeBlocks;
    }


    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public enum Tag {
        FESTIVAL,
        EXHIBITION,
        WORKSHOP,
        COMPETITION,
        SHOW,
        CELEBRATION,
        FUNDRAISER;

        private static Tag fromString(String name) {
            return Arrays.stream(Tag.values())
                    .filter(tag -> tag.name().equalsIgnoreCase(name))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
