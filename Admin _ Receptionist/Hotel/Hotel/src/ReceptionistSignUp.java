
import java.awt.*;


import javax.swing.*;
import javax.swing.border.*;

import project.InsertUpdateDelete;
import java.awt.event.*;

public class ReceptionistSignUp extends JFrame {
  
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionistSignUp frame = new ReceptionistSignUp();
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
	public ReceptionistSignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a= JOptionPane.showConfirmDialog(null, "Do you want really to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(a==0)
					System.exit(0);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ReceptionistSignUp.class.getResource("/images/close.png")));
		btnNewButton_1.setBounds(958, 10, 30, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(449, 111, 158, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(232, 175, 48, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(232, 223, 65, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(232, 283, 65, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Security Question");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(232, 350, 114, 13);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(366, 175, 300, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setBounds(366, 223, 300, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setBounds(366, 279, 300, 19);
		contentPane.add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Your best friend ?", "Your hobby ?", "Your hero ?"}));
		comboBox.setToolTipText("");
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(366, 346, 300, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Answer");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(232, 412, 65, 13);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_2.setBounds(366, 406, 300, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name= textField.getText();
				String email= textField_1.getText();
				String password= passwordField.getText();
				String securityQuestion= (String)comboBox.getSelectedItem(); 
				String answer= textField_2.getText();
				if(name.isEmpty() || email.isEmpty() || password.isEmpty() || securityQuestion.isEmpty() || answer.isEmpty())
					JOptionPane.showMessageDialog(null, "All the field are required");
				else {
					String query;
					query= "Insert into receptionists values('"+name+"','"+ email+ "','"+  password+"','"+ securityQuestion+"','"+ answer+"', 'false')";
					int val= InsertUpdateDelete.setData(query, "Registred successfully");
					if(val==1) {
						setVisible(false);//designe L'OBJET DE TYPE RECEPTIONISTSIGNUP EN COURS
						Login l= new Login();
						l.setUndecorated(true);
						l.setVisible(true);
						
					}
					else if(val==0) {// if a receptionists try to register with another receptionist's email
						textField_1.setText("");
					}
				}
				
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(408, 461, 92, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Log in");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login l= new Login();
				l.setUndecorated(true);
				l.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(510, 461, 92, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		lblNewLabel_6.setIcon(new ImageIcon(ReceptionistSignUp.class.getResource("/images/signup.PNG")));
		lblNewLabel_6.setBounds(-238, -85, 1263, 800);
		contentPane.add(lblNewLabel_6);
	}
}
