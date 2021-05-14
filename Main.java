package JAC444_CameronMah_Final;
import java.util.InputMismatchException;
import java.util.Scanner;
//Cameron Mah
public class Main {

	public static void main(String[] args) {
		char selection = 'z';	//var to track user selection in menu
		Scanner input = new Scanner(System.in);
		//Menu
		while(selection != 3) {
			System.out.println("-----Menu-----");
			System.out.println("1. Compute personal income Tax");
			System.out.println("2. Print the tax tables for taxable incomes(with range)");
			System.out.println("3. Exit");
			System.out.println("Selection: ");
			selection = input.next().charAt(0);
			if(selection == '1') {	//If user selects option 1
				int selection2 = 0;
				double taxableInc = 0;
				System.out.println("0- single filer");
				System.out.println("1- married jointly or qualifying widow(er)");
				System.out.println("2- married seperately");
				System.out.println("3- head of household");
				System.out.println("Enter the filing status: ");
				//try catch block looking for invalid user input for nextInts()
				try{
					selection2 = input.nextInt();
					System.out.println("Enter the Taxable Income: ");
					taxableInc = input.nextInt();
					if(0 <= selection2 && selection2 <= 3 && taxableInc > 0) {	//If user enters in valid filing status and taxable income
						IncomeTax myPerson = new IncomeTax(selection2, taxableInc, 0, 0);
						System.out.println("Tax is: "+myPerson.getIncomeTax());
						}
					else {
						//if invalid input display error message and flush input buffer
						System.out.println("Invalid input");
						input.nextLine();
					}}
				catch (InputMismatchException e){
					//if invalid input display error message and flush input buffer
					System.out.println("Invalid input");
					input.nextLine();
				}
			}
			else if(selection == '2') {	//if user selects option 2
				double amountFrom, amountTo;
				System.out.println("Enter the amount from: ");
				try {
					amountFrom = input.nextDouble();
					System.out.println("Enter the amount to: ");
					amountTo = input.nextDouble();
					if(amountFrom > 0 && amountTo > 0 && amountTo >= amountFrom) {
					IncomeTax myPerson = new IncomeTax(0, 0, amountFrom, amountTo);
					myPerson.printTaxTables();
				}
					else {
						//if invalid input display error message and flush input buffer
						System.out.println("Invalid input");
						input.nextLine();
				}
				}catch (InputMismatchException e){
					//if invalid input display error message and flush input buffer
					System.out.println("Invalid input");
					input.nextLine();
				}
			}
			else if(selection == '3') {	//if user wants to exit
				System.out.println("Exiting Program...");
				break;
			}
			else {
				//if invalid input display error message and flush input buffer
				System.out.println("Invalid input");
				input.nextLine();
				
			}
		}
	}

}
