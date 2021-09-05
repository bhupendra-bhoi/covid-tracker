package com.covidtrack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class CovidResult {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer resultId;
	private Integer userId;
	private Integer adminId;
	private String result;
}
