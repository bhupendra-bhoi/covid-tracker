package com.covidtrack.service;

import org.springframework.stereotype.Service;

import com.covidtrack.model.SelfAssessment;
import com.covidtrack.model.response.UserResponse;

@Service
public class SelfAssessmentService {

	public UserResponse assessSymptopms(SelfAssessment selfAssessment) {
		int riskPercentage = 5;
		if(selfAssessment.getSymptoms().size()==0 
				&& !selfAssessment.isContactedWithCovidPatitent() 
				&& !selfAssessment.isTravelHistory())
			riskPercentage = 5;
		else if(selfAssessment.getSymptoms().size() == 1
				&& (selfAssessment.isContactedWithCovidPatitent() 
						|| selfAssessment.isTravelHistory()))
			riskPercentage = 50;
		else if(selfAssessment.getSymptoms().size() == 2
				&& (selfAssessment.isContactedWithCovidPatitent() 
						|| selfAssessment.isTravelHistory()))
			riskPercentage = 75;
		else if(selfAssessment.getSymptoms().size() > 2
				&& (selfAssessment.isContactedWithCovidPatitent() 
						|| selfAssessment.isTravelHistory()))
			riskPercentage = 95;
		return new UserResponse("riskPercentage", riskPercentage);
	}

}
