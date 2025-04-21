package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import jakarta.persistence.*;

import java.util.Arrays;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    @Column(name ="event_name")
    private String name;
    @Column(name ="event_description")
    private String description;
    @Column(name ="event_address")
    private String address;
    @Column(name ="event_city")
    private String city;
    @Column(name ="event_type")
    private String type;
    @Column(name ="event_date")
    private String date;
    @Column(name ="event_start_time")
    private String startTime;
    @Column(name ="event_end_time")
    private String endTime;

/*    private List<TimeBlock> timeBlocks;
    private List<Guest> guests;*/

    public Event() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    /*public List<TimeBlock> getTimeBlocks() {
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
    }*/

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
