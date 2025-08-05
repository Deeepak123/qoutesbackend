package com.backend.proservice.qoutes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "qoutes_content")
public class QoutesContentEntity {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="QOUTES")
	private String qoutes;
	
	@Column(name="AUTHOR_ID")
	private String authorId;
	
	@Column(name="IS_TOP_HUN")
	private String istopHun;

	public String getQoutes() {
		return qoutes;
	}

	public void setQoutes(String qoutes) {
		this.qoutes = qoutes;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getIstopHun() {
		return istopHun;
	}

	public void setIstopHun(String istopHun) {
		this.istopHun = istopHun;
	}
}