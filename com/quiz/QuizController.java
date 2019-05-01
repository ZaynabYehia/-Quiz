package com.quiz;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/quizzes")
public class QuizController {
	private final QuizService quizService;
	
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	@GetMapping
	public String getAllQuizzes(Model model) {
		List<Quiz> quizzes = quizService.getAllQuizzes();
		model.addAttribute("quizzes", quizzes);
		return "quizzes";
	}
	@RequestMapping(value = "/{skill}")
	public String getAllBySkill(Model model,@PathVariable String skill) {
		List<Quiz> quizzes = quizService.getAllBySkill(skill);
		model.addAttribute("quizzes", quizzes);
		return "quizzes";
	}
	@RequestMapping(value = "/addQuiz")
	public String addQuiz() {
		return "addQuiz";
	}
	
	@RequestMapping(value = "/{quizTitle}/counter")
	public RedirectView updateCounter(@PathVariable(name = "quizTitle") String title) {
		quizService.increment(title);
		return new RedirectView("/quizzes");
	}
	
	@PostMapping
	public RedirectView addQuiz(Model model, @RequestParam(name = "title") String title, @RequestParam(name = "skill") String skill, @RequestParam(name = "passScore") Integer passScore, @RequestParam(name = "duration") Integer duration) {
		quizService.addQuiz(new Quiz(title, skill, passScore, duration));
		return new RedirectView("/quizzes");
	}
}
