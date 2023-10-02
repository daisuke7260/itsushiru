package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.quiz.QuizDomain;
import com.example.demo.service.QuizService;

@Controller
public class Trivia {
	
	private QuizService quizservice;
	
	//問題保存用
	List<QuizDomain> data;
	@GetMapping("/trivia")
	public String getTrivia(Model model) {
		data = quizservice.selectAll();
		for(QuizDomain dto : data) {
			System.out.println(dto.getAnswer());
		}
		model.addAttribute("testData",data);
		//雑学問題表示ページ		
		return "/trivia";
	}
	@PostMapping("/trivia")
	public String postTrivia(Model model,
			@RequestParam("userAnswers1") String UserAnswers1,
			@RequestParam("userAnswers2") String UserAnswers2,
			@RequestParam("userAnswers3") String UserAnswers3,
			@RequestParam("userAnswers4") String UserAnswers4,
			@RequestParam("userAnswers5") String UserAnswers5,
			@RequestParam("userAnswers6") String UserAnswers6,
			@RequestParam("userAnswers7") String UserAnswers7,
			@RequestParam("userAnswers8") String UserAnswers8,
			@RequestParam("userAnswers9") String UserAnswers9,
			@RequestParam("userAnswers10") String UserAnswers10)
	{		
		List<String> userAnswers =new ArrayList<String>();
		userAnswers.add(UserAnswers1);
		userAnswers.add(UserAnswers2);
		userAnswers.add(UserAnswers3);
		userAnswers.add(UserAnswers4);
		userAnswers.add(UserAnswers5);
		userAnswers.add(UserAnswers6);
		userAnswers.add(UserAnswers7);
		userAnswers.add(UserAnswers8);
		userAnswers.add(UserAnswers9);
		userAnswers.add(UserAnswers10);
		System.out.println(quizservice.score(data,userAnswers));
		int score = quizservice.score(data,userAnswers);
		model.addAttribute("score",score);
		model.addAttribute("quiz",data);
		model.addAttribute("userAnswers",userAnswers);
		//回答結果表示ページ
		return "/posttrivia";
	}
}
