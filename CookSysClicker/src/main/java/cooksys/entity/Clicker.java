package cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Clicker {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true)
	private String userName;
	
	private Long score;
	
	private Long autoClickers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getAutoClickers() {
		return autoClickers;
	}

	public void setAutoClickers(Long autoClickers) {
		this.autoClickers = autoClickers;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Clicker [id=").append(id).append(", userName=").append(userName).append(", score=")
				.append(score).append(", autoClickers=").append(autoClickers).append("]");
		return builder.toString();
	}
	
}
