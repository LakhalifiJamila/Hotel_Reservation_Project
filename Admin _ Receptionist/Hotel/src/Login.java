import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.Select;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.beans.PropertyChangeEvent;
//CETTE PAGE POUR LE LOGIN DU RECEPTIONISTE ET L'ADMIN
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton lblNewLabel_3 = new JButton("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/images/close.png")));
		lblNewLabel_3.setBounds(958, 10, 30, 30);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a= JOptionPane.showConfirmDialog(null, "Do you want really to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(a==0)//càd a cliqué yes
					System.exit(0);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(424, 219, 85, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(268, 276, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(268, 328, 71, 13);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(370, 273, 300, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(370, 325, 300, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check= 0;
				String email= textField.getText();
				String password= passwordField.getText();
				if(email.isEmpty() || password.isEmpty()) {
					check= 1;
					JOptionPane.showMessageDialog(null, "All the field are required");
				}
				else if(email.equals("admin") && password.equals("admin")) {
					check= 1;
					setVisible(false);
					AdminHome a= new AdminHome();
					a.setUndecorated(true);
					a.setVisible(true);
					
				}
				else {
					ResultSet rs= Select.getData("select * from receptionists where email='"+email+"' and password='"+password+"'");
					try {
						if(rs.next()) {//càd if(rs.next() != false), au moins a un element qui vérifie la condition mise
							check= 1;//pour verifie si cette personne existe ds la base de données sinon donc check va encore avoir la valeur 0
							if(rs.getString("status").equals("true")) {
								setVisible(false);
								new ManageRooms().setVisible(true);///???? cette page nit??
							}
							else if(rs.getString("status").equals("false")) {
								JOptionPane.showMessageDialog(null, "Please wait for Admin approval");
								
							}
						}
						if(check==0) {
							JOptionPane.showMessageDialog(null, "Incorrect Email or Password");
						}
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(268, 382, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ReceptionistSignUp r= new ReceptionistSignUp();
				r.setUndecorated(true);
				r.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(382, 382, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Forgot password");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ForgotPassword f= new ForgotPassword();
				f.setUndecorated(true);
				f.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(496, 382, 154, 21);
		contentPane.add(btnNewButton_2);
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/images/login.PNG")));
		lblNewLabel_4.setBounds(-233, -85, 1263, 800);
		contentPane.add(lblNewLabel_4);
	}
}
