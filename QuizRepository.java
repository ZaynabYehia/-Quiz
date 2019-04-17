package spring.quiz.quiz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, String> {
	public List<Quiz> findBySkill(String skill);

}
