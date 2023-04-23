import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseWheelListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import project.ConnectionProvider;
import project.Mycallandare;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





public class ReceptionCostumer extends JFrame {
	
	private JPanel contentPane;
	static private String CIN;
	static private String name;
	static private String lname;
	static private String Tel;
	static private String Nat;
	static private String g;
	static private String mail;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionCostumer frame = new ReceptionCostumer();
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
	
	
	
	
public static String[][] tablerooms(){
		
		new ConnectionProvider();
		Connection con= ConnectionProvider.getCon();
		
		String Query1="select * from room where status ='Booked'";
		
		ResultSet rs;
		
		try {
			
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(Query1);
			
			ResultSetMetaData metadata = rs.getMetaData();
			int numberOfColumns = metadata.getColumnCount();
			if (!rs.next()) {
				return null;
			}
			rs.beforeFirst();
			
			String[][] ResultSetArray = new String[3][numberOfColumns];
			
		
			
			int i=0;
			while (i<3) {
				rs.next();
			    for (int j = 0; j < numberOfColumns; j++) {
			        ResultSetArray[i][j] = rs.getString(j+1);
			    }
			    i++;
			}	
			rs.close();
			//rs1.close();
			con.close();
			
			
			
			return ResultSetArray;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ReceptionCostumer() {
		
		 CIN="123";
	      name=" ";
		 lname=" ";
		 Tel=" ";
		 Nat=" ";
		 g=" ";
		mail=" ";
		
		final Boolean login=true;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920,1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(-24, -33, 1319, 130);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 51));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ReceptionCostumer.class.getResource("/images/logo_hotel-removebg-preview.png")));
		lblNewLabel.setBounds(-38, -13, 290, 246);
		panel_2.add(lblNewLabel);
		
		final JLabel lblNewLabel_4 = new JLabel("Log Out");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setForeground(new Color(255,250,240));
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setForeground(new Color(135,206,250));
			}
		});
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblNewLabel_4.setForeground(new Color(135, 206, 250));
		lblNewLabel_4.setBounds(1122, 35, 125, 59);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(ReceptionCostumer.class.getResource("/images/icons8-user-30.png")));
		
		final JLabel lblNewLabel_1 = new JLabel("Reception");
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setForeground(new Color(255,250,240));
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setForeground(new Color(135,206,250));
			}
		});
		lblNewLabel_1.setBounds(417, 67, 159, 39);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 29));
		
		JPanel panel = new JPanel();
		
		final JScrollPane scrollPanel = new JScrollPane(
			    panel,
			    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
			);
		//.setBounds(x, y, width, height);
			scrollPanel.setBounds(0, 88, 1920, 700);
			panel.setBounds(0, 88, 1920, 1500);
			panel.setPreferredSize(new Dimension(1920, 1500));

		contentPane.add(scrollPanel);
		
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1313, 1043);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome To Hotel Name");
		lblNewLabel_3.setFont(new Font("Vladimir Script", Font.BOLD, 38));
		lblNewLabel_3.setBounds(220, 54, 363, 60);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-506, 0, 1809, 448);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(ReceptionCostumer.class.getResource("/imagesHotel/sasha-kaunas-xEaAoizNFV8-unsplash (1).jpg")));
		
		
		////////// to look for option//////////////////////// 
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(176, 196, 222));
		panel_3.setLayout(null);
		panel_3.setBounds(162, 517, 1021, 201);
		panel_1.add(panel_3);
		/// add callandar///////////
		final JDatePickerImpl  datePicker=new Mycallandare().acalendrier();
		////////////////
		final JDatePickerImpl  datePicker2=new Mycallandare().acalendrier();
		
		
		JPanel paneldatein = new JPanel();
		paneldatein.setBounds(47, 89, 268, 38);
		paneldatein.add(datePicker);
		datePicker.setBounds(0, 0, 400, 45);
		panel_3.add(paneldatein);
		
		
		
		JPanel paneldateout = new JPanel();
		paneldateout.setBounds(351, 89, 262, 38);
		paneldateout.add(datePicker2);
		datePicker2.setBounds(0, 0, 400, 45);
		panel_3.add(paneldateout);
		
		////////////////////
		
		
		final JComboBox Adultchoise = new JComboBox();
		Adultchoise.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		Adultchoise.setBounds(887, 85, 69, 38);
		panel_3.add(Adultchoise);
		
		final JComboBox Bedchoise = new JComboBox();
		Bedchoise.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		Bedchoise.setBounds(887, 36, 69, 38);
		panel_3.add(Bedchoise);
		
		final JComboBox Childrenchoise = new JComboBox();
		Childrenchoise.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));
		Childrenchoise.setBounds(887, 134, 69, 38);
		panel_3.add(Childrenchoise);
		
		JLabel lblNewLabel_5 = new JLabel("Bed\r\n");
		lblNewLabel_5.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblNewLabel_5.setBounds(780, 42, 106, 32);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblAdults = new JLabel("Adults :");
		lblAdults.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblAdults.setBounds(780, 89, 106, 32);
		panel_3.add(lblAdults);
		
		JLabel lblChildren = new JLabel("Children :");
		lblChildren.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblChildren.setBounds(780, 132, 106, 32);
		panel_3.add(lblChildren);
		
		final JTextPane InputPrice = new JTextPane();
		InputPrice.setText("0");
		InputPrice.setBounds(654, 89, 84, 32);
		panel_3.add(InputPrice);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblPrice.setBounds(671, 46, 53, 32);
		panel_3.add(lblPrice);
		
		JLabel lblCheckout = new JLabel("CheckOut :");
		lblCheckout.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblCheckout.setBounds(450, 46, 106, 32);
		panel_3.add(lblCheckout);
		
		JLabel lblPrice_1_1 = new JLabel("CheckIn :");
		lblPrice_1_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblPrice_1_1.setBounds(137, 46, 98, 32);
		panel_3.add(lblPrice_1_1);
		
		JButton btnNewButton = new JButton("Lets Go=>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date selectedDate = (Date) datePicker.getModel().getValue();
				Date selectedDate2 = (Date) datePicker2.getModel().getValue();
				
				if(selectedDate==null || selectedDate2==null) {
					JOptionPane.showMessageDialog(null, "*****please select date****"); 
					}else {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						DateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
						//SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
						 String in = sdformat.format(selectedDate);  
						 String out = sdformat.format(selectedDate2); 
						 double inprice =0.0;
						 try {
							
							    inprice = Double.parseDouble(InputPrice.getText());

							String a=sdformat.format(new Date());
							Date today =sdformat.parse(a);
							 Date d2 = sdformat.parse(out);
							 Date d1 = sdformat.parse(in);
							 
							
							if(d1.before(today)) {
									JOptionPane.showMessageDialog(null, "****this date is no longer usefull*****");   
										  }else if(d2.before(d1)) {
												JOptionPane.showMessageDialog(null, "*****be carefull you switched the dates****");   
										       }if(d1.equals(d2)) {
													JOptionPane.showMessageDialog(null, "****you can stay in our hospitality for at least 48h   ****");   
												  }else {
													  System.out.println(inprice);
													  if(login==true) {
														  
														 String b= (String) Bedchoise.getSelectedItem();
														 String c= (String) Childrenchoise.getSelectedItem();
														 String A= (String) Adultchoise .getSelectedItem();
														 
														 setVisible(false);
														 String[] costum=new String[7];
														 
														 costum[0]=CIN;
														 costum[1]=name;
														 costum[2]=lname;
														 costum[3]=Tel;
														 costum[4]=Nat;
														 costum[5]=g;
														 costum[6]=mail;
														 
														 RoomOptions R= new RoomOptions(in,out,inprice,b,c,A,costum);
														  R.setVisible(true);
													  }
												  }
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "*****please enter an integer for the price****");
						}
						 catch (NumberFormatException ex){
							 JOptionPane.showMessageDialog(null, "*****please enter an integer for the price****");
							 
					        }
					
					}
				
				
			}
		});
		btnNewButton.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnNewButton.setBounds(46, 149, 229, 41);
		panel_3.add(btnNewButton);
		
		/////////////////look for option end/////////////////////////////
		
		
		
		
		String[][]  R =tablerooms();
		
		//JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane = null;
		scrollPane = new JScrollPane(scrollPane);
		scrollPane.setBounds(30, 800, 1200, 363);
		panel.add(scrollPane);
		
		JPanel panel_1_1_1 = new JPanel();
		
		panel_1_1_1.setLayout(null);
		
		panel_1_1_1.setPreferredSize(new Dimension(1920, 344));
		scrollPane.setViewportView(panel_1_1_1);
		
		JPanel panel_4_1_3_1_1 = new JPanel();
		panel_4_1_3_1_1.setLayout(null);
		panel_4_1_3_1_1.setBackground(new Color(100, 149, 237));
		panel_4_1_3_1_1.setBounds(10, 11, 503, 326);
		panel_1_1_1.add(panel_4_1_3_1_1);
		
		JLabel lblNewLabel_5_3_1_1 = new JLabel("");
		lblNewLabel_5_3_1_1.setIcon(new ImageIcon(ReceptionCostumer.class.getResource("/imagesHotel/room1bed.jpg")));
		lblNewLabel_5_3_1_1.setBounds(10, 11, 312, 298);
		panel_4_1_3_1_1.add(lblNewLabel_5_3_1_1);
		
		JTextArea txtrJjjjjjjjzdjjcZdczduEeaaa_4_1_1 = new JTextArea();
		txtrJjjjjjjjzdjjcZdczduEeaaa_4_1_1.setText(R[0][2]+"bed \r\n "+R[0][5]+"adult\r\n "+R[0][6]+" children\r\n  air-conditioner :"+R[0][1]);
		txtrJjjjjjjjzdjjcZdczduEeaaa_4_1_1.setFont(new Font("MV Boli", Font.BOLD, 18));
		txtrJjjjjjjjzdjjcZdczduEeaaa_4_1_1.setEditable(false);
		txtrJjjjjjjjzdjjcZdczduEeaaa_4_1_1.setBounds(332, 41, 150, 142);
		panel_4_1_3_1_1.add(txtrJjjjjjjjzdjjcZdczduEeaaa_4_1_1);
		
		JLabel lblNewLabel_1_1_3_1_1 = new JLabel("Price/day:");
		lblNewLabel_1_1_3_1_1.setFont(new Font("Constantia", Font.BOLD, 20));
		lblNewLabel_1_1_3_1_1.setBounds(334, 209, 159, 39);
		panel_4_1_3_1_1.add(lblNewLabel_1_1_3_1_1);
		
		JTextArea txtrJjjjjjjjzdjjcZdczduEeaaa_1_3_1_1 = new JTextArea();
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_3_1_1.setFont(new Font("MV Boli", Font.BOLD, 18));
		System.out.println(R[0][3]);
		System.out.println(R[0][3]);
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_3_1_1.setText(R[0][3]);
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_3_1_1.setEditable(false);
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_3_1_1.setBounds(344, 247, 151, 39);
		panel_4_1_3_1_1.add(txtrJjjjjjjjzdjjcZdczduEeaaa_1_3_1_1);
		
		JPanel panel_4_1_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1_1.setLayout(null);
		panel_4_1_1_1_1_1.setBackground(new Color(100, 149, 237));
		panel_4_1_1_1_1_1.setBounds(548, 11, 503, 326);
		panel_1_1_1.add(panel_4_1_1_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1_1.setIcon(new ImageIcon(ReceptionCostumer.class.getResource("/imagesHotel/room1bed.jpg")));
		lblNewLabel_5_1_1_1_1.setBounds(10, 11, 312, 298);
		panel_4_1_1_1_1_1.add(lblNewLabel_5_1_1_1_1);
		
		JTextArea txtrJjjjjjjjzdjjcZdczduEeaaa_2_1_1_1 = new JTextArea();
		txtrJjjjjjjjzdjjcZdczduEeaaa_2_1_1_1.setText(R[1][2]+"bed \r\n "+R[1][5]+"adult\r\n "+R[1][6]+" children\r\n  air-conditioner :"+R[1][1]);
		txtrJjjjjjjjzdjjcZdczduEeaaa_2_1_1_1.setFont(new Font("MV Boli", Font.BOLD, 18));
		txtrJjjjjjjjzdjjcZdczduEeaaa_2_1_1_1.setEditable(false);
		txtrJjjjjjjjzdjjcZdczduEeaaa_2_1_1_1.setBounds(332, 41, 150, 142);
		panel_4_1_1_1_1_1.add(txtrJjjjjjjjzdjjcZdczduEeaaa_2_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Price/day:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Constantia", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(334, 209, 159, 39);
		panel_4_1_1_1_1_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JTextArea txtrJjjjjjjjzdjjcZdczduEeaaa_1_1_1_1_1 = new JTextArea();
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_1_1_1_1.setFont(new Font("MV Boli", Font.BOLD, 18));
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_1_1_1_1.setText(R[1][3]);
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_1_1_1_1.setEditable(false);
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_1_1_1_1.setBounds(344, 247, 151, 39);
		panel_4_1_1_1_1_1.add(txtrJjjjjjjjzdjjcZdczduEeaaa_1_1_1_1_1);
		
		JPanel panel_4_1_2_1_1_1 = new JPanel();
		panel_4_1_2_1_1_1.setLayout(null);
		panel_4_1_2_1_1_1.setBackground(new Color(100, 149, 237));
		panel_4_1_2_1_1_1.setBounds(1087, 11, 503, 326);
		panel_1_1_1.add(panel_4_1_2_1_1_1);
		
		JLabel lblNewLabel_5_2_1_1_1 = new JLabel("");
		lblNewLabel_5_2_1_1_1.setIcon(new ImageIcon(ReceptionCostumer.class.getResource("/imagesHotel/room1bed.jpg")));
		lblNewLabel_5_2_1_1_1.setBounds(10, 11, 312, 298);
		panel_4_1_2_1_1_1.add(lblNewLabel_5_2_1_1_1);
		
		JTextArea txtrJjjjjjjjzdjjcZdczduEeaaa_3_1_1_1 = new JTextArea();
		txtrJjjjjjjjzdjjcZdczduEeaaa_3_1_1_1.setText(R[2][2]+"bed \r\n "+R[2][5]+"adult\r\n "+R[2][6]+" children\r\n  air-conditioner :"+R[2][1]);
		txtrJjjjjjjjzdjjcZdczduEeaaa_3_1_1_1.setFont(new Font("MV Boli", Font.BOLD, 18));
		txtrJjjjjjjjzdjjcZdczduEeaaa_3_1_1_1.setEditable(false);
		txtrJjjjjjjjzdjjcZdczduEeaaa_3_1_1_1.setBounds(332, 41, 150, 142);
		panel_4_1_2_1_1_1.add(txtrJjjjjjjjzdjjcZdczduEeaaa_3_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Price/day:");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Constantia", Font.BOLD, 20));
		lblNewLabel_1_1_2_1_1_1.setBounds(334, 209, 159, 39);
		panel_4_1_2_1_1_1.add(lblNewLabel_1_1_2_1_1_1);
		
		JTextArea txtrJjjjjjjjzdjjcZdczduEeaaa_1_2_1_1_1 = new JTextArea();
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_2_1_1_1.setFont(new Font("MV Boli", Font.BOLD, 18));
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_2_1_1_1.setText(R[2][3]);
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_2_1_1_1.setEditable(false);
		txtrJjjjjjjjzdjjcZdczduEeaaa_1_2_1_1_1.setBounds(344, 247, 151, 39);
		panel_4_1_2_1_1_1.add(txtrJjjjjjjjzdjjcZdczduEeaaa_1_2_1_1_1);
		
		
		
		
	}
}
