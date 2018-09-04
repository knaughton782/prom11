package application;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	private Scanner scanner = new Scanner(System .in);
	private List<String> options = Arrays.asList(
			"DisplayTeams", 
			"Display a Team", 
			"Create a Team", 
			"Delete a Team",
			"Create a Team Member",
			"Delete a Team Member");
	
	public void start() {
		String selection = "";
		
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			if (selection.equals("1")) {
				displayTeams();
			} else if (selection.equals("2")) {
				displayTeam();
			} else if (selection.equals("3")) {
				createTeam();
			} else if (selection.equals("4")) {
				deleteTeam();
			} else if (selection.equals("5")) {
				createMember();
			} else if (selection.equals("6")) {
				deleteMember();
			}
			
			System.out.println("Press enter to continue....");
			scanner.nextLine(); //stays at the line until the user presses enter
		} while (!selection.equals("-1"));
			
	}
	
	private void printMenu() {
		System.out.println("Select an option:\n---------------------------- ");
		for (int i = 0; i < options.size(); i++) {
			System.out.println();
		}
	}
	

}
