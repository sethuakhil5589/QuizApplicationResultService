package com.akhil.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WelcomeStudent {
	private Integer studentId;
	private Long noOfQuizzesPlayed;
	private Long totalMarks;
	private Long scoredMarks;
}
