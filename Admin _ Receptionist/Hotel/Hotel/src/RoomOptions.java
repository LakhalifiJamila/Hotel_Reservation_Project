import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.tools.javac.util.List;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D.Double;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.Spring;

import project.ConnectionProvider;
public class RoomOptions extends JFrame {

	private JPanel contentPane;
	
	private String checkin;
	private  String checkout;
	private  double price;
	private  String Bed;
	private String children;
	private String Adults;
	private String[] cos;
	
	public static String[][] tablerooms(String Bed,String children,String Adults){
		
		new ConnectionProvider();
		Connection con= ConnectionProvider.getCon();
		 // all rooms unbooked 234
		//String Query1="select roomNo from room where status='Not_Booked' and Bed="+Bed+" and minor= "+children+ " and Adult="+Adults;
				
		 
		
		String Query1="select * from room where status ='Booked'";
		
		ResultSet rs;
		
		try {
			
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(Query1);
			//rs1 = stmt.executeQuery(Query2);
			
			
			ResultSetMetaData metadata = rs.getMetaData();
			int numberOfColumns = metadata.getColumnCount();
			if (!rs.next()) {
				  
				return null;
			}
			rs.beforeFirst();
			rs.last();
			String[][] ResultSetArray = new String[rs.getRow()][numberOfColumns];
			
			rs.beforeFirst();
			
			int i=0;
			while (rs.next()) {

			    for (int j = 0; j < numberOfColumns; j++) {
			        ResultSetArray[i][j] = rs.getString(j+1);
			        //System.out.println( rs.getString(j+1));
			    }
			    i++;
			}	
			rs.close();
			//rs1.close();
			con.close();
			
			
			JOptionPane.showMessageDialog(null," created");
			return ResultSetArray;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
public static String[][] tablecostumrooms(String checkin,String checkout,double price,String Bed,String children,String Adults){
		
		new ConnectionProvider();
		Connection con= ConnectionProvider.getCon();
		// all rooms booaed at this date
		String Query2="select * from costumer where roomNo =12";
		//String Query2="select roomNo from costumer where checkIn >='"+checkin+"' and checkOut<='"+checkout+"' and Bed="+Bed+" and minor= "+children+" and Adult= "+Adults; 
		
		ResultSet rs;
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//rs = stmt.executeQuery("select * from room where status ='Booked'");
			rs = stmt.executeQuery(Query2);
			
			
			ResultSetMetaData metadata = rs.getMetaData();
			int numberOfColumns = metadata.getColumnCount();
			if (!rs.next()) {
				  
				return null;
			}
			rs.beforeFirst();
			rs.last();
			String[][] ResultSetArray = new String[rs.getRow()][numberOfColumns];
			
			rs.beforeFirst();
			
			int i=0;
			while (rs.next()) {

			    for (int j = 0; j < numberOfColumns; j++) {
			        ResultSetArray[i][j] = rs.getString(j+1);
			        
			    }
			    i++;
			}	
			rs.close();
			//rs1.close();
			con.close();
			
			JOptionPane.showMessageDialog(null," created");
			
			return ResultSetArray;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
public static JPanel panell(final int i,final int x,final String[][] t,final String in,final String out,final String[] cos) {
	
	  
	String p=t[i][0]+".p";
	     
				JPanel p1= new JPanel();
				p1.setName(p);
				p1.setLayout(null);
				p1.setBackground(new Color(100, 149, 237));
				p1.setBounds(38, x, 503, 326);
				
				
				String lbl=t[i][0];
				
				final JLabel lbl1 = new JLabel("");
				
				lbl1.setIcon(new ImageIcon(ReceptionCostumer.class.getResource("/imagesHotel/room1bed.jpg")));
				lbl1.setName(lbl);
				lbl1.setBounds(10, 11, 312, 298);
				p1.add(lbl1);
				lbl1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println(lbl1.getName());
						String  pr= t[i][3];
						
						new pay(in,out,t[i][0],t[i][2],t[i][5],t[i][6],t[i][1],t[i][3],cos).setVisible(true);
						
						
						
					}
				});
				
				String txtr="txtr"+i;
				JTextArea txtr1 = new JTextArea();
				txtr1.setName(txtr);
				txtr1.setText(t[i][2]+"bed \r\n "+t[i][5]+"adult\r\n "+t[i][6]+" children\r\n  air-conditioner :"+t[i][1]);
				txtr1.setFont(new Font("MV Boli", Font.BOLD, 18));
				txtr1.setEditable(false);
				txtr1.setBounds(332, 41, 155, 142);
				p1.add(txtr1);
				
				String lb="lbl1"+i;
				JLabel lbl11 = new JLabel("Price/day:");
				lbl11.setName(lb);
				lbl11.setFont(new Font("Constantia", Font.BOLD, 20));
				lbl11.setBounds(334, 209, 159, 39);
				p1.add(lbl11);
				
				String tx="txtr1"+i;
				JTextArea txtr11 = new JTextArea();
				txtr11.setName(tx);
				txtr11.setFont(new Font("MV Boli", Font.BOLD, 18));
				txtr11.setText(t[i][3]);
				txtr11.setEditable(false);
				txtr11.setBounds(344, 247, 151, 39);
				p1.add(txtr11);
			return p1;
	
}
	
	
public static Boolean minprice(double p) {
	new ConnectionProvider();
	Connection con= ConnectionProvider.getCon();
	// all rooms booaed at this date
	//String Query1="select * from room where status ='Booked'";
	String Query1="SELECT MIN(price) FROM room"; 
	ResultSet rs;
	try {
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		rs = stmt.executeQuery(Query1);
		if (rs.next()) {
			System.out.println("ggg"+rs.getDouble(1));
			if(rs.getDouble(1) > p) return false;
			else return true;
		}
		return false;
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
}
	

	/**
	 * Create the frame.  String checkin="",String checkout="",double price=0,String Bed=0,String children=0,String Adults=0
	 * 
	
	
	
	public void visiblepage() {
		try {
			RoomOptions frame = new RoomOptions(checkin,checkout,price,Bed,children, Adults);
			
			frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} */
	
	public RoomOptions(final String checkin,final String checkout,final double price,final String Bed,final String children,final String Adults,final String[] costum) {
		this.checkin=checkin;
		this.checkout= checkout;
		this.price=price;
		this.Bed=Bed;
		this.children=children;
		this.Adults=Adults;
		this.cos=new String[7];
		cos=costum;
		
		System.out.println("eeeeeee"+this.Bed);
		String[][] allrooms=new String[0][0] ;
		String[][] allreservedroomsindate=new String[0][0] ;
		
		allrooms=tablerooms(this.Bed,children,Adults);
		
		allreservedroomsindate=tablecostumrooms(checkin,checkout,price,Bed,children,Adults);
		
		int count=0;
		String[][] fMytable=null;
		
		if(allrooms == null || minprice(price)==false) {
			JOptionPane.showMessageDialog(null,"there is no option ");
			System.exit(0);
			new ReceptionCostumer().setVisible(true);
			
			
			
			new ReceptionCostumer().setVisible(true);
		} else if(allreservedroomsindate != null){
			int i=allreservedroomsindate.length;
			int j=allrooms.length;
			int col=allrooms[0].length;
			String[][] Mytable=new String[j][col] ;
			
			
			int h;
			String ll;
			for (int k=0; k<j ;k++) {
				ll=allrooms[k][0];
				for (h=0;h<i;h++) {
					if(ll.equals(allreservedroomsindate[h][0]))  {
						break;
					}
					
				}
				if(i==h) {
					count++;
					 for (int s=0; s<col ;s++) {
						 Mytable[k][s]=allrooms[k][s];
							}
					
				 }
			}
			
			// empty +t......................
			 fMytable=new String[count][col];
			
			for (int f=0; f<count ;f++) {
				for (int o=0; o<col ;o++) {
					fMytable[f][o]= Mytable[f][o];
					
						}
				
			 }
			
			System.out.println(allrooms[0][1]);
			System.out.println(allreservedroomsindate[0][0]);
		}else {
			int j=allrooms.length;
			count=j;
			int col=allrooms[0].length;
			
			for (int k=0; k<j ;k++) {
				
				for (int h=0;h<col;h++) {
					fMytable[k][h]=allrooms[k][h];
					
				         }
		            }
			}
		setBounds(100, 100, 1920,1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(-37, -12, 1368, 193);
		panel_2.setBackground(new Color(0, 0, 51));
		contentPane.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("");
		
		
		lblNewLabel.setIcon(new ImageIcon(RoomOptions.class.getResource("/images/logo_hotel-removebg-preview.png")));
		lblNewLabel.setBounds(-28, -15, 290, 246);
		panel_2.add(lblNewLabel);
		
		final JLabel lblNewLabel_4 = new JLabel("Log Out");
		lblNewLabel_4.setIcon(new ImageIcon(RoomOptions.class.getResource("/images/icons8-user-30.png")));
		lblNewLabel_4.setForeground(new Color(135, 206, 250));
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblNewLabel_4.setBounds(1122, 35, 125, 59);
		panel_2.add(lblNewLabel_4);
		
		
		final JLabel lblNewLabel_1 = new JLabel("Reception");
		lblNewLabel_1.setBounds(294, 80, 159, 39);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 29));
		
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		
		//.setBounds(x, y, width, height); 
		int myhights=(326+30)*count+5;
		final JScrollPane scrollPane = new JScrollPane(
				panel_1_1_1,
				    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
				);
		
		
		scrollPane.setBounds(86, 231, 700, 482);
		
		panel_1_1_1.setPreferredSize(new Dimension(650, myhights));
		panel_1_1_1.setBounds(86, 0, 700, myhights);
				
				
				//remplissage de panel*
		int x=30;
		
for(int i = 0 ;i<count;i++) {
	        
	         
	      panel_1_1_1.add(panell(i,x,fMytable,checkin,checkout,this.cos));
	   
	       x= x+326+30;
			
		}
		
		contentPane.add(scrollPane);
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//new ReceptionCostumer().setVisible(true);
				RoomOptions.this.setVisible(false);
			}
			private void setVisible() {
				// TODO Auto-generated method stub
				
			}
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setForeground(new Color(255,250,240));
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setForeground(new Color(135,206,250));
			}
		});
		
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new ReceptionCostumer().setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setForeground(new Color(255,250,240));
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setForeground(new Color(135,206,250));
			}
		});
		
		
		
		
						
							
						
					
			
						
				
				
		
	}


	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setBed(String bed) {
		Bed = bed;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public void setAdults(String adults) {
		Adults = adults;
	}
}