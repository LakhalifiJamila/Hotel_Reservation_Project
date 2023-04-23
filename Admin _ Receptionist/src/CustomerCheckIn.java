

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CustomerCheckIn
{

	private JFrame frmGestionDesClients;
	private JLabel lblGestionClients;
	private JPanel panel;
	private JLabel lblName;
	private JTextField txtName;
	private JTextField txtMobile;
	private JTextField txtNationality;
	private JLabel lblCheckIn;
	private JTextField txtCheckIn;
	private JLabel lblCIN;
	private JLabel lblNationality2;
	private JLabel lblNationality3;
	private JTextField txtCIN;
	private JTextField txtNationality2;
	private JTextField txtNationality3;
	private JComboBox comboBoxGender;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_1_3;
	private JTextField txtPrice;
	private JComboBox comboBoxRoomType;
	private JComboBox comboBoxBed;
	private JComboBox comboBox_3;
	private JLabel lblHome;
	private JButton brnGenerateBill;
	private JComboBox comboBoxRoomNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					CustomerCheckIn window = new CustomerCheckIn();
					window.frmGestionDesClients.setVisible(true);
					window.frmGestionDesClients.setLocationRelativeTo(null);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerCheckIn()
	{
		initialize();
		txtCheckIn.setEditable(false); // Check-In text Field disabled
		txtPrice.setEditable(false); // Price text Field disabled
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		txtCheckIn.setText(dateFormat.format(cal.getTime()));

	}

	String bed;
	String roomType;
	String roomNo;
	String price;

	public void roomDetails()
	{
		comboBoxRoomNumber.removeAllItems();
		txtPrice.setText("");
		bed = (String) comboBoxBed.getSelectedItem();
		roomType = (String) comboBoxRoomType.getSelectedItem();

		try
		{
			// I don't know why the Select class doesn't work  video7 timeStamp: 20:30
//			ResultSet rs = Select.getData("select * from room where bed='+bed+' and roomType='+roomType+' and status='notBooked'");

		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmGestionDesClients = new JFrame();
		frmGestionDesClients.setResizable(false);
		frmGestionDesClients.setTitle("Gestion de clients\r\n");
		frmGestionDesClients.setBounds(100, 100, 957, 626);
		frmGestionDesClients.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesClients.getContentPane().setLayout(null);

		lblGestionClients = new JLabel("GESTION DE CLIENTS");
		lblGestionClients.setBounds(286, 30, 370, 54);
		lblGestionClients.setFont(new Font("Tahoma", Font.BOLD, 30));
		frmGestionDesClients.getContentPane().add(lblGestionClients);

		panel = new JPanel();
		panel.setBounds(40, 94, 863, 450);
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmGestionDesClients.getContentPane().add(panel);
		panel.setLayout(null);

		brnGenerateBill = new JButton("Generate Bill");
		brnGenerateBill.setForeground(Color.BLACK);
		brnGenerateBill.setFont(new Font("Tahoma", Font.BOLD, 14));
		brnGenerateBill.setBackground(new Color(254, 214, 114));
		brnGenerateBill.setBounds(599, 417, 155, 21);
		panel.add(brnGenerateBill);

		lblName = new JLabel("Name");
		lblName.setBounds(62, 29, 170, 30);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(62, 66, 170, 30);
		txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(txtName);
		txtName.setColumns(10);

		JLabel lblMobile = new JLabel("Mobile Number");
		lblMobile.setBounds(62, 106, 170, 30);
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblMobile);

		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(62, 183, 170, 30);
		lblNationality.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNationality);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(62, 260, 170, 30);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblGender);

		txtMobile = new JTextField();
		txtMobile.setBounds(62, 146, 170, 30);
		txtMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMobile.setColumns(10);
		panel.add(txtMobile);

		txtNationality = new JTextField();
		txtNationality.setBounds(62, 223, 170, 30);
		txtNationality.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNationality.setColumns(10);
		panel.add(txtNationality);

		lblCheckIn = new JLabel("Check In Date (Today)");
		lblCheckIn.setBounds(319, 29, 170, 30);
		lblCheckIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCheckIn);

		txtCheckIn = new JTextField();
		txtCheckIn.setBounds(319, 66, 170, 30);
		txtCheckIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCheckIn.setColumns(10);
		panel.add(txtCheckIn);

		lblCIN = new JLabel("CIN");
		lblCIN.setBounds(319, 106, 170, 30);
		lblCIN.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCIN);

		lblNationality2 = new JLabel("Nationality");
		lblNationality2.setBounds(319, 183, 170, 30);
		lblNationality2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNationality2);

		lblNationality3 = new JLabel("Nationality");
		lblNationality3.setBounds(319, 260, 170, 30);
		lblNationality3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNationality3);

		txtCIN = new JTextField();
		txtCIN.setBounds(319, 146, 170, 30);
		txtCIN.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCIN.setColumns(10);
		panel.add(txtCIN);

		txtNationality2 = new JTextField();
		txtNationality2.setBounds(319, 223, 170, 30);
		txtNationality2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNationality2.setColumns(10);
		panel.add(txtNationality2);

		txtNationality3 = new JTextField();
		txtNationality3.setBounds(319, 300, 170, 30);
		txtNationality3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNationality3.setColumns(10);
		panel.add(txtNationality3);

		comboBoxGender = new JComboBox();
		comboBoxGender.setBounds(62, 300, 170, 30);
		comboBoxGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[]
		{ "Male", "Female" }));
		panel.add(comboBoxGender);

		lblNewLabel_4 = new JLabel("Bed");
		lblNewLabel_4.setBounds(599, 29, 170, 30);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_4);

		lblNewLabel_6 = new JLabel("Room Type");
		lblNewLabel_6.setBounds(599, 106, 170, 30);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_6);

		lblNewLabel_1_3 = new JLabel("Room Number");
		lblNewLabel_1_3.setBounds(599, 183, 170, 30);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_1_3);

		lblNewLabel_1_1_3 = new JLabel("Price");
		lblNewLabel_1_1_3.setBounds(599, 260, 170, 30);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_1_1_3);

		txtPrice = new JTextField();
		txtPrice.setBounds(599, 300, 170, 30);
		txtPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPrice.setColumns(10);
		panel.add(txtPrice);

		comboBoxRoomType = new JComboBox();
		comboBoxRoomType.setBounds(599, 146, 170, 30);
		comboBoxRoomType.setModel(new DefaultComboBoxModel(new String[]
		{ "AC", "Non-Ac" }));
		comboBoxRoomType.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(comboBoxRoomType);

		comboBoxBed = new JComboBox();
		comboBoxBed.setBounds(599, 66, 170, 30);
		comboBoxBed.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxBed.setModel(new DefaultComboBoxModel(new String[]
		{ "Single", "Double", "Triple" }));
		panel.add(comboBoxBed);

		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(599, 66, 170, 30);
		panel.add(comboBox_3);

		comboBoxRoomNumber = new JComboBox();
		comboBoxRoomNumber.setBounds(599, 223, 170, 30);
		comboBoxRoomNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(comboBoxRoomNumber);

		JButton btnAllocateRoom = new JButton("Allocate Room");
		btnAllocateRoom.setBackground(new Color(254, 214, 114));
		btnAllocateRoom.setForeground(new Color(0, 0, 0));
		btnAllocateRoom.setBounds(599, 355, 155, 21);
		btnAllocateRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnAllocateRoom);

		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(254, 214, 114));
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.setBounds(599, 386, 155, 21);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnClear);

		JLabel lblAllPagesBackground = new JLabel("");
		lblAllPagesBackground.setBounds(0, 0, 863, 461);
		panel.add(lblAllPagesBackground);
		lblAllPagesBackground
				.setIcon(new ImageIcon(CustomerCheckIn.class.getResource("/images/all pages background.png")));

		lblHome = new JLabel("New label");
		lblHome.setIcon(new ImageIcon(CustomerCheckIn.class.getResource("/images/home.png")));
		lblHome.setBounds(0, 0, 943, 589);
		frmGestionDesClients.getContentPane().add(lblHome);
	}
}
