package spring.quiz.quiz;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Quiz {
	@Id
	private String title;
	private String skill;
	private int numOfQuestions;
	private int passScore;
	private int duration;

	public Quiz() {this.numOfQuestions = 0;}

	public Quiz(String title, String skill, int passScore, int duration) {
		this.numOfQuestions = 0;
		this.title = title;
		this.skill = skill;
		this.passScore = passScore;
		this.duration = duration;
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

	public int getPassScore() {
		return passScore;
	}

	public void setPassScore(int passScore) {
		this.passScore = passScore;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void inc() {
		++numOfQuestions;
	}
	
	public void dec() {
		--numOfQuestions;
	}
}
