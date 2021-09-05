package com.covidtrack.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SelfAssessment {
	private Integer userId;
	private List<String> symptoms;
	private boolean isTravelHistory = false;
	private boolean isContactedWithCovidPatitent = false;;
	
}
