package com.question;

import java.util.Arrays;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.quiz.Quiz;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Integer id;
	private String statement;
	private String[] choices;
	private String correctChoice;
	@ManyToOne
	private Quiz quiz;

	public Question() {
	};

	public Question(String statement, String[] choices, String correctChoice, Quiz quiz) {
		super();
		this.statement = statement;
		this.choices = choices;
		this.correctChoice = correctChoice;
		this.quiz = quiz;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statment) {
		this.statement = statment;
	}

	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}

	public String getCorrectChoice() {
		return correctChoice;
	}

	public void setCorrectChoice(String correctChoice) {
		this.correctChoice = correctChoice;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(choices);
		result = prime * result + ((correctChoice == null) ? 0 : correctChoice.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quiz == null) ? 0 : quiz.hashCode());
		result = prime * result + ((statement == null) ? 0 : statement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (!Arrays.equals(choices, other.choices))
			return false;
		if (correctChoice == null) {
			if (other.correctChoice != null)
				return false;
		} else if (!correctChoice.equals(other.correctChoice))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quiz == null) {
			if (other.quiz != null)
				return false;
		} else if (!quiz.equals(other.quiz))
			return false;
		if (statement == null) {
			if (other.statement != null)
				return false;
		} else if (!statement.equals(other.statement))
			return false;
		return true;
	}
}
