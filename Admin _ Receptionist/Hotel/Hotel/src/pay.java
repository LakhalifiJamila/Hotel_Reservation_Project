import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.ConnectionProvider;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;


import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import project.InsertUpdateDelete;
public class pay extends JFrame {

	private JPanel contentPane;
	private static String checkin;
	private static  String checkout;
	private static  String price;
	private static  String Bed;
	private static String children;
	private static String Adults;
	private static String Ac;
	private static String nR;
	private static String[] cos;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pay frame = new pay(checkin,checkout,nR,Bed,Adults,children,Ac,price,cos);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}

	/**
	 * Create the frame.
	 */
	public pay(String in,String out,String n,String b,String a,String c,String ac,String p,String[] costum) {
		
		  nR=n;
		  checkin=in;
		 checkout=out;
		 price=p;
		   Bed=b;
		  children=c;
		 Adults=a;
		Ac=ac;
		cos=new String[7];
		cos=costum;
		System.out.println(" zzzzzzzzzzzzzzzzzd "+cos[0]);
			setBounds(100, 100, 1920,1080);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			double res=0;
			 try {
		    	 DateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		    	 
		         Date dateAvant = (Date) sdformat.parse(checkin);
		         Date dateApres = (Date) sdformat.parse(checkout);
		         double diff = dateApres.getTime() - dateAvant.getTime();
		         res = (diff / (1000*60*60*24));
		         System.out.println("Nombre de jours entre les deux dates est: "+res);
		     } catch (Exception e) {
		         e.printStackTrace();
		     }
		 
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 51));
		panel_2.setBounds(-23, -29, 1368, 193);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(pay.class.getResource("/images/logo_hotel-removebg-preview.png")));
		lblNewLabel.setBounds(-28, -15, 290, 246);
		panel_2.add(lblNewLabel);
		
		final JLabel lblNewLabel_4 = new JLabel("Log Out");
		lblNewLabel_4.setIcon(new ImageIcon(pay.class.getResource("/images/icons8-user-30.png")));
		lblNewLabel_4.setForeground(new Color(135, 206, 250));
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblNewLabel_4.setBounds(1122, 35, 125, 59);
		panel_2.add(lblNewLabel_4);
		
		final JLabel lblNewLabel_1 = new JLabel("Reception");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				//new CostumerPage().setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setForeground(new Color(255,250,240));
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setForeground(new Color(135,206,250));
			}
		});
		lblNewLabel_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 29));
		lblNewLabel_1.setBounds(294, 80, 159, 39);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Rooms");
		lblNewLabel_1_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 29));
		lblNewLabel_1_1.setBounds(534, 80, 159, 39);
		panel_2.add(lblNewLabel_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(31, 175, 1219, 501);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Room Number");
		lblNewLabel_1_2.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_1_2.setBounds(58, 18, 150, 33);
		panel.add(lblNewLabel_1_2);
		
		JTextPane txtpnA_1 = new JTextPane();
		txtpnA_1.setText(n);
		txtpnA_1.setEditable(false);
		txtpnA_1.setBackground(new Color(245, 245, 245));
		txtpnA_1.setBounds(58, 50, 322, 33);
		panel.add(txtpnA_1);
		
		JLabel lblNewLabel_2 = new JLabel("Room Type");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_2.setBounds(58, 94, 137, 33);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Bed");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_3.setBounds(58, 171, 100, 33);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Adults");
		lblNewLabel_5.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_5.setBounds(58, 252, 100, 33);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Minors");
		lblNewLabel_6.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_6.setBounds(58, 333, 100, 33);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4_1 = new JLabel("Price");
		lblNewLabel_4_1.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_4_1.setBounds(58, 414, 100, 33);
		panel.add(lblNewLabel_4_1);
		
		JTextPane txtpnA_5 = new JTextPane();
		txtpnA_5.setText(p);
		txtpnA_5.setEditable(false);
		txtpnA_5.setBackground(new Color(245, 245, 245));
		txtpnA_5.setBounds(58, 446, 322, 33);
		panel.add(txtpnA_5);
		
		JTextPane txtpnA_2 = new JTextPane();
		txtpnA_2.setText(Ac);
		txtpnA_2.setEditable(false);
		txtpnA_2.setBackground(new Color(245, 245, 245));
		txtpnA_2.setBounds(58, 127, 322, 33);
		panel.add(txtpnA_2);
		
		JTextPane txtpnA_3 = new JTextPane();
		txtpnA_3.setText(a);
		txtpnA_3.setEditable(false);
		txtpnA_3.setBackground(new Color(245, 245, 245));
		txtpnA_3.setBounds(47, 296, 322, 33);
		panel.add(txtpnA_3);
		
		JTextPane txtpnA_4 = new JTextPane();
		txtpnA_4.setText(c);
		txtpnA_4.setEditable(false);
		txtpnA_4.setBackground(new Color(245, 245, 245));
		txtpnA_4.setBounds(58, 370, 322, 33);
		panel.add(txtpnA_4);
		 //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		double T=0;
		if(this.price!=null)	
			T=Double.parseDouble(this.price)*res;
		
		JTextPane txtpnA_2_1 = new JTextPane();
		txtpnA_2_1.setText(b);
		txtpnA_2_1.setEditable(false);
		txtpnA_2_1.setBackground(new Color(245, 245, 245));
		txtpnA_2_1.setBounds(47, 208, 322, 33);
		panel.add(txtpnA_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("CIN\r\n");
		lblNewLabel_1_2_2.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_1_2_2.setBounds(523, 29, 150, 33);
		panel.add(lblNewLabel_1_2_2);
		
		JTextPane txtpnA_1_1 = new JTextPane();
		txtpnA_1_1.setText(cos[0]);
		txtpnA_1_1.setEditable(false);
		txtpnA_1_1.setBackground(new Color(245, 245, 245));
		txtpnA_1_1.setBounds(523, 61, 322, 33);
		panel.add(txtpnA_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("name");
		lblNewLabel_2_1.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_2_1.setBounds(523, 105, 137, 33);
		panel.add(lblNewLabel_2_1);
		
		JTextPane txtpnA_2_2 = new JTextPane();
		txtpnA_2_2.setText(cos[1]);
		txtpnA_2_2.setEditable(false);
		txtpnA_2_2.setBackground(new Color(245, 245, 245));
		txtpnA_2_2.setBounds(523, 138, 322, 33);
		panel.add(txtpnA_2_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Last name");
		lblNewLabel_3_1.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_3_1.setBounds(523, 182, 100, 33);
		panel.add(lblNewLabel_3_1);
		
		JTextPane txtpnA_2_1_1 = new JTextPane();
		txtpnA_2_1_1.setText(cos[2]);
		txtpnA_2_1_1.setEditable(false);
		txtpnA_2_1_1.setBackground(new Color(245, 245, 245));
		txtpnA_2_1_1.setBounds(512, 219, 322, 33);
		panel.add(txtpnA_2_1_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tel");
		lblNewLabel_5_1.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_5_1.setBounds(523, 263, 100, 33);
		panel.add(lblNewLabel_5_1);
		
		JTextPane txtpnA_3_1 = new JTextPane();
		txtpnA_3_1.setText(cos[3]);
		txtpnA_3_1.setEditable(false);
		txtpnA_3_1.setBackground(new Color(245, 245, 245));
		txtpnA_3_1.setBounds(512, 307, 322, 33);
		panel.add(txtpnA_3_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Nationnality");
		lblNewLabel_6_1.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_6_1.setBounds(523, 344, 150, 33);
		panel.add(lblNewLabel_6_1);
		
		JTextPane txtpnA_4_1 = new JTextPane();
		txtpnA_4_1.setText(cos[4]);
		txtpnA_4_1.setEditable(false);
		txtpnA_4_1.setBackground(new Color(245, 245, 245));
		txtpnA_4_1.setBounds(523, 381, 322, 33);
		panel.add(txtpnA_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Gender");
		lblNewLabel_4_1_1.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_4_1_1.setBounds(523, 425, 100, 33);
		panel.add(lblNewLabel_4_1_1);
		
		JTextPane txtpnA_5_1 = new JTextPane();
		txtpnA_5_1.setText(cos[5]);
		txtpnA_5_1.setEditable(false);
		txtpnA_5_1.setBackground(new Color(245, 245, 245));
		txtpnA_5_1.setBounds(523, 457, 322, 33);
		panel.add(txtpnA_5_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Total");
		lblNewLabel_1_2_1.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_1_2_1.setBounds(917, 127, 100, 33);
		panel.add(lblNewLabel_1_2_1);
		
		JTextPane txtpnA = new JTextPane();
		txtpnA.setText("0.0");
		txtpnA.setEditable(false);
		txtpnA.setBackground(new Color(245, 245, 245));
		txtpnA.setBounds(963, 171, 148, 33);
		panel.add(txtpnA);
		
		JButton btnNewButton = new JButton("Validate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConnectionProvider();
				Connection con= ConnectionProvider.getCon();
				String QUER="Insert into costumer values('"+cos[0]+"','"+cos[1]+"','"+cos[3]+"','"+cos[4]+"','"+cos[5]+"','"+cos[6]+"')"; 
				new InsertUpdateDelete(QUER, " validation success");
				
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		btnNewButton.setBounds(1034, 381, 110, 33);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Mail");
		lblNewLabel_1_2_2_1.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_1_2_2_1.setBounds(887, 29, 150, 33);
		panel.add(lblNewLabel_1_2_2_1);
		
		JTextPane txtpnA_1_1_1 = new JTextPane();
		txtpnA_1_1_1.setEditable(false);
		txtpnA_1_1_1.setText(cos[6]);
		txtpnA_1_1_1.setBackground(new Color(245, 245, 245));
		txtpnA_1_1_1.setBounds(887, 61, 322, 33);
		panel.add(txtpnA_1_1_1);
		
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
}