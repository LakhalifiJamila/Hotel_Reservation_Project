import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.InsertUpdateDelete;
import project.Select;

import java.awt.*;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import java.awt.Color;

public class ClientForgotPassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientForgotPassword frame = new ClientForgotPassword();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientForgotPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reset account password");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(387, 73, 307, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter a new password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(458, 112, 171, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton lblNewLabel_2 = new JButton("");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setIcon(new ImageIcon(ClientForgotPassword.class.getResource("/images/close.png")));
		lblNewLabel_2.setBounds(935, 10, 30, 30);
		lblNewLabel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a= JOptionPane.showConfirmDialog(null, "Do you want really to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(a==0)
					System.exit(0);
			}
		});
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(214, 200, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_6 = new JLabel("New password");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(208, 251, 118, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Confirm password");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(208, 312, 130, 13);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(418, 198, 300, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Reset password");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(413, 377, 148, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String email= textField.getText();
				String newPassword= passwordField.getText();
				String confirmPassword= passwordField_1.getText();
				
				try {
					if(email.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, "All fields are required");
					}
					else {
						if(newPassword.equals(confirmPassword)) {
							ResultSet rs= Select.getData("select * from clientCredentials where email='"+email+"'");
							try {
								if(rs.next()) {
									
									InsertUpdateDelete.setData("update clientCredentials set password='"+newPassword+"' where email='"+email+"'", "Password successfully changed");
									setVisible(false);
									ClientLogIn l= new ClientLogIn();
									l.setUndecorated(true);
									l.setVisible(true);
									
								}
								else {
									JOptionPane.showMessageDialog(null, "Incorrect Email");
								}
							}
							catch(Exception e1) {
								JOptionPane.showMessageDialog(null, e1);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Password and Confirm Password don't mach");
							passwordField.setText("");
							passwordField_1.setText("");
						}
					}
				}
				catch(NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Enter your Email first.");
				}	
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(ClientForgotPassword.class.getResource("/images/golden-key-removebg-preview (1).png")));
		lblNewLabel_9.setBounds(281, 51, 100, 100);
		contentPane.add(lblNewLabel_9);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(415, 249, 300, 19);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(415, 310, 300, 19);
		contentPane.add(passwordField_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ClientLogIn l= new ClientLogIn();
				l.setUndecorated(true);
				l.setVisible(true);
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(577, 377, 148, 21);
		contentPane.add(btnCancel);
	}
}
