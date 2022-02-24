package net.java.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.java.registration.model.Employee;

public class EmployeeDao {
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException{
		String INSERT_USERS_SQL="INSERT INTO Employee" + "(first_name, last_name, password, address, contact) VALUES  "
		+ " (?, ?, ?, ?, ?);";
		
		int result =0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Database_dbName?allowPublicKeyRetrieval=true&useSSL=False", "root","sachin123@ds");
				
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
				preparedStatement.setInt(1, 1);
				preparedStatement.setString(2, employee.getFirstName());
				preparedStatement.setString(3, employee.getLastName());
				preparedStatement.setString(4, employee.getPassword());
				preparedStatement.setString(5, employee.getAddress());
				preparedStatement.setString(6, employee.getContact());
				
				System.out.println(preparedStatement);
				
				result=preparedStatement.executeUpdate();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
						
	}

}
