package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @NotNull
    @Size(min = 10, max = 50)
    @Column(name ="event_name")
    private String name;

    @Size(min = 20, max = 250)
    @Column(name ="event_description")
    private String description;

    @NotNull
    @Size(min = 10, max = 200)
    @Column(name ="event_address")
    private String address;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name ="event_city")
    private String city;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name ="event_type")

    private String type;
    @NotNull
    @Column(name ="event_date")
    private String date;

    @NotNull
    @Size(min = 4, max = 8)
    @Column(name ="event_start_time")
    private String startTime;

    @NotNull
    @Size(min = 4, max = 8)
    @Column(name ="event_end_time")
    private String endTime;


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
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
