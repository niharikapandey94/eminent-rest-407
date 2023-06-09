package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.Dto.Student;
import java.sql.ResultSet;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class StudentDaoimpl implements StudentDao {

	public void addRegister(Student stu) throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "INSERT INTO Student (first_name, last_name, address, mobile_no, email, password) VALUES (?, ?, ?, ?, ?, ?)";;
			PreparedStatement ps = conn.prepareStatement(query);
			    ps.setString(1,stu.getFirsttName());
		        ps.setString(2,stu.getLastName());
		        ps.setString(3,stu.getAddress());
		        ps.setString(4,stu.getMobile_no());
		        ps.setString(5,stu.getsEmail());
		        ps.setString(6, stu.getsPassword());
			
			       ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to insert the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
	}
	
	
	public String loginstudent(String email, String password) throws SomethingWentWrongException, NoRecordFoundException{
		String login="Invalid Credentials";
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT * from student where email=? and password=? and is_deleted=false";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				
			throw new NoRecordFoundException("No Student found");
				
			}
			if(rs.next()) {
			login="login Suceessful";
			}
			}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to update the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
		return login;
	
	
	

}
	
	
	public void Updatepassword(Student em) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "update student set password=? where email=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, em.getsPassword());
			ps.setString(2, em.getsEmail());
			
		
			
			
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to insert the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
	}
	public void delete(Student student) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			
			conn = DBUtils.getConnectionTodatabase();
			String query = "UPDATE student SET is_deleted = true WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, student.getsEmail());
			
			
			int numRowsAffected = ps.executeUpdate();
			
			
			if (numRowsAffected == 0) {
				throw new SomethingWentWrongException("Failed to delete student with email " + student.getsEmail());
			}
		} catch (ClassNotFoundException | SQLException ex) {
			
			throw new SomethingWentWrongException("Unable to delete student. Error: " + ex.getMessage(), ex);
		} finally {
			
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

	
}
