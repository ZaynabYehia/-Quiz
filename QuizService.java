package spring.quiz.quiz;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

	@Autowired
	private QuizRepository quizRepository;

	public Quiz getByTitle(String title) {
		return quizRepository.findById(title).orElse(null);
	}
	
	public List<Quiz> getBySkill(String skill){
		List<Quiz> quizzes = new ArrayList<Quiz>();
		quizRepository.findBySkill(skill).forEach(quizzes::add);
		return quizzes;
	}

	public void addQuiz(Quiz quiz) {
		quizRepository.save(quiz);
	}

	public List<Quiz> getAllQuizes() {
		List<Quiz> quizes = new ArrayList<>();
		quizRepository.findAll().forEach(quizes::add);
		return quizes;
	}
}
