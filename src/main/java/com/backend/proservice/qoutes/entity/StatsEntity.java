package com.backend.proservice.qoutes.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "qoutes_stats")
public class StatsEntity {
		
	@Id
	@Column(name="COUNT_DATE")
	private LocalDate countDate;
	
	@Column(name="COUNT")
	private double count;

	public LocalDate getCountDate() {
		return countDate;
	}

	public void setCountDate(LocalDate countDate) {
		this.countDate = countDate;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}
}

