package com.question;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.quiz.Quiz;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	private final QuestionService questionService;
	
	public QuestionController(QuestionService questionServ) {
		questionService = questionServ;
	}

	@RequestMapping("/{quizTitle}")
	public String addQuestion(Model model, @PathVariable String quizTitle) {
		model.addAttribute("title", quizTitle);
		return "addQuestion";
	}

	@RequestMapping(value = "/{quizTitle}", method = RequestMethod.POST)
	public RedirectView addQuestion(Model model, @PathVariable(name = "quizTitle") String title,
			@RequestParam(name = "statement") String statement, @RequestParam(name = "choice1") String choice1,
			@RequestParam(name = "choice2") String choice2, @RequestParam(name = "choice3") String choice3,
			@RequestParam(name = "choice4") String choice4,
			@RequestParam(name = "correctChoice") String correctChoice) {

		String[] choices = { choice1, choice2, choice3, choice4 };
		Question question = new Question(statement, choices, correctChoice, new Quiz(title, "", 0, 0));
		boolean ret = questionService.validateQuestion(question);
		
		if (ret) {
			questionService.addQuestoin(question);
			return new RedirectView("/quizzes/" + title + "/counter");
		} else {
//			model.addAttribute("errorMessage", "correct choice should be one of the 4 choices");
			return new RedirectView("/questions/" + title);
		}
	}

	@RequestMapping("/takequiz/{title}")
	public String takeQuiz(Model model, @PathVariable String title) {

		List<Question> list = questionService.findAllByQuiz(title);
		model.addAttribute("questions", list);
		model.addAttribute("quizTitle", title);

		return "takeQuiz";
	}

	@RequestMapping(value = "/takequiz/{title}/submit", method = RequestMethod.POST)
	public String submit(HttpServletRequest request) {
		String[] questionStatements = request.getParameterValues("questionStatement");
		int score = 0;
		for (int i = 0; i < questionStatements.length; i++) {

			Question question = questionService.getByStatement(questionStatements[i]);
			if (question.getCorrectChoice().equals(request.getParameter(questionStatements[i]))) {
				score++;
			}
		}
		request.setAttribute("score", score);
		return "quizResult";
	}

	@RequestMapping(value = "/TimeOut")
	public String timeOut() {

		return "TimeOut";
	}
}
