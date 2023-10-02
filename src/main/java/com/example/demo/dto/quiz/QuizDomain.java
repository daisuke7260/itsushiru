package com.example.demo.dto.quiz;

import lombok.Data;

@Data
public class QuizDomain {
	//識別用
	private Integer id;
	//問題の題名
	private String name;
	//問題の内容
	private String content;
	//問題の答え
	private String answer;
	//問題解説
	private String explanation;
	//問題種類
	private String field;
}
