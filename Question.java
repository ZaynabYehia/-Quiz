package spring.quiz.question;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import spring.quiz.quiz.Quiz;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Integer id;
	private String statement;
	private int numOfChoices;
	private String choices[];
	private String correctChoice;
	@ManyToOne
	private Quiz quiz;

	Question() {
		quiz = new Quiz();
	}

	Question(String statement, int numOfChoices, String choices[], String correctChoice) {
		this.statement = statement;
		this.numOfChoices = numOfChoices;
		this.choices = choices;
		this.correctChoice = correctChoice;
		quiz = new Quiz();
	}

	public boolean isValid() {
		for (int i = 0; i < numOfChoices; i++)
			if (correctChoice == choices[i])
				return true;
		return false;
	}

	public int getNumOfChoices() {
		return numOfChoices;
	}

	public void setNumOfChoices(int numOfChoices) {
		this.numOfChoices = numOfChoices;
	}

	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String choices[]) {
		this.choices = choices;
	}

	public String getCorrectChoice() {
		return correctChoice;
	}

	public void setCorrectChoice(String correctChoice) {
		this.correctChoice = correctChoice;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public Quiz getQuiz() {
		return quiz;
	}
}
