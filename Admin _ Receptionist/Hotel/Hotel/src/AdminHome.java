import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import project.InsertUpdateDelete;
import project.Select;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;

public class AdminHome extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 290, 894);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AdminHome.class.getResource("/images/profile3-removebg-preview (1).png")));
		lblNewLabel_2.setBounds(-30, 10, 320, 273);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Welcome, Admin ");
		lblNewLabel.setBounds(34, 294, 234, 50);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Andalus", Font.BOLD, 30));
		
		JLabel lblNewLabel_4 = new JLabel(" View Profile");
		lblNewLabel_4.setIcon(new ImageIcon(AdminHome.class.getResource("/images/view-profile-50.png")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(46, 432, 194, 33);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Settings");
		lblNewLabel_4_1.setIcon(new ImageIcon(AdminHome.class.getResource("/images/settings.png")));
		lblNewLabel_4_1.setForeground(Color.BLACK);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(46, 510, 194, 33);
		panel.add(lblNewLabel_4_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(289, -6, 1272, 853);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton lblNewLabel_1 = new JButton("");
		lblNewLabel_1.setBounds(670, 319, 516, 240);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(AdminHome.class.getResource("/images/pieChartV2.png")));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showPieChart sp= new showPieChart();
				sp.setUndecorated(true);
				sp.setVisible(true);
				
			}
		});
		
		
		JButton lblNewLabel_1_1 = new JButton("");
		lblNewLabel_1_1.setBounds(676, 589, 516, 240);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setIcon(new ImageIcon(AdminHome.class.getResource("/images/MultipleLinesChart V2.png")));
		lblNewLabel_1_1.setBackground(new Color(0, 0, 0));
		
		textField = new JTextField();
		textField.setBounds(41, 84, 489, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setBounds(536, 81, 37, 29);
		panel_1.add(btnSearch);
		btnSearch.setIcon(new ImageIcon(AdminHome.class.getResource("/images/searchReceptionist.png")));
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EmailOrName= textField.getText();  
				ResultSet rs= Select.getData("select * from receptionists where name like '%"+ EmailOrName +"%' or email='"+ EmailOrName +"'");
				DefaultTableModel model= (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				try {	
						while(rs.next()) {
							model.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getString(6)});
								
						}
						rs.close();
				}	
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);		
				}
				
			}
		});
		btnSearch.setFont(new Font("Sylfaen", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 124, 582, 703);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setRowHeight(25);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index= table.getSelectedRow();
				TableModel model= table.getModel();
				String name= model.getValueAt(index, 0).toString();
				String email= model.getValueAt(index, 1).toString();
				String status= model.getValueAt(index, 4).toString();
				if(status.equals("true")) {
					status= "false";
				}else {
					status= "true";
				}
				try {
					int a= JOptionPane.showConfirmDialog(null, "Do you want to change status of '"+name+"' ?"); 
					if(a==0) {
						InsertUpdateDelete.setData("Update receptionists set status='"+status+"' where email='"+email+"'", "Status changed successfully.");
						setVisible(false);
						AdminHome aH= new AdminHome();
						aH.setUndecorated(true);
						aH.setVisible(true);
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] { {null, null, null,null,  null},},
			new String[] {"Name", "Email", "Security question", "Answer", "Status"}
		));
		table.setBackground(new Color(128, 128, 255));
		
		JLabel lblNewLabel_3 = new JLabel("");
		scrollPane.setColumnHeaderView(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(AdminHome.class.getResource("/images/deleteReceptionist.png")));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Employees' Number");
		lblNewLabel_2_1_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_2_1_1.setFont(new Font("Changa ExtraBold", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(957, 84, 191, 81);
		panel_1.add(lblNewLabel_2_1_1);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(128, 128, 255)));
		panel_4_1.setBounds(953, 144, 233, 151);
		panel_1.add(panel_4_1);
		
		JLabel lblNewLabel_2_2 = new JLabel();
		ResultSet rs2= Select.getData("select count(*) as employeesNumber from receptionists where status='true'");
		
		//JOptionPane.showMessageDialog(null, rs.getInt("clientNumber"));
		try {
			rs2.next();
			String employeesNumber = null;
			if(0<=rs2.getInt("employeesNumber") && rs2.getInt("employeesNumber")<10) {
				employeesNumber= "00"+rs2.getInt("employeesNumber")+"";
			}
			else if(rs2.getInt("clientNumber")>9) {
				employeesNumber= rs2.getInt("employeesNumber")+"";
			}
			lblNewLabel_2_2.setText(employeesNumber);
			
				rs2.close();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		lblNewLabel_2_2.setForeground(new Color(102, 102, 102));
		lblNewLabel_2_2.setFont(new Font("Amazigh Impact", Font.PLAIN, 56));
		lblNewLabel_2_2.setBounds(56, 35, 154, 81);
		panel_4_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Clients' Number");
		lblNewLabel_2_1_1_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_2_1_1_1.setFont(new Font("Changa ExtraBold", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1.setBounds(676, 84, 191, 81);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(128, 128, 255)));
		panel_4_1_1.setBounds(670, 143, 233, 151);
		panel_1.add(panel_4_1_1);
		
		ResultSet rs= Select.getData("select Count(*) as clientNumber from costumer where YEAR(checkIn)=YEAR(NOW())");
		JLabel lblNewLabel_2_2_1 = null;
		try {
			lblNewLabel_2_2_1 = new JLabel();
			//ATT: Basically you are positioning the cursor before the first row and then requesting data. You need to move the cursor to the first row.
			rs.next();
			//JOptionPane.showMessageDialog(null, rs.getInt("clientNumber"));
			String clientNumber = null;
			if(0<=rs.getInt("clientNumber") && rs.getInt("clientNumber")<10) {
				clientNumber= "00"+rs.getInt("clientNumber")+"";
			}
			else if(rs.getInt("clientNumber")>9) {
				clientNumber= rs.getInt("clientNumber")+"";
			}
			lblNewLabel_2_2_1.setText(clientNumber);
			rs.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		lblNewLabel_2_2_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_2_2_1.setFont(new Font("Amazigh Impact", Font.PLAIN, 56));
		lblNewLabel_2_2_1.setBounds(55, 37, 154, 81);
		panel_4_1_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Search by Name/Email");
		lblNewLabel_2_1_1_2.setForeground(new Color(102, 102, 102));
		lblNewLabel_2_1_1_2.setFont(new Font("Changa ExtraBold", Font.PLAIN, 20));
		lblNewLabel_2_1_1_2.setBounds(193, 23, 250, 81);
		panel_1.add(lblNewLabel_2_1_1_2);
		
		JButton btnLogOff_1 = new JButton("");
		btnLogOff_1.setBounds(1042, 23, 47, 40);
		panel_1.add(btnLogOff_1);
		btnLogOff_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= table.getSelectedRow();
				if(index==-1) {//no row is selected
					JOptionPane.showMessageDialog(null, "Select the receptionist to be deleted.");
					
				}
				else {
					TableModel model= table.getModel();
					String name= model.getValueAt(index, 0).toString();
					String email= model.getValueAt(index, 1).toString();
					int val= JOptionPane.showConfirmDialog(null, "Do you want really to delete '"+name+"' ?");
					if(val==0) {
						int val2= InsertUpdateDelete.setData("Delete from receptionists where email='"+email+"'", "'"+name+"' deleted successfully.");
						if(val2==1) {
							setVisible(false);
							AdminHome aH2= new AdminHome();
							aH2.setUndecorated(true);
							aH2.setVisible(true);
						}
					}
				}
				
			}
		});
		btnLogOff_1.setIcon(new ImageIcon(AdminHome.class.getResource("/images/deleteReceptionist.png")));
		btnLogOff_1.setForeground(Color.WHITE);
		btnLogOff_1.setFont(new Font("Andalus", Font.BOLD, 18));
		btnLogOff_1.setBackground(new Color(255, 255, 255));
		
		JButton btnLogOff = new JButton("");
		btnLogOff.setBounds(1188, 23, 47, 40);
		panel_1.add(btnLogOff);
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
		btnLogOff.setForeground(new Color(255, 255, 255));
		btnLogOff.setBackground(new Color(255, 255, 255));
		btnLogOff.setIcon(new ImageIcon(AdminHome.class.getResource("/images/icons8-log-out-32.png")));
		btnLogOff.setFont(new Font("Andalus", Font.BOLD, 18));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ManageRooms mr= new ManageRooms();
				mr.setUndecorated(true);
				mr.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AdminHome.class.getResource("/images/ManageRooms.png")));
		btnNewButton.setBounds(1112, 23, 47, 40);
		panel_1.add(btnNewButton);
		lblNewLabel_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MultipleLinesChart ml= new MultipleLinesChart();
				ml.setUndecorated(true);
				ml.setVisible(true);
			}
		});
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ResultSet rs= Select.getData("select * from receptionists");
				DefaultTableModel model= (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				try {
					while(rs.next()) {
						model.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getString(6)});
						
					}
					rs.close();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
	}
}