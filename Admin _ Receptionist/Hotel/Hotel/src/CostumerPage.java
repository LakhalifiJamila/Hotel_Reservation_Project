import java.sql.*;
import project.ConnectionProvider;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import com.sun.jdi.connect.spi.Connection;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

public class CostumerPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CostumerPage frame = new CostumerPage();
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
	JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JLabel lblNewLabel_1 = new JLabel("Reception");
	private final JLabel lblNewLabel_2 = new JLabel("Wellcome");
	private final JLabel lblNewLabel_2_1 = new JLabel("Thenk you for chousing us");
	private final JLabel Costumer_name = new JLabel("New label");
	private final JButton btnBouking = new JButton("Booking Room");
	private final JPanel panel_1_1_1_1 = new JPanel();
	private final JButton btnMyPreviousReservations = new JButton("Previous reservations");
	
	public CostumerPage() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1134, 636);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//showPieChart();
		////heeeeeeeeeeeeere
	
		JFreeChart chart = null;
		chart = createChart(createDataset());
		 panel_1.setBackground(new Color(135, 206, 250));
		 panel_1.setBounds(0, 153, 267, 690);
		 
		 contentPane.add(panel_1);
		 panel_1.setLayout(null);
		 panel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		 panel.setBounds(21, 224, 219, 162);
		 panel_1.add(panel);
		 panel.setLayout(new BorderLayout(0, 0));
		 ChartPanel pnl=new ChartPanel(chart);
		 panel.removeAll();
		 panel.validate();
		 
		  panel.add(pnl, BorderLayout.CENTER);
		  panel_3.setBounds(21, 27, 219, 133);
		  panel_1.add(panel_3);
		  panel_3.setLayout(null);
		  lblNewLabel_2.setFont(new Font("Vivaldi", Font.PLAIN, 28));
		  lblNewLabel_2.setBounds(10, 28, 105, 28);
		  
		  panel_3.add(lblNewLabel_2);
		  lblNewLabel_2_1.setFont(new Font("Vivaldi", Font.BOLD, 22));
		  lblNewLabel_2_1.setBounds(10, 82, 199, 28);
		  
		  panel_3.add(lblNewLabel_2_1);
		  Costumer_name.setBounds(125, 34, 84, 26);
		  
		  panel_3.add(Costumer_name);
		  panel_2.setBackground(new Color(0, 0, 51));
		  panel_2.setBounds(0, 0, 1280, 154);
		  
		  contentPane.add(panel_2);
		  panel_2.setLayout(null);
		  
		  JLabel lblNewLabel = new JLabel("");
		  lblNewLabel.setIcon(new ImageIcon(CostumerPage.class.getResource("/images/logo_hotel-removebg-preview.png")));
		  lblNewLabel.setBounds(-41, 0, 290, 246);
		  panel_2.add(lblNewLabel);
		  panel_4.setBounds(443, 47, 284, 84);
		  panel_2.add(panel_4);
		  panel_4.setBackground(new Color(100, 149, 237));
		  panel_4.setLayout(null);
		  lblNewLabel_1.setBounds(69, 22, 159, 39);
		  lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 29));
		  
		  panel_4.add(lblNewLabel_1);
		  
		  JButton btnNewButton = new JButton("Log out");
		  btnNewButton.setIcon(new ImageIcon(CostumerPage.class.getResource("/images/logout.png")));
		  btnNewButton.setBounds(845, 59, 149, 59);
		  panel_2.add(btnNewButton);
		  btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 18));
		  btnNewButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	}
		  });
		  
		  JPanel panel_1_1 = new JPanel();
		  panel_1_1.addMouseListener(new MouseAdapter() {
		  	public void mouseClicked(MouseEvent e) {
		  		setVisible(false);
		  	}
		  });
		  panel_1_1.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		  panel_1_1.setLayout(null);
		  panel_1_1.setBackground(new Color(135, 206, 250));
		  panel_1_1.setBounds(767, 248, 315, 125);
		  contentPane.add(panel_1_1);
		  
		  JButton btnAvalableRooms = new JButton("Avalable Rooms");
		  btnAvalableRooms.setBounds(10, 23, 295, 91);
		  panel_1_1.add(btnAvalableRooms);
		  btnAvalableRooms.setBackground(new Color(30, 144, 255));
		  btnAvalableRooms.setIcon(new ImageIcon(CostumerPage.class.getResource("/images/manage room.png")));
		  btnAvalableRooms.setFont(new Font("Sylfaen", Font.BOLD, 27));
		  
		  JPanel panel_1_1_1 = new JPanel();
		  panel_1_1_1.setLayout(null);
		  panel_1_1_1.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		  panel_1_1_1.setBackground(new Color(135, 206, 250));
		  panel_1_1_1.setBounds(277, 248, 315, 125);
		  contentPane.add(panel_1_1_1);
		  btnBouking.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		setVisible(false);
		  		new CostumerDetails().setVisible(true);
		  	}
		  });
		  btnBouking.setIcon(new ImageIcon(CostumerPage.class.getResource("/images/Customer Registration & Check IN.png")));
		  btnBouking.setFont(new Font("Sylfaen", Font.BOLD, 27));
		  btnBouking.setBackground(new Color(30, 144, 255));
		  btnBouking.setBounds(10, 23, 295, 91);
		  
		  panel_1_1_1.add(btnBouking);
		  panel_1_1_1_1.setLayout(null);
		  panel_1_1_1_1.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		  panel_1_1_1_1.setBackground(new Color(135, 206, 250));
		  panel_1_1_1_1.setBounds(484, 413, 386, 143);
		  
		  contentPane.add(panel_1_1_1_1);
		  btnMyPreviousReservations.setIcon(new ImageIcon(CostumerPage.class.getResource("/images/Customer Details Bill.png")));
		  btnMyPreviousReservations.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	}
		  });
		  btnMyPreviousReservations.setFont(new Font("Sylfaen", Font.BOLD, 27));
		  btnMyPreviousReservations.setBackground(new Color(30, 144, 255));
		  btnMyPreviousReservations.setBounds(10, 34, 366, 98);
		  
		  panel_1_1_1_1.add(btnMyPreviousReservations);
		
		
		
		
		
	}
	// create data 
	 private static PieDataset createDataset() {
			java.sql.Connection con= ConnectionProvider.getCon();
			int val1 = 0;
			int val2=0;
			//Connection con= ConnectionProvider.getCon();
			try {
				ResultSet rs=con.prepareStatement("SELECT COUNT(*),status FROM `room` WHERE status='Booked'").executeQuery();
				ResultSet rs1=con.prepareStatement("SELECT COUNT(*),status FROM `room` WHERE status='Not_Booked'").executeQuery();
				
				rs.next();
				rs1.next();
				
				val1=rs.getInt(1);
				val2=rs1.getInt(1);
				rs.close();
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			};
			System.out.println(val1);
			System.out.println(val2);
			
			DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("bouked", val1);
	        dataset.setValue("not bouked", val2);
			
			
			return dataset;
			
	        
	        
	    }
	 private static JFreeChart createChart(PieDataset dataset) {
	        JFreeChart chart = ChartFactory.createPieChart(
	            "Rooms",  // chart title
	            dataset,             // dataset
	            true,                // include legend
	            true,
	            false
	        );
	        PiePlot plot = (PiePlot) chart.getPlot();
	        plot.setSectionPaint("bouked", new Color(160, 160, 255));
	        plot.setSectionPaint("not bouked",new Color(128, 128, 255 - 32));
	        plot.setNoDataMessage("No data available");
	        plot.setExplodePercent("bouked", 0.20);

	        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
	                "{0} ({2} percent)"));
	        plot.setBackgroundPaint(new Color(240,248,255));
	        plot.setLabelBackgroundPaint(new Color(240,248,255));
	        

	        plot.setLegendLabelToolTipGenerator(
	                new StandardPieSectionLabelGenerator(
	                        "Tooltip for legend item {0}"));
	        plot.setSimpleLabels(true);
	        plot.setInteriorGap(0.0);
	        
	        
	        return chart;}
	 
	
	public void showPieChart() {
		
	/*	JFreeChart chart =createChart(createDataset());
		ChartPanel pnl=new ChartPanel(chart);
		 panel.removeAll();
		 panel.validate();
		
		 panel.add(pnl, BorderLayout.CENTER);*/
	}
}