package Presenter;

import Model.Championship;
import View.View;

public class Presenter {
	private View view;
	private Championship championship;
	private int digitedOption;

	public Presenter() {
		championship=new Championship();
		view=new View();

	}

	public void runProgram() {
		do {
			view.showMessage("Bienvenido a la liga inglesa");
			view.showMessage("Elige alguna de las 2 Opciones ");
			view.showMessage("1.Juega todos Los partidos de La liga\n2.Mira el histotial de Partidos Jugados\n3.Ver la tabla de Posiciones\n4.Salir del Programa");
			digitedOption=view.readInt();
			switch(digitedOption) {
			case 1:
				callChampionshipMethods();		   	    
				break;
			case 2:
				championship.viewMatchsPlayed();
				break;
			case 3:
				CallViewPositionsTable();
				break;
			case 4:
				view.showMessage("Saliendo del Programa");
				System.exit(0);
				break;
			default:
				view.showMessage("La opcion numero"+digitedOption+" No existe,vuelve a intentarlo");

			}

		}while(digitedOption!=3);
	}


	public void callChampionshipMethods() {
		championship.createTeams();
		championship.playMatch();


	}

	public void CallViewPositionsTable() {
		championship.sortTeamsTable();
		championship.showPositionsTable();
	}



	public static void main(String[]args) {
		Presenter presenter=new Presenter();
		presenter.runProgram();
	}

}
