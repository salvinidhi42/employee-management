package net.javaguides.employeemanagement.dao;
 // Change path based on your project


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.employeemanagement.model.Employee;

public class EmployeeDAO {
	private static final String jdbcURL = "jdbc:mysql://localhost:3306/employees?useSSL=false";
    private static final String jdbcUsername = "root";  // Change as per your DB
    private static final String jdbcPassword = "root";  // Change as per your DB

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + " (name, email, country) VALUES " + "(?, ?, ?);";

    private static final String SELECT_EMPLOYEE_BY_ID ="select id,name,email,country from employee where id =?";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set name = ?,email = ?,country = ? where id = ?;";

    protected Connection getConnection() {
    	Connection connection = null;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	return connection;
    }

    //insert employee
    public void insertEmployee(Employee employee) throws SQLException {
    	try(Connection connection = getConnection();
    			PreparedStatement prepareStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);){
    	prepareStatement.setString(1, employee.getName());
    	prepareStatement.setString(2, employee.getEmail());
    	prepareStatement.setString(3, employee.getCountry());
    	prepareStatement.executeUpdate();
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    //update employee
    public boolean updateEmployee(Employee employee) throws SQLException {
    	boolean rowUpdated;
    	try(Connection connection = getConnection();
    			PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);){
		statement.setString(1, employee.getName());
    	statement.setString(2, employee.getEmail());
    	statement.setString(3, employee.getCountry());
    	statement.setInt(4, employee.getId());

    	rowUpdated = statement.executeUpdate() > 0;
    	}
    	return rowUpdated;
    	}

    //select employee by id
    public Employee selectEmployee(int id) {
    	Employee employee = null;
    	try (Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);){
    		preparedStatement.setInt(1, id);
    		System.out.println(preparedStatement);
    		ResultSet rs= preparedStatement.executeQuery();

    		while (rs.next()) {
    			String name = rs.getString("name");
    			String email = rs.getString("email");
    			String country = rs.getString("country");
    			employee = new Employee(id, name, email, country);
    		}
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return employee;
    }

    //select employee
    public Employee selectAllEmployee(int id) {
    	List<Employee> employees = new ArrayList<>();
    	try (Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);){
    		preparedStatement.setInt(1, id);
    		System.out.println(preparedStatement);
    		ResultSet rs= preparedStatement.executeQuery();

    		while (rs.next()) {
    			String name = rs.getString("name");
    			String email = rs.getString("email");
    			String country = rs.getString("country");
    			employees.add(new Employee(id, name, email, country));
    		}
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return (Employee) employees;
    }

    //delete employee
    public boolean deleteEmployee(int id) throws SQLException {
    	boolean rowDeleted;
    	try (Connection connection = getConnection();
    			PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);){
    		statement.setInt(1, id);
    		rowDeleted = statement.executeUpdate() > 0;
         }
        return rowDeleted;
    }

	public List<Employee> selectAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

 }
