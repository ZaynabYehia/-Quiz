package com.quiz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, String>{
  public List<Quiz>findAllBySkill(String skill); 
}
