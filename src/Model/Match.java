package Model;

public class Match {

	private Team team1;
	private Team team2;
	private int visitorTeamGoals;
	private int localTeamGoals;
	private String result;
	
	
	

	
	public Match(Team team1,Team team2,int localTeamGoals,int visitorTeamGoals) {
		this.team1=team1;
		this.team2=team2;
		this.visitorTeamGoals=visitorTeamGoals;
		this.localTeamGoals=localTeamGoals;
		this.result=result;
        
	}

	public Match() {
     
	}

	public void setTeam1(Team team1 ) {
		this.team1=team1;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam2(Team team2) {
		this.team2=team2;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setLocalTeamGoals(int localTeamGoals) {
		this.localTeamGoals=localTeamGoals;
	}

	public int getLocalTeamGoals() {
		return localTeamGoals;
	}

	public void setVisitorTeamGoals(int visitorTeamGoals) {
		this.visitorTeamGoals=visitorTeamGoals;
	}

	public int getVisitorTeamGoals() {
		return visitorTeamGoals;
	}
	
	public void setResult(String result) {
		this.result=result;
	}
	
	public String getResult() {
		return result;
	}

	
	




}
