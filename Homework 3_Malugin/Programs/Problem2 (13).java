// compile: javac Problem2.java
// run: java -cp ./:/home/coursework/ConnectorJ/mariadb-java-client-2.7.3 /home/coursework/Documents/Problem2.java

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;


public class Problem2 {
  public static void main(String args[]) {

    try {
    Statement stmt; ResultSet rs;
    Class.forName("org.mariadb.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TTU", "root", "coursework");
    

    stmt = con.createStatement();
    con.setAutoCommit(false);
     
    	String insert1 = ("INSERT INTO students (tnumber, firstname, lastname, dateofbirth, credits)" + "VALUES('00003256', 'John', 'Doe', '1970-07-15', '119')");
        String insert2 = ("INSERT INTO students (tnumber, firstname, lastname, dateofbirth, credits)" + "VALUES('00001423', 'Mary', 'Smith', '1992-01-01', '15')");
        String insert3 = ("INSERT INTO students (tnumber, firstname, lastname, dateofbirth, credits)" + "VALUES('00015366', 'William', 'Williamson', '1991-05-23', '60')");
        String insert4 = ("INSERT INTO students (tnumber, firstname, lastname, dateofbirth, credits)" + "VALUES('00012345', 'Katie', 'Did', '1992-09-27', '45')");
	
	 stmt.addBatch(insert1);
	 stmt.addBatch(insert2);
         stmt.addBatch(insert3);
	 stmt.addBatch(insert4);
         stmt.executeBatch();
	  con.commit();
	System.out.printf ("%8s %11s %14s %18s %12s%n", "Tnumber", "FirstName", "LastName", "DateofBirth", "Credits");
	rs = stmt.executeQuery ("Select tnumber, firstname, lastname, DATE_FORMAT(dateofbirth, '%m/%d/%Y') as newdateofbirth, credits from students");
	
	
	while (rs.next())
  	{
	   String tnumber = rs.getString ("tnumber");
	   String firstname = rs.getString ("firstname");
	   String lastname = rs.getString ("lastname");
	   String newdateofbirth = rs.getString ("newdateofbirth");
	   int credits = rs.getInt ("credits");
	   System.out.printf ("%-10s %-15s %-15s %-17s %-17d%n", tnumber, firstname, lastname, newdateofbirth, credits);
	}  
	  	

	  
	  con.close();
} catch (Exception ex)
{   	System.out.println (ex.getMessage());
}
}
}
