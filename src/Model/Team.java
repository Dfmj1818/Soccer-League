package Model;

import java.util.ArrayList;

public class Team {
	private String teamName;
	private int goalsScored;
	private int goalsAgainst;
	private int victories;
	private int loses;
	private int points;
	private int matchesPlayed;
	private int teamId;
	private int draws;
	private int goalsScoredPerMatch;
	private ArrayList<Team>rivalsList;

	public Team(int teamId,String teamName,int points,int goalsScored,int goalsAgainst,int victories,int loses,int matchesPlayed) {
		this.teamName=teamName;
		this.goalsScored=goalsScored;
		this.goalsAgainst=goalsAgainst;
		this.victories=victories;
		this.loses=loses;
		this.matchesPlayed=matchesPlayed;
		this.points=points;
		this.teamId=teamId;
		this.draws=draws;
		rivalsList=new ArrayList<Team>();

	}
	public Team() {

	}


	public void setTeamName(String teamName){
		this.teamName=teamName;   
	}

	public String getTeamName() {
		return teamName;
	}

	public void setGoalsScored(int goalsScored) {
		this.goalsScored=goalsScored;
	}

	public int getGoalsScored() {
		return goalsScored;	
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst=goalsAgainst;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setVictories(int victories) {
		this.victories=victories;
	}

	public int getVictories() {
		return victories;
	}

	public void setLoses(int loses) {
		this.loses=loses;
	}

	public int getLoses() {
		return loses; 
	}

	public void setPoints(int points) {
		this.points=points;
	}

	public int getPoints() {
		return points;
	}

	public void setDraws(int draw) {
		this.draws=draw;
	}

	public int getDraws() {
		return draws;
	}

	public void setPlayedMatches(int matchesPlayed) {
		this.matchesPlayed=matchesPlayed;
	}

	public int getPlayedMatches() {
		return matchesPlayed;
	}

	public void setTeamId(int teamId) {
		this.teamId=teamId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setRivalsList(ArrayList<Team>rivalsList) {
		this.rivalsList=rivalsList;
	}

	public ArrayList<Team>getRivalsList(){
		return rivalsList;
	}
	public void setGoalsScoredPerMatch(int goalsScoredPerMatch) {
		this.goalsScoredPerMatch=goalsScoredPerMatch;
	}
	
	public int getGoalsScoredPerMatch() {
		return goalsScoredPerMatch;		
	}

}
