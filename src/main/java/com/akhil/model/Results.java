package com.akhil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Results {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer resultId;
	private Integer quizId;
	private Integer studentId;
	private Long totalMarks;
	private Long scoredMarks;
	public Results(Integer quizId, Integer studentId, Long totalMarks, Long scoredMarks) {
		super();
		this.quizId = quizId;
		this.studentId = studentId;
		this.totalMarks = totalMarks;
		this.scoredMarks = scoredMarks;
	}

}
