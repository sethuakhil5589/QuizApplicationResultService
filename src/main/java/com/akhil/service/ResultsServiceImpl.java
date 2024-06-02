package com.akhil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akhil.config.IFeignConfiguration;
import com.akhil.model.Answers;
import com.akhil.model.QuizSubmit;
import com.akhil.model.Results;
import com.akhil.model.WelcomeStudent;
import com.akhil.repo.IResultsRepo;

@Service
public class ResultsServiceImpl implements IResultsService {
	@Autowired
	private IResultsRepo repo;
	@Autowired
	private IFeignConfiguration feign;
	
	@Override
	public WelcomeStudent fetchNoOfQuizzesPlayed(Integer studentId) {
		boolean flag = repo.existsByStudentId(studentId);
		if(flag==false) {
			WelcomeStudent student=new WelcomeStudent(studentId,0L,0L,0L);
			return student;
		}
		return repo.findStudentQuizSummary(studentId);
	}

	@Override
	public String saveResult(Results result) {
		return "Result got saved with Result Id: "+repo.save(result).getResultId();
	}

	@Override
	public String submittingQuiz(QuizSubmit quizSubmit) {
		Integer score = feign.gettingScore(quizSubmit.getAnswers()).getBody();
		System.out.println(score);
		for(Answers answer:quizSubmit.getAnswers()) {
			System.out.println(answer);
		}
		Long marks=score*5L;
		Long totalMarks=quizSubmit.getNoOfQuestions()*5L;
		Results result=new Results(quizSubmit.getQuizId(),quizSubmit.getStudentId(),totalMarks,marks);
		return "result saved with id: "+repo.save(result).getResultId();
	}

}
