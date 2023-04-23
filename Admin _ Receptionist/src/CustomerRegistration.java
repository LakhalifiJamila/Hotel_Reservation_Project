import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.orsoncharts.util.json.parser.ParseException;

import project.InsertUpdateDelete;
import project.Select;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;

public class CustomerRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_15;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRegistration frame = new CustomerRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String cin;
	String firstName;
	String gender;
	String phoneNumber;
	String email;
	String lastName;
	String nationality;
	String bedType;
	String roomType;
	String adultNum;
	String childrenNum;
	int roomNo;
	double price;
	double total;
	
	java.sql.Date dateArrival;
	java.sql.Date dateGo;
	
	private JPanel panel;
	private JPanel panel_1;
	private JButton BTN_1;
	private JButton BTN_2;
	private JButton btnNewButton;
	private JButton btnLogOff;
	private JButton btnLogOff_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	public void roomNumber() {
		comboBox_5.removeAllItems();
		lblNewLabel_4.setText("");
		lblNewLabel_3.setText("");
		bedType= (String)comboBox_4.getSelectedItem();
		roomType= (String)comboBox_3.getSelectedItem();
		adultNum= (String)comboBox_1.getSelectedItem();
		childrenNum= (String)comboBox_2.getSelectedItem();
		String textArrival = textField_7.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date arrival = null;

		try {
			arrival = sdf.parse(textArrival);
		} catch (Exception pe) {
		    // deal with ParseException
		}
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date dateArrival = java.sql.Date.valueOf(sdf.format(arrival));
		
		//date de go
		String textGo = textField_15.getText();
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date go = null;

		try {
			go = sdf.parse(textGo);
		} catch (Exception pe) {
		    // deal with ParseException
		}
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		dateGo = java.sql.Date.valueOf(sdf.format(arrival));
		
		try {
			ResultSet rs= Select.getData("select roomNo from room where roomNo not In(select roomNo from costumer where checkOut>'"+dateArrival+"'");
			while(rs.next()) {
				comboBox_5.addItem(rs.getInt(1));
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public CustomerRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCheckIn = new JLabel("Arrival date");
		lblCheckIn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCheckIn.setBounds(50, 264, 135, 25);
		contentPane.add(lblCheckIn);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_7.setBackground(new Color(255, 255, 255));
		textField_7.setColumns(10);
		textField_7.setBounds(50, 299, 300, 35);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Children");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7_1.setBounds(409, 432, 101, 25);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Adult");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6_1.setBounds(50, 430, 101, 25);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Type");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(50, 346, 136, 25);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblBed = new JLabel("Bed");
		lblBed.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBed.setBounds(409, 350, 101, 25);
		contentPane.add(lblBed);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_15.setBackground(new Color(255, 255, 255));
		textField_15.setColumns(10);
		textField_15.setBounds(405, 301, 300, 35);
		contentPane.add(textField_15);
		
		JLabel lblNewLabel_4_1 = new JLabel("Departure date");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(411, 267, 174, 25);
		contentPane.add(lblNewLabel_4_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox_1.setBounds(50, 469, 300, 35);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_2.setBackground(new Color(255, 255, 255));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		comboBox_2.setBounds(409, 471, 300, 35);
		contentPane.add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_3.setBackground(new Color(255, 255, 255));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"AC ", "Non-AC"}));
		comboBox_3.setBounds(50, 385, 300, 35);
		contentPane.add(comboBox_3);
		
		lblNewLabel_1 = new JLabel("Customer Registration");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(192, 192, 192));
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(52, 24, 555, 64);
		contentPane.add(lblNewLabel_1);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_4.setBackground(new Color(255, 255, 255));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Single ", "Double"}));
		comboBox_4.setBounds(409, 385, 300, 35);
		contentPane.add(comboBox_4);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_5.setBackground(new Color(255, 255, 255));
		comboBox_5.setBounds(50, 574, 300, 35);

		contentPane.add(comboBox_5);
		
		panel = new JPanel();
		panel.setBounds(19, 157, 737, 564);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton BTN= new JButton();
		BTN.setIcon(new ImageIcon(CustomerRegistration.class.getResource("/images/SEARCH2.png")));
		BTN.setBounds(33, 379, 24, 24);
		panel.add(BTN);
		BTN.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3_1 = new JLabel("Price");
		lblNewLabel_3_1.setBounds(417, 378, 101, 25);
		panel.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		//textField_11.setColumns(10);
		/*JButton BTN2= new JButton();
		panel.add(BTN2);
		panel.setBounds(0,0,30,30)
		textField_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomNo=(int) comboBox_5.getSelectedItem();
				try {
					ResultSet rs= Select.getData("select price from room where roomNo='"+roomNo+"'");
					rs.next();
					textField_11.setText(""+rs.getDouble("price"));
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
		});
		*/
		JLabel lblNewLabel_1_1 = new JLabel("N° Room");
		lblNewLabel_1_1.setBounds(59, 379, 101, 25);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(387, 417, 300, 35);
		panel.add(lblNewLabel_3);
		
		BTN_1 = new JButton();
		BTN_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomNo=(int) comboBox_5.getSelectedItem();
				try {
					ResultSet rs= Select.getData("select price from room where roomNo='"+roomNo+"'");
					rs.next();
					price= rs.getDouble("price");
					lblNewLabel_3.setText(""+price);
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		BTN_1.setIcon(new ImageIcon(CustomerRegistration.class.getResource("/images/SEARCH2.png")));
		BTN_1.setBackground(Color.WHITE);
		BTN_1.setBounds(389, 378, 24, 24);
		panel.add(BTN_1);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(793, 157, 705, 564);
		contentPane.add(panel_1);
		
		JLabel lblCin = new JLabel("CIN");
		lblCin.setBounds(45, 110, 101, 25);
		panel_1.add(lblCin);
		lblCin.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_4.setBackground(new Color(255, 255, 255));
		textField_4.setBounds(45, 145, 300, 30);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(377, 110, 101, 25);
		panel_1.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_6.setBounds(377, 145, 300, 35);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(379, 192, 126, 25);
		panel_1.add(lblLastName);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setBounds(379, 227, 300, 35);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(45, 194, 144, 25);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(45, 229, 300, 35);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(45, 287, 101, 25);
		panel_1.add(lblGender);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(45, 322, 300, 35);
		panel_1.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male ", "Female"}));
		
		JLabel lblNtionality = new JLabel("Ntionality");
		lblNtionality.setBounds(382, 287, 101, 25);
		panel_1.add(lblNtionality);
		lblNtionality.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_3.setBounds(379, 322, 300, 35);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Total");
		lblNewLabel_5_1.setBounds(411, 376, 101, 25);
		panel_1.add(lblNewLabel_5_1);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		
		JLabel lblPoneNumber = new JLabel("Phone Number");
		lblPoneNumber.setBounds(46, 376, 195, 25);
		panel_1.add(lblPoneNumber);
		lblPoneNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setBounds(46, 411, 300, 35);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		BTN_2 = new JButton();
		BTN_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // format jour / mois / année
				LocalDate date1 = LocalDate.parse(textField_7.getText(), format);
				LocalDate date2 = LocalDate.parse(textField_15.getText(), format);
				
				Period period = Period.between(date1, date2);
				 
				//JOptionPane.showMessageDialog(null, price*period.getDays());
				total= price*period.getDays();
				lblNewLabel_4.setText(""+total);
			}
		});
		BTN_2.setIcon(new ImageIcon(CustomerRegistration.class.getResource("/images/SEARCH2.png")));
		BTN_2.setBackground(Color.WHITE);
		BTN_2.setBounds(377, 376, 24, 24);
		panel_1.add(BTN_2);
		
		btnNewButton = new JButton("Reserve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cin= textField_4.getText();
				firstName= textField.getText();
				gender= (String)comboBox.getSelectedItem();
				phoneNumber= textField_2.getText();
				email= textField_6.getText();
				lastName= textField_1.getText();
				nationality= textField_3.getText();
				//JOptionPane.showMessageDialog(null, "dateGo: "+dateGo);
				int val=InsertUpdateDelete.setData("insert into costumer(CIN,Name,LastName,Tel,Nationality,gender,email,checkIn,checkOut,Bed,roomNo,roomType,price,Total,status,Adult,minor) values('"+cin+"','"+firstName+"','"+lastName+"','"+phoneNumber+"','"+nationality+"','"+gender+"','"+email+"','"+dateArrival+"','"+dateGo+"','"+bedType+"','"+roomNo+"','"+roomType+"','"+price+"','"+total+"','Booked','"+adultNum+"','"+childrenNum+"')", "Mr/Mme "+firstName+" "+lastName+" reserved successfully");
				if(val==1) {
					textField.setText("");
					textField_1.setText("");
					textField_6.setText("");
					textField_4.setText("");
					textField_15.setText("");
					lblNewLabel_4.setText("");
					textField_7.setText("");
					textField_3.setText("");
					lblNewLabel_3.setText("");
					textField_2.setText("");
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(304, 498, 126, 40);
		panel_1.add(btnNewButton);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(377, 411, 300, 35);
		panel_1.add(lblNewLabel_4);
		
		btnLogOff = new JButton("");
		btnLogOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int val= JOptionPane.showConfirmDialog(null, "Do you want really logout ?");
				if(val==0) {
					setVisible(false);
					Login l= new Login();
					l.setUndecorated(true);
					l.setVisible(true);
				}
			}
		});
		btnLogOff.setIcon(new ImageIcon(CustomerRegistration.class.getResource("/images/icons8-log-out-32.png")));
		btnLogOff.setForeground(Color.WHITE);
		btnLogOff.setFont(new Font("Andalus", Font.BOLD, 18));
		btnLogOff.setBackground(Color.WHITE);
		btnLogOff.setBounds(1457, 10, 47, 40);
		contentPane.add(btnLogOff);
		
		btnLogOff_1 = new JButton("");
		btnLogOff_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CostumerDetails cd= new CostumerDetails();
				cd.setVisible(true);
			}
		});
		btnLogOff_1.setIcon(new ImageIcon(CustomerRegistration.class.getResource("/images/eye.png")));
		btnLogOff_1.setForeground(Color.WHITE);
		btnLogOff_1.setFont(new Font("Andalus", Font.BOLD, 18));
		btnLogOff_1.setBackground(Color.WHITE);
		btnLogOff_1.setBounds(1376, 10, 47, 40);
		contentPane.add(btnLogOff_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(CustomerRegistration.class.getResource("/images/BACKGROUND.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel_2);
		BTN.addActionListener(new ActionListener() {
			////
			public void actionPerformed(ActionEvent e) {
				
				comboBox_5.removeAllItems();
				lblNewLabel_3.setText("");
				lblNewLabel_4.setText("");
				bedType= (String)comboBox_4.getSelectedItem();
				roomType= (String)comboBox_3.getSelectedItem();
				adultNum= (String)comboBox_1.getSelectedItem();
				childrenNum= (String)comboBox_2.getSelectedItem();
				String textArrival = textField_7.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date arrival = null;

				try {
					arrival = sdf.parse(textArrival);
					//JOptionPane.showMessageDialog(null, "arrival"+arrival);
				} catch (Exception pe) {
				    // deal with ParseException
				}
				
				dateArrival = java.sql.Date.valueOf(sdf.format(arrival));
				//JOptionPane.showMessageDialog(null, "dateArrival: "+dateArrival);
				
				//date de go
				String textGo = textField_15.getText();
				//JOptionPane.showMessageDialog(null, textGo);
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date go = null;

				try {
					go = sdf.parse(textGo);
				} catch (Exception e1) {
				    JOptionPane.showMessageDialog(null, e1);
				}
				
				dateGo = java.sql.Date.valueOf(sdf.format(go));
				
				try {//REQUETE PROBLEM
					ResultSet rs= Select.getData("select roomNo from room WHERE bed='"+bedType+"' and roomType='"+roomType+"' and Adult='"+adultNum+"' and minor='"+childrenNum+"' EXCEPT select roomNo from costumer where checkOut>'"+dateArrival+"' and bed='"+bedType+"' and roomType='"+roomType+"' and Adult='"+adultNum+"' and minor='"+childrenNum+"'");
					//JOptionPane.showMessageDialog(null, "nothing");
					while(rs.next()) {
						//JOptionPane.showMessageDialog(null, rs.getInt("roomNo"));
						comboBox_5.addItem(rs.getInt("roomNo"));
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
			////
		});
	}
}
