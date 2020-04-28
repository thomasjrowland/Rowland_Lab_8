package labEightRowland;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LabEightRowland {

	public static void main(String[] args) {

		String[] studentNames = {"Tom", "Dick", "Harry", "Nick", "Dan", "Chelsea", "Bethany", "Kara", "Marie", "Linsdey"};
		
		int[] studentAges = {36, 26, 31, 37, 35, 31, 33, 30, 25, 40};
		
		String[] studentCities = {"Los Angeles", "New York", "Seattle", "Portland", "Phoenix", 
				"Detroit", "New Orleans", "Chicago", "Denver", "St. Louis"};
		
		Scanner scnr = new Scanner(System.in);	
		
		System.out.println("Welcome to the Student Info Center!");
				
		boolean keepGoing;
		
		do {
			System.out.println();
			
			printRoster(studentNames);
		
			System.out.println();
			int studentNumber = getStudentNumber(scnr, "Please select the student you would like more info about: ");
			
			System.out.println();
			System.out.println("You have selected " + studentNames[studentNumber -1]);
			System.out.println("Would you like to know " + studentNames[studentNumber -1] + "'s AGE or CITY?");
		
			int cityIsOneAgeisTwo = getAgeCity(scnr, "Please enter your selection: ");
		
			System.out.println();
			
			if (cityIsOneAgeisTwo == 1) {
				System.out.println(studentNames[studentNumber -1] + "'s last known city is: " + studentCities[studentNumber -1]);
			} else {
				System.out.println(studentNames[studentNumber -1] + "'s current age is: " + studentAges[studentNumber -1]);
			}
			
			System.out.println();
			keepGoing = getYesNo(scnr, "Would you like information on another student?  Y or N : ");
		
		}while (keepGoing);

		System.out.println();
		System.out.println("Goodbye! Have a nice day!");

	}
	
	static private void printRoster(String[] studentNames) {
		
		for (int i = 0; i < studentNames.length; i++) {
			if (i % 2 == 0) {
				System.out.printf("%2d : %-10s", (i+1), studentNames[i]);
			} else {
				System.out.printf("%2d : %-10s\n", (i+1), studentNames[i]);
			}
		}
	}

	public static int getStudentNumber(Scanner scnr, String prompt) {

		System.out.print(prompt);
		
		int num = 0;
		
		try {
			num = scnr.nextInt();
			scnr.nextLine();
			if (num <= 10 && num >= 1) {
				return num;
			} else {
				return getStudentNumber(scnr, prompt);
			}
		} catch (InputMismatchException e) {
			System.out.println("Ooops! Please enter a number from the student roster!");
			scnr.nextLine();
			return getStudentNumber(scnr, prompt);
		}
		
	}
	
	public static int getAgeCity(Scanner scnr, String prompt) {
		
		System.out.print(prompt);
		String input = scnr.nextLine().toLowerCase();
		boolean isValid = input.equals("age") || input.equals("city");
		
		while (!isValid) {
			System.out.print("Sorry, please type \"AGE\" or \"CITY\" : ");
			input = scnr.nextLine().toLowerCase();
			isValid = input.equals("age") || input.equals("city");
		}
		if (input.equals("city")) {
			return 1;
		} else {
			return 2;
		}
		
	}
	
	public static boolean getYesNo(Scanner scnr, String prompt) {
		
		System.out.print(prompt);
		String input = scnr.nextLine().toLowerCase();
		boolean isValid = input.equals("y") || input.equals("n");
		
		while (!isValid) {
			System.out.println("Please type Y or N");
			input = scnr.nextLine().toLowerCase();
			isValid = input.equals("y") || input.equals("n");
		}
		return input.startsWith("y");
		
	}
	
}
