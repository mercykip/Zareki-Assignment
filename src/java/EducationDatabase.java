package java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EducationDatabase {
	
	//Database connection
    public static Connection databaseConnection() {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                //Set server Time zone
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/educationn?useUnicode=true&useJDBCCompliantTimezoneShift=true&serverTimezone=UTCjdbc:mysql://localhost:3306/moneywallet?useUnicode=true&useJDBCCompliantTimezoneShift=true&serverTimezone=UTC",
                        "root",
                        "");
                System.out.println("successful connection");
                return con; }
            
            catch (ClassNotFoundException ex)  {
            	    Logger.getLogger(EducationDatabase.class.getName()).log(Level.SEVERE,null,ex);
	                ex.printStackTrace();}
            
            catch (SQLException ex) {
	                Logger.getLogger(EducationDatabase.class.getName()).log(Level.SEVERE,null,ex);
	                ex.printStackTrace();}
            return null;
         
    }
    //Creating tables
    public static void createTable() {
    	try
	    	{
    		    Connection con=databaseConnection();
	    		PreparedStatement create= con.prepareStatement(" CREATE TABLE IF NOT EXISTS institution (institutionId int(11) NOT NULL AUTO_INCREMENT,`name` varchar(250),PRIMARY KEY(institutionId))");
                                  create.executeUpdate();
	    		   		          create= con.prepareStatement(" CREATE TABLE IF NOT EXISTS course(courseId int(11) NOT NULL AUTO_INCREMENT,`name` varchar(250),PRIMARY KEY(courseId), institutionId int ,FOREIGN KEY (institutionId) REFERENCES institution(institutionId) ON DELETE CASCADE)");
	    		                  create.executeUpdate();
	    		                  create= con.prepareStatement(" CREATE TABLE IF NOT EXISTS student(studentId int(11) NOT NULL AUTO_INCREMENT,`name` varchar(250),PRIMARY KEY(studentId), courseId int ,FOREIGN KEY (courseId) REFERENCES course(courseId) ON DELETE CASCADE)");
	    						  create.executeUpdate(); 
	    		                  
	    	}
    	catch(Exception e)
	    	{
	    		System.out.println("exception"+e);
	    	}
    	//check if table has been created
    	finally {
    		System.out.println("Table created successfully");
    	}
    
    }
    //SQL Query to display students
    public static void  displayInfor() throws SQLException {
    	Connection con=databaseConnection();
    	Statement stmt = con.createStatement();
        String query ="SELECT institution.name as institutionname , course.name as coursename, count(student.id) as numberofstudent  from institution inner join course on institution.id = course.instutionid inner join student on courses.id=student.courseid";
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("institutionname coursename   numberofstudent"+rs);
    	
    } 
    public static void main(String[] args) throws Exception {
        databaseConnection();
        createTable();
     }
}
    
    
    