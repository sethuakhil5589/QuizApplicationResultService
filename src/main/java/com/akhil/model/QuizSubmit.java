package com.akhil.model;

import java.util.List;

import lombok.Data;

@Data
public class QuizSubmit {
	private Integer studentId;
	private Integer quizId;
	private Integer noOfQuestions;
	private List<Answers> answers;
}
