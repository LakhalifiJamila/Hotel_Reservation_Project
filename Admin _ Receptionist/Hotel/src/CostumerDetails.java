import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import project.ConnectionProvider;
import project.Select;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CostumerDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CostumerDetails frame = new CostumerDetails();
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
	public CostumerDetails() {
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				Connection con= ConnectionProvider.getCon();
				try {
					LocalDate dateObj = LocalDate.now();
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			        String date = dateObj.format(formatter);
					ResultSet rs=con.prepareStatement("select *from costumer where checkIn >="+"'"+date+"'").executeQuery();
					System.out.println(rs);
					while(rs.next()) {
						model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(11),rs.getString(8),rs.getString(9),rs.getString(15),rs.getString(14)});
						System.out.println(rs.getInt(11));
					}
					rs.close();
					con.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				};
			}
		});
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientsArchive = new JLabel("Clients Archive");
		lblClientsArchive.setForeground(new Color(192, 192, 192));
		lblClientsArchive.setBackground(new Color(255, 255, 255));
		lblClientsArchive.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblClientsArchive.setBounds(61, 33, 335, 91);
		contentPane.add(lblClientsArchive);
		
		JLabel lblNewLabel_4 = new JLabel("Search by Name/CIN");
		lblNewLabel_4.setForeground(new Color(192, 192, 192));
		lblNewLabel_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_4.setBounds(359, 135, 241, 33);
		contentPane.add(lblNewLabel_4);
		
		final JTextPane textPane_3 = new JTextPane();
		textPane_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textPane_3.setBackground(new Color(245, 245, 245));
		textPane_3.setBounds(600, 135, 359, 29);
		contentPane.add(textPane_3);
		
		JButton btnSersh = new JButton("Search");
		btnSersh.setBackground(new Color(255, 255, 255));
		btnSersh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String EmailOrName= textPane_3.getText();  
					ResultSet rs= Select.getData("select * from costumer where name like '%"+ EmailOrName +"%' or email='"+ EmailOrName +"'");
					DefaultTableModel model= (DefaultTableModel)table.getModel();
					model.setRowCount(0);
					try {	
							while(rs.next()) {
								model.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17)});
									
							}
							rs.close();
					}	
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1);		
					}
					
				}
			
		});
		btnSersh.setFont(new Font("Sylfaen", Font.BOLD, 18));
		btnSersh.setBounds(969, 134, 119, 29);
		contentPane.add(btnSersh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 227, 1466, 552);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setRowHeight(25);
		//table.setBackground(new Color(128, 128, 255));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"CIN","First Name","Last Name","Phone Number","Nationality","Gender","Email","Departure Date","Arrival Date","Bed","Room Number","Room Type","Price","Total","Status","Adult","Minor"
			}
		));
		
		JButton btnLogOff = new JButton("");
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
		btnLogOff.setIcon(new ImageIcon(CostumerDetails.class.getResource("/images/icons8-log-out-32.png")));
		btnLogOff.setForeground(Color.WHITE);
		btnLogOff.setFont(new Font("Andalus", Font.BOLD, 18));
		btnLogOff.setBackground(Color.WHITE);
		btnLogOff.setBounds(1461, 10, 47, 40);
		contentPane.add(btnLogOff);
		
		JButton btnLogOff_1 = new JButton("");
		btnLogOff_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CustomerRegistration cr= new CustomerRegistration();
				cr.setVisible(true);
			}
		});
		btnLogOff_1.setIcon(new ImageIcon(CostumerDetails.class.getResource("/images/RESERVE.png")));
		btnLogOff_1.setForeground(Color.WHITE);
		btnLogOff_1.setFont(new Font("Andalus", Font.BOLD, 18));
		btnLogOff_1.setBackground(Color.WHITE);
		btnLogOff_1.setBounds(1376, 10, 47, 40);
		contentPane.add(btnLogOff_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CostumerDetails.class.getResource("/images/BACKGROUND.jpg")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel);
		
		
		
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ResultSet rs= Select.getData("select * from costumer");
				DefaultTableModel model= (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				try {
					while(rs.next()) {
						model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17)});
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
