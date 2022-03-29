package assignment2;

//View:
//Receive input data from user and send it to controller to save it on the database.
//Receive student id from user and send it to controller to get the data from database.

import java.sql.SQLException;
import java.util.Scanner;

public class StudentView {
	
	public void promptUser(int option) {
		Student student = new Student();
		
		StudentController controller = new StudentController(student, this);
		Scanner sc = new Scanner(System.in);
		
		if (option == 1) {
			try {
				System.out.println("\nPlease enter student details: ");
				System.out.print("Student ID: ");
				String ID = sc.next();
				
				System.out.print("Student Name: ");
				String name = sc.next();
				
				System.out.print("Math Mark: ");
				int mathMark = sc.nextInt();
				
				System.out.print("Science Mark: ");
				int scienceMark = sc.nextInt();
				
				controller.inputStudentData(ID, name, mathMark, scienceMark);
			
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		if (option == 2) {
			System.out.print("\nEnter student id: " );
			String ID = sc.next();
			
			try {
				controller.getStudentData(ID);
				
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
			
		}			
	}
	public void printStudentMarks(String ID, String name, int mathMark, int scienceMark) {
		System.out.println("Student ID: " + ID);
		System.out.println("Student Name: " + name);
		System.out.println("Math Mark: " + mathMark);
		System.out.println("Science Math: " + scienceMark);
	}

}
