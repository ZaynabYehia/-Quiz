package spring.quiz.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("/questions/{quizTitle}")
	public List<Question> getAllQuestionsOfThisQuiz(@PathVariable String quizTitle){
		return questionService.getByQuizTitle(quizTitle);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/questions/{quizTitle")
	public void addQuestion(@PathVariable String quizTitle, @RequestBody Question question) {
		question.getQuiz().setTitle(quizTitle);
		questionService.addQuestion(question);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/questions/{quizTitle}")
	public void updateQuestion(@PathVariable String quizTitle, @RequestBody Question question) {
		question.getQuiz().setTitle(quizTitle);
		questionService.updateQuestion(question);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/questions")
	public void addQuestion(@RequestParam("Id") int id) {
		questionService.deleteQuestion(Integer.valueOf(id));
	}
}
