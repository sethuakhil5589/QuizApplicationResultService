package com.akhil.service;

import com.akhil.model.QuizSubmit;
import com.akhil.model.Results;
import com.akhil.model.WelcomeStudent;

public interface IResultsService {
	WelcomeStudent fetchNoOfQuizzesPlayed(Integer studentId);
	String saveResult(Results result);
	String submittingQuiz(QuizSubmit quizSubmit);
}
