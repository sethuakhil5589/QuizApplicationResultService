package com.akhil.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.akhil.model.Answers;
@FeignClient("QuizApplicationQuestionService.v2")
public interface IFeignConfiguration {
	@PostMapping("/questions/submit")
	public ResponseEntity<Integer> gettingScore(@RequestBody List<Answers> answers);
}
