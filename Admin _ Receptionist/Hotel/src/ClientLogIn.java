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
public class ClientLogIn extends JFrame {

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
					ClientLogIn frame = new ClientLogIn();
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
	public ClientLogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton lblNewLabel_3 = new JButton("");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setIcon(new ImageIcon(ClientLogIn.class.getResource("/images/close.png")));
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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(441, 183, 167, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(242, 270, 74, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(242, 332, 92, 13);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(370, 273, 300, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(370, 326, 300, 19);
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
				else {
					ResultSet rs= Select.getData("select * from clientCredentials where email='"+email+"' and password='"+password+"'");
					try {
						if(rs.next()) {//càd if(rs.next() != false), au moins a un element qui vérifie la condition mise
							check= 1;
								setVisible(false);
								//new CostumerPage().setVisible(true);HNAAA
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
		btnNewButton.setBounds(334, 384, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ClientSignUp r= new ClientSignUp();
				r.setUndecorated(true);
				r.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(448, 384, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Forgot password");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ClientForgotPassword f= new ClientForgotPassword();
				f.setUndecorated(true);
				f.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(562, 384, 154, 21);
		contentPane.add(btnNewButton_2);
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(-48, -59, 1263, 800);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(ClientLogIn.class.getResource("/images/CLIENTLOGIN.jpg")));
	}
}
