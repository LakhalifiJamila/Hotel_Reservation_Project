package project;

import java.sql.*;

import javax.swing.JOptionPane;

public class InsertUpdateDelete {
	public static int setData(String query, String msg) {
		Connection con= null;
		Statement st= null;
		int val = 0;
		try {
			con= ConnectionProvider.getCon();
			st= con.createStatement();
			val= st.executeUpdate(query);
			if(val==1 && msg.isEmpty()!= true)//if success
				JOptionPane.showMessageDialog(null, msg);
			
		}
		catch(SQLIntegrityConstraintViolationException e) {// if a receptionists try to register with another receptionist's email
			JOptionPane.showMessageDialog(null, "Email already used, Try another one");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return val;
	}
}
