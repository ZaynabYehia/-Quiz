package com.question;

import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer>{
	public List<Question>findAllByQuizTitle(String title);
	public Question findByStatement(String statement);
    
}
