import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.mysql.cj.xdevapi.Statement;

import project.ConnectionProvider;
import project.Select;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MultipleLinesChart extends JFrame { // the class extends the JFrame class

	public MultipleLinesChart() {   // the constructor will contain the panel of a certain size and the close operations 
	    super("Money by kind of room booked this year."); // calls the super class constructor
	    
	    JPanel chartPanel = createChartPanel();       
	    getContentPane().add(chartPanel, BorderLayout.CENTER);
	    chartPanel.setLayout(null);
	    
	    JButton btnNewButton = new JButton("");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		setVisible(false);
	    	}
	    });
	    btnNewButton.setIcon(new ImageIcon(MultipleLinesChart.class.getResource("/images/CLOSEsmall.png")));
	    btnNewButton.setBounds(813, 5, 16, 16);
	    chartPanel.add(btnNewButton);
	    
	    setSize(845, 454);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	}
	
	private JPanel createChartPanel() { // this method will create the chart panel containin the graph 
	    String chartTitle = "Profit by Room Type in Each Month for this Year";
	    String xAxisLabel = "Months";
	    String yAxisLabel = "Money";
	    
	    XYDataset dataset = createDataset();
	    
	    JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, 
	            xAxisLabel, yAxisLabel, dataset);
	
	    customizeChart(chart);
	    
	    // saves the chart as an image files
	    File imageFile = new File("XYLineChart.png");
	    int width = 700;
	    int height = 700;
	    
	    try {
	        ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
	    } catch (IOException ex) {
	        System.err.println(ex);
	    }
	    
	    return new ChartPanel(chart);
	}
	
	private XYDataset createDataset() {    // this method creates the data as time seris 
		String type1= "Single AC";
		String type2= "Single Non-AC";
		String type3= "Double AC";
		String type4= "Double Non-AC";
		
		
		XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries(type1);
	    XYSeries series2 = new XYSeries(type2);
	    XYSeries series3 = new XYSeries(type3);
	    XYSeries series4 = new XYSeries(type4);
	    
		
		////
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				//FOR THE CURRENT YEAR
				//series1
				ResultSet Arrival= Select.getData("select * from costumer where Bed='Single' and RoomType='AC' and YEAR(checkIn)=YEAR(NOW())");
				Date date;
				double[][] monthTotal;
				monthTotal= new double[100][2];//100 APPROXIMATION DE MAX,ça n'est pas un tab dynamique en java, il est considéré statique
				double money=0;
				int i= 0;
				try {
					while(Arrival.next()) {						
						date= Arrival.getDate("checkIn");
						monthTotal[i][0]= (date.getMonth())+1;
						//JOptionPane.showMessageDialog(null, monthTotal[i][0]);
						monthTotal[i][1]= Arrival.getDouble("Total");
						//JOptionPane.showMessageDialog(null, monthTotal[i][1]);
						i++;
					}
					int uniqueValue= 0;
					int tailleTab= i;
					//JOptionPane.showMessageDialog(null, tailleTab);
					int month;
					for(int j=0; j<tailleTab; j++) {
						for(int k=0; k<tailleTab; k++) {
							//J REPRESENTE INDICE DE MONTH
							if(monthTotal[j][0]==monthTotal[k][0]  && k!=j) {//comparaison avec toutes les valeurs du tableau sauf la valeur avec elle même
								money+= monthTotal[j][1]+monthTotal[k][1];
								uniqueValue++;
							}
						}
						if(uniqueValue==0) {
							money= monthTotal[j][1];
							month= (int) monthTotal[j][0];
							//JOptionPane.showMessageDialog(null, "heeere"+money);
							series1.add(month, money);
						}else {
							month= (int) monthTotal[j][0];
							series1.add(month, money);
						}
						uniqueValue= 0;
						money= 0;
					}
					
					Arrival.close();
				
					//series2
					ResultSet Arrival2= Select.getData("select * from costumer where Bed='Single' and RoomType='Non-AC' and YEAR(checkIn)=YEAR(NOW())");
					Date date2;
					double[][] monthTotal2;
					monthTotal2= new double[100][2];//100 APPROXIMATION DE MAX
					double money2=0;
					int i2= 0;
					while(Arrival2.next()) {
						
						date2= Arrival2.getDate("checkIn");
						monthTotal2[i2][0]= (date2.getMonth())+1;
						//JOptionPane.showMessageDialog(null, monthTotal[i][0]);
						monthTotal2[i2][1]= Arrival2.getDouble("Total");
						//JOptionPane.showMessageDialog(null, monthTotal[i][1]);
						i2++;
					}
					int uniqueValue2= 0;
					int tailleTab2= i2;
					//JOptionPane.showMessageDialog(null, tailleTab);
					int month2;
					for(int j=0; j<tailleTab2; j++) {
						for(int k=0; k<tailleTab2; k++) {
							//J REPRESENTE INDICE DE MONTH
							if(monthTotal2[j][0]==monthTotal2[k][0]  && k!=j) {//comparaison avec toutes les valeurs du tableau sauf la valeur avec elle même
								money2+= monthTotal2[j][1]+monthTotal2[k][1];
								uniqueValue2++;
							}
						}
						if(uniqueValue2==0) {
							money2= monthTotal2[j][1];
							month2= (int) monthTotal2[j][0];
							//JOptionPane.showMessageDialog(null, "heeere"+money);
							series2.add(month2, money2);
						}else {
							month2= (int) monthTotal2[j][0];
							series2.add(month2, money2);
						}
						uniqueValue2= 0;
						money2= 0;
					}
					
					Arrival2.close();
					
					//series3
					ResultSet Arrival3= Select.getData("select * from costumer where Bed='Double' and RoomType='AC' and YEAR(checkIn)=YEAR(NOW())");
					Date date3;
					double[][] monthTotal3;
					monthTotal3= new double[100][2];//100 APPROXIMATION DE MAX
					double money3=0;
					int i3= 0;
					while(Arrival3.next()) {
						
						date3= Arrival3.getDate("checkIn");
						monthTotal3[i3][0]= (date3.getMonth())+1;
						//JOptionPane.showMessageDialog(null, monthTotal[i][0]);
						monthTotal3[i3][1]= Arrival3.getDouble("Total");
						//JOptionPane.showMessageDialog(null, monthTotal[i][1]);
						i3++;
					}
					int uniqueValue3= 0;
					int tailleTab3= i3;
					//JOptionPane.showMessageDialog(null, tailleTab);
					int month3;
					for(int j=0; j<tailleTab3; j++) {
						for(int k=0; k<tailleTab3; k++) {
							//J REPRESENTE INDICE DE MONTH
							if(monthTotal3[j][0]==monthTotal3[k][0]  && k!=j) {//comparaison avec toutes les valeurs du tableau sauf la valeur avec elle même
								money3+= monthTotal3[j][1]+monthTotal3[k][1];
								uniqueValue3++;
							}
						}
						if(uniqueValue3==0) {
							money3= monthTotal3[j][1];
							month3= (int) monthTotal3[j][0];
							//JOptionPane.showMessageDialog(null, "heeere"+money);
							series3.add(month3, money3);
						}else {
							month3= (int) monthTotal3[j][0];
							series3.add(month3, money3);
						}
						uniqueValue3= 0;
						money3= 0;
					}
					
					Arrival3.close();
				
					
					//series4
					ResultSet Arrival4= Select.getData("select * from costumer where Bed='Double' and RoomType='Non-AC' and YEAR(checkIn)=YEAR(NOW())");
					Date date4;
					double[][] monthTotal4;
					monthTotal4= new double[100][2];//100 APPROXIMATION DE MAX
					double money4=0;
					int i4= 0;
					while(Arrival4.next()) {
						
						date4= Arrival4.getDate("checkIn");
						monthTotal4[i4][0]= (date4.getMonth())+1;
						//JOptionPane.showMessageDialog(null, monthTotal[i][0]);
						monthTotal4[i4][1]= Arrival4.getDouble("Total");
						//JOptionPane.showMessageDialog(null, monthTotal[i][1]);
						i4++;
					}
					int uniqueValue4= 0;
					int tailleTab4= i4;
					//JOptionPane.showMessageDialog(null, tailleTab);
					int month4;
					for(int j=0; j<tailleTab4; j++) {
						for(int k=0; k<tailleTab4; k++) {
							//J REPRESENTE INDICE DE MONTH
							if(monthTotal4[j][0]==monthTotal4[k][0]  && k!=j) {//comparaison avec toutes les valeurs du tableau sauf la valeur avec elle même
								money4+= monthTotal4[j][1]+monthTotal4[k][1];
								uniqueValue4++;
							}
						}
						if(uniqueValue4==0) {
							money4= monthTotal4[j][1];
							month4= (int) monthTotal4[j][0];
							//JOptionPane.showMessageDialog(null, "heeere"+money);
							series4.add(month4, money4);
						}else {
							month4= (int) monthTotal4[j][0];
							series4.add(month4, money4);
						}
						uniqueValue4= 0;
						money4= 0;
					}
					
					Arrival4.close();
					
					//serie5
					/*ResultSet Arrival5= Select.getData("select * from costumer where Bed='Triple' and RoomType='AC' and YEAR(checkIn)=YEAR(NOW())");
					Date date5;
					double[][] monthTotal5;
					monthTotal5= new double[100][2];//100 APPROXIMATION DE MAX
					double money5=0;
					int i5= 0;
					while(Arrival5.next()) {
						
						date5= Arrival5.getDate("checkIn");
						monthTotal5[i5][0]= (date5.getMonth())+1;
						//JOptionPane.showMessageDialog(null, monthTotal[i][0]);
						monthTotal5[i5][1]= Arrival5.getDouble("Total");
						//JOptionPane.showMessageDialog(null, monthTotal[i][1]);
						i5++;
					}
					int uniqueValue5= 0;
					int tailleTab5= i5;
					//JOptionPane.showMessageDialog(null, tailleTab);
					int month5;
					for(int j=0; j<tailleTab5; j++) {
						for(int k=0; k<tailleTab5; k++) {
							//J REPRESENTE INDICE DE MONTH
							if(monthTotal5[j][0]==monthTotal5[k][0]  && k!=j) {//comparaison avec toutes les valeurs du tableau sauf la valeur avec elle même
								money5+= monthTotal5[j][1]+monthTotal5[k][1];
								uniqueValue5++;
							}
						}
						if(uniqueValue5==0) {
							money5= monthTotal5[j][1];
							month5= (int) monthTotal5[j][0];
							//JOptionPane.showMessageDialog(null, "heeere"+money);
							series5.add(month5, money5);
						}else {
							month5= (int) monthTotal5[j][0];
							series5.add(month5, money5);
						}
						uniqueValue5= 0;
						money5= 0;
					}
					
					Arrival5.close();
					*/
					
				} catch (HeadlessException | SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
			}
		});


	    dataset.addSeries(series1);
	    dataset.addSeries(series2);
	    dataset.addSeries(series3);
	    dataset.addSeries(series4);
	    //dataset.addSeries(series5);
	    
	    return dataset;
	}
	
	private void customizeChart(JFreeChart chart) {   // here we make some customization
	    XYPlot plot = chart.getXYPlot();
	    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	
	    // sets paint color for each series
	    renderer.setSeriesPaint(0, Color.RED);
	    renderer.setSeriesPaint(1, Color.GREEN);
	    renderer.setSeriesPaint(2, Color.ORANGE);
	    renderer.setSeriesPaint(3, Color.blue);
	    //renderer.setSeriesPaint(4, Color.pink);
	
	    // sets thickness for series (using strokes)
	    renderer.setSeriesStroke(0, new BasicStroke(4.0f));
	    renderer.setSeriesStroke(1, new BasicStroke(3.0f));
	    renderer.setSeriesStroke(2, new BasicStroke(2.0f));
	    renderer.setSeriesStroke(3, new BasicStroke(2.0f));
	    //renderer.setSeriesStroke(4, new BasicStroke(2.0f));
	    
	    // sets paint color for plot outlines
	    plot.setOutlinePaint(Color.BLUE);
	    plot.setOutlineStroke(new BasicStroke(2.0f));
	    
	    // sets renderer for lines
	    plot.setRenderer(renderer);
	    
	    // sets plot background
	    plot.setBackgroundPaint(Color.WHITE);
	    
	    // sets paint color for the grid lines
	    plot.setRangeGridlinesVisible(true);
	    plot.setRangeGridlinePaint(Color.BLACK);
	    
	    plot.setDomainGridlinesVisible(true);
	    plot.setDomainGridlinePaint(Color.BLACK);
	    
	}

	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	    	public void run() {
				try {
					MultipleLinesChart frame = new MultipleLinesChart();
					frame.setUndecorated(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	    });
	}
}