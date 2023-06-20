package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import View.View;
// Hacer atributos tipo lista la lista contiene los equipos rivales de cada equipo
// Para hacer el partido necesito 

public class Championship {
	private ArrayList<Team>teamsTable;
	private ArrayList<Match>matchsList;
	private View view;
	private String listAsString;
	private Random random;
	private int randomGoalsForLocalTeam;
	private int randomGoalsForRivalTeam;
	private Team arsenal;
	private Team manchesterCity;
	private Team chelsea;
	private Team manchesterUnited;


	public Championship() {
		teamsTable=new ArrayList<Team>();
		matchsList=new ArrayList<Match>();
		view=new View();
		random=new Random();
		view=new View();
		listAsString="";

	}

	public void addTeamToPositionsTable(Team team) {
		teamsTable.add(team);
	}

	public void addMatchToList(Match match) {
		matchsList.add(match);
	}



	public void showPositionsTable(){
		if(teamsTable.isEmpty()) {
			view.showMessage("La lista esta Vacia");
		}
		else {
			for(int i=0;i<teamsTable.size();i++) {

				Team currentTeam=teamsTable.get(i);
				listAsString="Posicion:"+currentTeam.getTeamId()+"Puntos: "+currentTeam.getPoints()+" Equipo: "+currentTeam.getTeamName()+" Victorias: "+currentTeam.getVictories()+" Derrotas: "+currentTeam.getLoses()+ " Goles Marcados: "+currentTeam.getGoalsScored()+" Goles Recibidos";
				view.showMessage(listAsString);
			}
		}

	}


	public void createTeams() {


		arsenal=new Team(1,"arsenal",0,0,0,0,0,0);     
		teamsTable.add(arsenal);


		manchesterUnited=new Team(2,"Manchester United",0,0,0,0,0,0);
		teamsTable.add(manchesterUnited);

		manchesterCity=new Team(3,"Manchester City",0,0,0,0,0,0);
		teamsTable.add(manchesterCity);


		chelsea=new Team(4,"chelsea",0,0,0,0,0,0);
		teamsTable.add(chelsea);

		generateTeamsRivals(arsenal);
		generateTeamsRivals(manchesterUnited);
		generateTeamsRivals(manchesterCity);
		generateTeamsRivals(chelsea);


	}



	public void generateTeamsRivals(Team team) {
		ArrayList <Team>rivalsListAux=new ArrayList<Team>();
		rivalsListAux.addAll(teamsTable);	
		removeTeam(rivalsListAux, team);
		team.setRivalsList(rivalsListAux);


	}

	// Si quiero recorrer multiples listas necesito un for para cada una de estas
	public void removeTeam(ArrayList <Team> rivalsList, Team team) {
		for(int i=0;i<rivalsList.size();i++) {
			if(rivalsList.get(i).getTeamId()==team.getTeamId()) {
				rivalsList.remove(i);
				break;
			}
		}
	}

	public void sortTeamsTable() {
		for(int x=0;x<teamsTable.size();x++) {
			for(int i=0;i<teamsTable.size()-x-1;i++) {
				if(teamsTable.get(i).getPoints()<teamsTable.get(i+1).getPoints()){
					Team auxNumber=teamsTable.get(i+1);
					teamsTable.set(i+1,teamsTable.get(i));
					teamsTable.set(i,auxNumber);
				}
			}
		}

	}


	public void generateTeamsGoals() {
		randomGoalsForLocalTeam=random.nextInt(6);	
		randomGoalsForRivalTeam=random.nextInt(6);	

	}

	public void viewMatchsPlayed() {
		for(int i=0;i<matchsList.size();i++) {
			Match currentMatch=matchsList.get(i);
			Team localTeam=currentMatch.getTeam1();
			Team rivalTeam=currentMatch.getTeam2();
			listAsString="Equipo Local: "+localTeam.getTeamName()+" Vs"+" Equipo Rival: "+rivalTeam.getTeamName()+" Resultado: "+localTeam.getGoalsScoredPerMatch()+"-"+rivalTeam.getGoalsScoredPerMatch();
			view.showMessage(listAsString);	
		}
	}


	public void playMatch() {
		for(int i=0;i<teamsTable.size();i++) {	
			Team localTeam=teamsTable.get(i);
			for (int j = 0; j <localTeam.getRivalsList().size(); j++) {
				Team rivalTeam=localTeam.getRivalsList().get(j);
				generateTeamsGoals();
				localTeam.setGoalsScored(localTeam.getGoalsScored()+randomGoalsForLocalTeam);
				localTeam.setGoalsScoredPerMatch(randomGoalsForLocalTeam);
				localTeam.setGoalsAgainst(localTeam.getGoalsAgainst()+randomGoalsForRivalTeam);
				rivalTeam.setGoalsScored(rivalTeam.getGoalsScored()+randomGoalsForRivalTeam);
				localTeam.setGoalsScoredPerMatch(randomGoalsForRivalTeam);
				rivalTeam.setGoalsAgainst(rivalTeam.getGoalsAgainst()+randomGoalsForLocalTeam);
				Match match=new Match(localTeam,rivalTeam,randomGoalsForLocalTeam,randomGoalsForRivalTeam);
				addMatchToList(match);

				if(localTeam.getGoalsScored()>rivalTeam.getGoalsScored()) {
					localTeam.setPoints(localTeam.getPoints()+3);
					localTeam.setPlayedMatches(localTeam.getPlayedMatches()+1);
					localTeam.setVictories(localTeam.getVictories()+1);
					rivalTeam.setLoses(rivalTeam.getLoses()+1);
					//localTeam.getRivalsList().remove(j);
					//rivalTeam.getRivalsList().remove(i);


				}
				else if(rivalTeam.getGoalsScored()>localTeam.getGoalsScored()) {

					rivalTeam.setPoints(rivalTeam.getPoints()+3);  
					rivalTeam.setPlayedMatches(rivalTeam.getPlayedMatches()+1);
					rivalTeam.setVictories(rivalTeam.getVictories()+1);
					localTeam.setLoses(localTeam.getLoses()+1);
					//localTeam.getRivalsList().remove(j);
					//rivalTeam.getRivalsList().remove(i);
				}
				else {
					localTeam.setPlayedMatches(localTeam.getPlayedMatches()+1);
					localTeam.setDraws(localTeam.getDraws()+1);


					rivalTeam.setPlayedMatches(rivalTeam.getPlayedMatches()+1);
					rivalTeam.setDraws(rivalTeam.getDraws()+1);

					//localTeam.getRivalsList().remove(j);                                   // eliminar por id
					//rivalTeam.getRivalsList().remove(i);

				}

			}


		}

	}












}
