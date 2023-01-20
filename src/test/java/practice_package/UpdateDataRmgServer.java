package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataRmgServer {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		int result=0;


		Driver driver=new Driver();



		//step1: Register the database
		DriverManager.registerDriver(driver);

		//step2: get connection for the database
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");

		//step3: Issue Create Statement
		Statement state = con.createStatement();

		String query = "insert into project values('TY_Project_48','SCM','21/12/2022','Freddy Ginwala','ongoing',5);";

		//step4: Update Query
		result = state.executeUpdate(query);

		if(result==1)
		{
			System.out.println("data updated");
		}
		else
		{
			System.out.println("data not updated");
		}
		con.close();
	}
}

