package com.example.demo.repository;

import com.example.demo.model.Guest;
import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
