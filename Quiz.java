package com.quiz;

import javax.persistence.Entity;


import javax.persistence.Id;

@Entity
public class Quiz {
	public Integer getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(Integer numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

	@Id
	private String title;
	private String skill;
	private Integer passScore;
	private Integer duration;
	private Integer numberOfQuestion;
	
	public Quiz() {};
	
	public Quiz(String title, String skill, Integer passScore, Integer duration) {
		super();
		this.title = title;
		this.skill = skill;
		this.passScore = passScore;
		this.duration = duration;
		this.numberOfQuestion = 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getPassScore() {
		return passScore;
	}

	public void setPassScore(Integer passScore) {
		this.passScore = passScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((numberOfQuestion == null) ? 0 : numberOfQuestion.hashCode());
		result = prime * result + ((passScore == null) ? 0 : passScore.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Quiz other = (Quiz) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (numberOfQuestion == null) {
			if (other.numberOfQuestion != null)
				return false;
		} else if (!numberOfQuestion.equals(other.numberOfQuestion))
			return false;
		if (passScore == null) {
			if (other.passScore != null)
				return false;
		} else if (!passScore.equals(other.passScore))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
