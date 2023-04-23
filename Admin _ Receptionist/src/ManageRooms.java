
import project.ConnectionProvider;
import project.InsertUpdateDelete;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;

public class ManageRooms extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextPane textPane;
	private JTextPane textPane_3;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_5;
	private JComboBox comboBox_2;
	private JLabel lblNewLabel_6;
	private JComboBox comboBox_3;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageRooms frame = new ManageRooms();
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
	public ManageRooms() {
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				Connection con= ConnectionProvider.getCon();
				try {
					ResultSet rs=con.prepareStatement("select *from room").executeQuery();
					System.out.println(rs);
					while(rs.next()) {
						model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
					}
					rs.close();
					con.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				};
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1076, 631);
		contentPane = new JPanel();
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Rooms");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 35));
		lblNewLabel.setIcon(new ImageIcon(ManageRooms.class.getResource("/images/manage room.png")));
		lblNewLabel.setBounds(39, 27, 394, 81);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 119, 517, 464);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Room Number", "Room Type", "Bed", "Price", "Status","Adults","Minors"
			}
		));
		table.setBackground(SystemColor.activeCaption);
		
		lblNewLabel_1 = new JLabel("Room Number");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_1.setBounds(660, 73, 150, 33);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Room Type");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_2.setBounds(660, 149, 137, 33);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Bed");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_3.setBounds(660, 226, 100, 33);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_4.setBounds(660, 469, 100, 33);
		contentPane.add(lblNewLabel_4);
		
		textPane = new JTextPane();
		textPane.setBackground(new Color(159, 159, 255));
		textPane.setBounds(660, 105, 322, 33);
		contentPane.add(textPane);
		
		textPane_3 = new JTextPane();
		textPane_3.setBackground(new Color(159, 159, 255));
		textPane_3.setBounds(660, 501, 322, 33);
		contentPane.add(textPane_3);
		
	    final JComboBox comboBox = new JComboBox();
	    comboBox.setBackground(new Color(159, 159, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AC ", "Non-AC"}));
		comboBox.setBounds(660, 182, 322, 33);
		contentPane.add(comboBox);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(159, 159, 255));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Triple"}));
		comboBox_1.setBounds(660, 263, 322, 33);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Add Room");
		btnNewButton.setBackground(new Color(159, 159, 255));
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 18));
		btnNewButton.setBounds(764, 556, 150, 38);
		contentPane.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("Adults");
		lblNewLabel_5.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_5.setBounds(660, 307, 100, 33);
		contentPane.add(lblNewLabel_5);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(159, 159, 255));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox_2.setBounds(660, 344, 322, 33);
		contentPane.add(comboBox_2);
		
		lblNewLabel_6 = new JLabel("Minors");
		lblNewLabel_6.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_6.setBounds(660, 388, 100, 33);
		contentPane.add(lblNewLabel_6);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBackground(new Color(159, 159, 255));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));
		comboBox_3.setBounds(660, 425, 322, 33);
		contentPane.add(comboBox_3);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setIcon(new ImageIcon(ManageRooms.class.getResource("/images/icons8-log-out-32.png")));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(967, 10, 47, 40);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminHome().setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ManageRooms.class.getResource("/images/view-profile-50.png")));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(892, 10, 47, 40);
		contentPane.add(btnNewButton_2);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roomNo=textPane.getText();
				String roomType=(String)comboBox.getSelectedItem();
				String bed=(String)comboBox_1.getSelectedItem();
				String Adults=(String)comboBox_2.getSelectedItem();
				String Minors=(String)comboBox_3.getSelectedItem();
				String price=(String)textPane_3.getText();
				String Query="insert into room(roomNo,roomType,bed, price,status,Adult,minor) values('"+roomNo+"','"+roomType+"','"+bed+"','"+price+"','Not_Booked','"+Adults+"','"+Minors+"')";
				InsertUpdateDelete a=new InsertUpdateDelete();
				a.setData(Query,"Room added successfully");
				
				
				setVisible(false);
				ManageRooms m= new ManageRooms();
				m.setUndecorated(true);
				m.setVisible(true);
				
			}
		});
		
	}
}
