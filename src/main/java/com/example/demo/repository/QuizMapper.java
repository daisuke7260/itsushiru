package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.quiz.QuizDomain;

@Mapper
public interface QuizMapper {
	
	List<QuizDomain> selectAll();

}
