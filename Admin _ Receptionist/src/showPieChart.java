import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import project.ConnectionProvider;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class showPieChart extends JFrame {
	private JPanel contentPane;
	
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
				}
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
		        plot.setExplodePercent("bouked", 0.20);//librit tkhrj

		        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
		                "{0} ({2} percent)"));//percent
		        plot.setBackgroundPaint(new Color(255,255,255));
		        plot.setLabelBackgroundPaint(new Color(255,255,255));
		        

		        plot.setLegendLabelToolTipGenerator(
		                new StandardPieSectionLabelGenerator(
		                        "Tooltip for legend item {0}"));
		        plot.setSimpleLabels(true);//try false
		        plot.setInteriorGap(0.0);//ZOOM
		        
		        
		        return chart;
		      }
		 
		
		 	JPanel panel ;
		 	private JButton btnNewButton;
		 	private JButton btnNewButton_1;
		 	private JButton btnNewButton_2;
			public showPieChart() {
				panel= new JPanel();
				
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 845, 454);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				
				panel.setBackground(new Color(0, 191, 255));
				panel.setBounds(0, 0, 845, 454);
				//contentPane.add(panel);
				panel.setLayout(new BorderLayout(0, 0));
			
				
				
				
				
				JFreeChart chart = null;
				chart = createChart(createDataset());
				 panel.removeAll();
				 panel.validate();
				  contentPane.add(panel);
				  
				  ChartPanel pnl=new ChartPanel(chart);
				  pnl.setBackground(new Color(255, 255, 255));
				  panel.add(pnl, BorderLayout.CENTER);
				  pnl.setLayout(null);
				  
				  btnNewButton_2 = new JButton("");
				  btnNewButton_2.setIcon(new ImageIcon(showPieChart.class.getResource("/images/CLOSEsmall.png")));
				  btnNewButton_2.setBackground(new Color(255, 255, 255));
				  btnNewButton_2.addActionListener(new ActionListener() {
				  	public void actionPerformed(ActionEvent e) {
				  		setVisible(false);
				  	}
				  });
				  btnNewButton_2.setBounds(813, 5, 16, 16);
				  pnl.add(btnNewButton_2);
				  
				  
				  
				  
					
				  
				  
				  
				  
				///
				
				 
				
			}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showPieChart frame = new showPieChart();
					frame.setUndecorated(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
