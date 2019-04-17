package spring.quiz.quiz;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class QuizController {

	@Autowired
	private QuizService quizService;

	@RequestMapping("/quizzes")
	public ModelAndView getAllQuizes(Model model) {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("getAllQuizzes");
	    model.addAttribute("quizzes", quizService.getAllQuizes());
	    
	    return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/quizzes")
	public void addQuiz(@RequestBody Quiz quiz) {
		quizService.addQuiz(quiz);
	}
	
	@RequestMapping("/quizzes/title")
	public Quiz getAllByTitle(@RequestParam("name") String name) {
		return quizService.getByTitle(name);
	}

	@RequestMapping("/quizzes/skill")
	public List<Quiz> getAllBySkill(@RequestParam("name") String name) {
		return quizService.getBySkill(name);
	}
}
