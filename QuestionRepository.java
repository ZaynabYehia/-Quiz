package spring.quiz.question;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer>{
	public List<Question> findAllByQuizTitle(String title);
}
