package com.akhil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.model.QuizSubmit;
import com.akhil.model.Results;
import com.akhil.model.WelcomeStudent;
import com.akhil.service.IResultsService;

@RestController
@RequestMapping("/result")
public class ResultController {
	@Autowired
	private IResultsService service;
	
	@GetMapping("/quizSummary/{studentId}")
	public ResponseEntity<WelcomeStudent> getNoOfQuizzesPlayed(@PathVariable Integer studentId){
		return new ResponseEntity<>(service.fetchNoOfQuizzesPlayed(studentId),HttpStatus.OK);
	}
	
	@PostMapping("/saveResult")
	public ResponseEntity<String> saveResult(@RequestBody Results result){
		return new ResponseEntity<>(service.saveResult(result),HttpStatus.OK);
	}
	
	@PostMapping("/submit")
	public ResponseEntity<String> submittingQuiz(@RequestBody QuizSubmit quizSubmit){
		return new ResponseEntity<>(service.submittingQuiz(quizSubmit),HttpStatus.OK);
	}
}
