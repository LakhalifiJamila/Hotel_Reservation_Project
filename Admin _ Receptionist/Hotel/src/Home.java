

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected int JOptionPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 596);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCostumerDetails = new JButton("Costumer Details");
		btnCostumerDetails.setIcon(new ImageIcon(Home.class.getResource("/images/Customer Details Bill.png")));
		btnCostumerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CostumerDetails().setVisible(true);
			}
		});
		btnCostumerDetails.setFont(new Font("Sylfaen", Font.BOLD, 18));
		btnCostumerDetails.setBounds(403, 216, 221, 57);
		contentPane.add(btnCostumerDetails);
		
		JButton btnAddClient = new JButton("Add Client");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new AddClient().setVisible(true);
			}
		});
		
		btnAddClient.setIcon(new ImageIcon(Home.class.getResource("/images/Customer Registration & Check IN.png")));
		btnAddClient.setFont(new Font("Sylfaen", Font.BOLD, 18));
		btnAddClient.setBounds(88, 213, 188, 62);
		contentPane.add(btnAddClient);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// int n =JOptionPane.showConfirmDialog( null ,"do you wanna exit ?!","",JOptionPane.YES_NO_OPTION);

			     // if(n == JOptionPane.YES_OPTION)
			      //{
			    	  System.exit(0);
			      //}
			   
		}});
		btnLogOut.setIcon(new ImageIcon(Home.class.getResource("/images/logout.png")));
		btnLogOut.setFont(new Font("Sylfaen", Font.BOLD, 18));
		btnLogOut.setBounds(742, 30, 157, 57);
		contentPane.add(btnLogOut);
		
		JLabel lblReception = new JLabel("Reception");
		lblReception.setFont(new Font("Vivaldi", Font.BOLD, 48));
		lblReception.setBounds(62, 31, 251, 91);
		contentPane.add(lblReception);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/images/Screenshot 2022-12-13 201519.png")));
		lblNewLabel.setBounds(-23, -18, 1093, 592);
		contentPane.add(lblNewLabel);
	}

}