
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.InsertUpdateDelete;

import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ClientSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientSignUp frame = new ClientSignUp();
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
	public ClientSignUp() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 476, 638);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ClientSignUp.class.getResource("/images/clientSignUp.jpg")));
		lblNewLabel_2.setBounds(0, -88, 492, 766);
		panel.add(lblNewLabel_2);
		
		/*JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ClientSignUp.class.getResource("/images/indian-hotels (2).jpg")));
		lblNewLabel_2.setBounds(-379, 0, 917, 628);
		panel.add(lblNewLabel_2);*/
		
		Button button = new Button("SignUp");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name= textField.getText();
				String email= textField_1.getText();
				String password= passwordField.getText();
				String confirmPassword= passwordField_1.getText();
				if(name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty())
					JOptionPane.showMessageDialog(null, "All the field are required");
				
				else if(password.equals(confirmPassword)){
					String query;
					query= "Insert into clientCredentials values('"+name+"','"+ email+ "','"+  password+"')";
					int val= InsertUpdateDelete.setData(query, "Registred successfully");
					if(val==1) {
						setVisible(false);//designe L'OBJET DE TYPE RECEPTIONISTSIGNUP EN COURS
						Login l= new Login();
						l.setUndecorated(true);
						l.setVisible(true);
						
					}
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Password and Confirm Password are not the same");
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(520, 535, 177, 50);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(520, 101, 393, 61);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(520, 57, 103, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(520, 177, 103, 23);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(520, 215, 393, 61);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(520, 299, 103, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Confirm Password");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(520, 414, 166, 23);
		contentPane.add(lblNewLabel_1_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(520, 333, 393, 61);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField_1.setBounds(520, 447, 393, 61);
		contentPane.add(passwordField_1);
		
		Button button_1 = new Button("Login");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ClientLogIn cli= new ClientLogIn();
				cli.setUndecorated(true);
				cli.setVisible(true);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(736, 535, 177, 50);
		contentPane.add(button_1);
	}
}
