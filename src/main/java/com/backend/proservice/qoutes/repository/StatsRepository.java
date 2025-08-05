package com.backend.proservice.qoutes.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.proservice.qoutes.entity.StatsEntity;

@Repository
public interface StatsRepository extends JpaRepository<StatsEntity, LocalDate> {}


