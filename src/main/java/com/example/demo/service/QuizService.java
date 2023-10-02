package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.quiz.QuizDomain;
import com.example.demo.repository.QuizMapper;
@Service
public class QuizService {
	
	@Autowired
	private QuizMapper mapper;
	//クイズ取得
	public List<QuizDomain> selectAll(){
        return mapper.selectAll();
    }
	public int score(List<QuizDomain> data , List<String> answer) {
		int score= 0;
		int count=0;
		for(QuizDomain dto : data) {
			String a = dto.getAnswer();
			String b = answer.get(count);
			if(a.equals(b)) {
				score+=10;
			}
			count++;
		}
		return score;
	}
}
