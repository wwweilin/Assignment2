package assignment2;

import java.util.Scanner;
public class MVCAchitectureDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
				
		StudentView view = new StudentView();
		
		System.out.print("Choose 1 to insert student's mark or 2 to check student's mark:");

		int input = sc.nextInt();
		
		view.promptUser(input);
	}

}
