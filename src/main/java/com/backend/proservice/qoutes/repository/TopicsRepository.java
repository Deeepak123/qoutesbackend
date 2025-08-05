package com.backend.proservice.qoutes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.proservice.qoutes.entity.TopicsEntity;

@Repository
public interface TopicsRepository extends JpaRepository<TopicsEntity, Long> {}

