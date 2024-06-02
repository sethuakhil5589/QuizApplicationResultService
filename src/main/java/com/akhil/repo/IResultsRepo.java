package com.akhil.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.akhil.model.Results;
import com.akhil.model.WelcomeStudent;

public interface IResultsRepo extends JpaRepository<Results, Integer> {
	@Query("SELECT new com.akhil.model.WelcomeStudent(r.studentId, COUNT(r), SUM(r.totalMarks), SUM(r.scoredMarks)) " +
	           "FROM Results r WHERE r.studentId = :studentId GROUP BY r.studentId")
	    WelcomeStudent findStudentQuizSummary(@Param("studentId") Integer studentId);
	
	@Query("SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END FROM Results r WHERE r.studentId = :studentId")
    boolean existsByStudentId(@Param("studentId") Integer studentId);
}
