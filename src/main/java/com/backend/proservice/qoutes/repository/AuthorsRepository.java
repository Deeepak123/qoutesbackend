package com.backend.proservice.qoutes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.proservice.qoutes.entity.AuthorsEntity;

@Repository
public interface AuthorsRepository extends JpaRepository<AuthorsEntity, Long> {}

