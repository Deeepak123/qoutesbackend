package com.backend.proservice.qoutes.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.proservice.qoutes.entity.StatsEntity;

@Repository
public interface StatsRepository extends JpaRepository<StatsEntity, LocalDate> {
	
	@Query(value = "SELECT * FROM qoutes_stats WHERE COUNT_DATE >= CURDATE() - INTERVAL 30 DAY ORDER BY COUNT_DATE DESC", nativeQuery = true)
    List<StatsEntity> findLast30DaysStats();
}


