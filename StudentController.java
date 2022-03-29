package assignment2;

import java.sql.*; 

public class StudentController {
	
	//Variable declaration
	private Student model;
	private StudentView view;
	
	//Constructor
	public StudentController(Student model, StudentView view){
		this.model = model;
		this.view = view;
	}
	
	//Read data from database
	public void getStudentData(String ID) throws SQLException{       
		
		//create a Student object
		Student student = new Student();
		
		// Connect to database
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root","Woo0762@");
		
		// create a Statement from the connection
		Statement statement = conn.createStatement();
		
		// Retrieve results from the table
		ResultSet rs = statement.executeQuery ("Select * from db1.properties where id = '" + ID + "'"); 
		
		
		if (rs.next()) {
				student.setID(rs.getString("ID"));
				student.setName(rs.getString("Name"));
				student.setMathMark(rs.getInt("MathMark"));
				student.setScienceMark(rs.getInt("ScienceMark"));
				
		    } 
		 // pass the data to view object and display
		view.printStudentMarks(student.getID(), student.getName(), student.getMathMark(), student.getScienceMark());
	}
	
	
	//Save data to database
	public void inputStudentData(String id, String name,  int mathMark, int scienceMark) throws SQLException {
		
		Student student = new Student();
			
		// Connect to database
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root","Woo0762@");
		
		// create a Statement from the connection
		Statement statement = conn.createStatement();
		
		// insert the data into database
		statement.executeUpdate("INSERT INTO properties VALUES ('" + id + "', '"+ name + "', " +
		+ mathMark + ", " + scienceMark + ")");
		
		System.out.println("Student data is saved.");
	}
}