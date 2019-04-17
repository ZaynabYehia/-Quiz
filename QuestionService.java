package spring.quiz.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> getByQuizTitle(String title){
		return questionRepository.findAllByQuizTitle(title);
	}
	
	public Question getQuestion(Integer id) {
		return questionRepository.findById(id).orElse(null);
	}
	
	public void addQuestion(Question question) {
		question.getQuiz().inc();
		questionRepository.save(question);
	}
	
	public void deleteQuestion(Integer id) {
		getQuestion(id).getQuiz().inc();
		questionRepository.deleteById(id);
	}
	
	public void updateQuestion(Question question) {
		questionRepository.save(question);
	}
}
