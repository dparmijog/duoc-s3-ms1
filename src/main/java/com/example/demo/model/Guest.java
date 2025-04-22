package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    //@JsonIgnore
    @NotNull
    @Column(name ="event_id")
    private Long eventId;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name ="guest_name")
    private String name;

    @Size(min = 20, max = 250)
    @Column(name ="guest_description")
    private String description;

    @Size(min = 2, max = 50)
    @Column(name ="guest_location")
    private String location;

    public Guest() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
