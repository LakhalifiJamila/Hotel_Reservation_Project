package project;

import java.sql.*;
import javax.swing.*;

public class tables {
	public static void main(String[] args) {
		Connection con= null;
		Statement st= null;
		try {
			con= ConnectionProvider.getCon();
			st= con.createStatement();
			//receptionists table
			/*
			 * st.executeUpdate("create table receptionists(name varchar(200), email varchar(200),"
			+ " password varchar(50), securityQuestion varchar(200), answer varchar(200),"
			+ " status varchar(20),  CONSTRAINT email UNIQUE (email))");
			JOptionPane.showMessageDialog(null, "receptionists table created successfully.");
			*/
			
			//room table
			
			st.executeUpdate("create table room(roomNo varchar(10), roomType varchar(200),bed varchar(200), price double ,status varchar(20))");
			JOptionPane.showMessageDialog(null, "room table created successfully.");
			
			
			//clientArchive table
			//probleme d'execution: st.executeUpdate("create table costumer(CIN varchar(10),Name varchar(20),LastName varchar(20),Tel varchar(200),Nationality varchar(20),gender varchar(20),email varchar(20),checkIn DATE,checkOut DATE,Bed varchar(20),roonNo varchar(20),roomType varchar(20),price double,Total double,status varchar(20))");
		}
		catch(Exception e) {
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, e);
		}
	}
}
