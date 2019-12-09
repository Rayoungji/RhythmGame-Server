package org.zerock.domain.dto.Ranking;

public class RankDto {
	
	private String song;
	private int score;
	private String id;  //사용자 아이디
	
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
