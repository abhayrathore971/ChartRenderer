package com.chartrenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoint;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

 
@SuppressWarnings("serial")
class Layout extends JFrame implements ActionListener{
	static JFrame f;
	static JLabel duration,l1,l2,l3,l4,l5,l6,l7,l8,base,cn1,cn2,cn3,cn4,hi;
	static JComboBox c1;
        JRadioButton r11,r12,r13,r21,r22,r23,r31,r32,r33,r41,r42,r43,r51,r52,r53,r61,r62,r63,r71,r72,r73,rfs,rt,rh,rp,emer1,emer2,rct;
	static JButton b;
	static JTextField h1,m1,s1,h2,m2,s2;
	static String path,time1,time2,y,x;

	static int j;
	public void setPath(String str) {
	this.path = str;
	}
	
	public static void main (String[] args) {
			Layout d1 = new Layout();
	                JFileChooser fc= new JFileChooser();
			fc.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fc.showOpenDialog(f);
			if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			path=selectedFile.getAbsolutePath();
			Duration();
			}
	}
	
	
	
	//Duration Layout
	public static void Duration(){
		Layout d = new Layout();
		f=new JFrame("Duration");
		 try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
	
	String options[] = {"TIME", "PRESSURE", "HUMIDITY", "FAN SPEED", "TEMPERATURE", "CPU TEMPERATURE" };
 
	c1 = new JComboBox(options);
        b=new JButton("Enter");
        duration = new JLabel("Duration:");
        base = new JLabel("\nSelect X-axis");
        
        cn1 = new JLabel(":");
        cn2 = new JLabel(":");
        cn3 = new JLabel(":");
        cn4 = new JLabel(":");
        
        JLabel hi2 = new JLabel("From");
        hi = new JLabel("to");
	
        h1 = new JTextField("00");
        m1 = new JTextField("00");
        s1 = new JTextField("00");
        h2 = new JTextField("23");
        m2 = new JTextField("59");
        s2 = new JTextField("59");
	
	ImageIcon originalImageIcon = new ImageIcon("logo.png"); // Replace with the actual path
        
        // Resize the image
        Image originalImage = originalImageIcon.getImage();
        int targetWidth = 130; // Adjust as needed
        int targetHeight = 50; // Adjust as needed
        Image resizedImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        
        JLabel imageLabel = new JLabel(resizedImageIcon);
	
	JPanel p=new JPanel();
    JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();

	b.addActionListener(d);


		p1.add(duration);
		p1.add(hi2);
		p1.add(h1);
		p1.add(cn1);
		p1.add(m1);
		p1.add(cn2);
		p1.add(s1);
		
    
		p1.add(hi);
		
		p1.add(h2);
		p1.add(cn3);
		p1.add(m2);
		p1.add(cn4);
		p1.add(s2);
		    
		p2.add(base);
		p2.add(c1);
		
		p2.add(b);
		p3.add(imageLabel);

		p.setLayout( new GridLayout(3,1) );
		p.add(p1);
		p.add(p2);
		p.add(p3);
 
        f.add(p);
	f.setBackground(Color.gray);
        f.setSize(600,300);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.show();
		}
		
		
		
		
		
		//RadioButton
		public void Project() {
		Project c=new Project();
		f=new JFrame("Project");
		
		 try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
		
		l1=new JLabel("A/C");
		l2=new JLabel("ANT");
		l3=new JLabel("SSTX");
		l4=new JLabel("RXSP");
		l5=new JLabel("DISP");
		l6=new JLabel("MSSR");
		l7=new JLabel("LIGHT");
		
		
		
		JButton bs;		
		
		bs=new JButton("Show");
		//l1
		r11 = new JRadioButton();
		r12 = new JRadioButton();
		r13 = new JRadioButton();
		//l2
		r21 = new JRadioButton();
		r22 = new JRadioButton();
		r23 = new JRadioButton();
		//l3
		r31 = new JRadioButton();
		r32 = new JRadioButton();
		r33 = new JRadioButton();
		//l4
		r41 = new JRadioButton();
		r42 = new JRadioButton();
		r43 = new JRadioButton();
		//l4
		r41 = new JRadioButton();
		r42 = new JRadioButton();
		r43 = new JRadioButton();
		//l5
		r51 = new JRadioButton();
		r52 = new JRadioButton();
		r53 = new JRadioButton();
		//l6
		r61 = new JRadioButton();
		r62 = new JRadioButton();
		r63 = new JRadioButton();
		//l7
		r71 = new JRadioButton();
		r72 = new JRadioButton();
		r73 = new JRadioButton();
		
		//JRadioButton ;
		
		rfs = new JRadioButton("Fan Speed");
		rt = new JRadioButton("Temperature");
		rh = new JRadioButton("Humidity");
		rp = new JRadioButton("Pressure");
		emer1 = new JRadioButton("EMER1");
		emer2 = new JRadioButton("EMER2");
		rct = new JRadioButton("CPU TEMP");
		
		JPanel p=new JPanel();
		
		bs.addActionListener(c);
		
		JLabel jl1,jl2,jl3,jl4,jl5;
		jl1=new JLabel("ProjectName");
		jl2=new JLabel("L1");
		jl3=new JLabel("L2");
		jl4=new JLabel("L3");
		jl5=new JLabel("   ");
		

	
	p.add(jl1);
	p.add(jl2);
	p.add(jl3);
	p.add(jl4);
	
	p.add(jl5);
	
        p.add(l1);
	p.add(r11);
	p.add(r12);
	p.add(r13);
	
	p.add(rfs);
	
	p.add(l2);
	p.add(r21);
	p.add(r22);
	p.add(r23);
	
	p.add(rt);
	
	p.add(l3);
	p.add(r31);
	p.add(r32);
	p.add(r33);
	
	p.add(rh);
	
	p.add(l4);
	p.add(r41);
	p.add(r42);
	p.add(r43);
	
	p.add(rp);
	
	p.add(l5);
	p.add(r51);
	p.add(r52);
	p.add(r53);
	
	p.add(emer1);
	
	p.add(l6);
	p.add(r61);
	p.add(r62);
	p.add(r63);
	
	p.add(emer2);
	
	p.add(l7);
	p.add(r71);
	p.add(r72);
	p.add(r73);
	
	p.add(rct);
	
	p.add(bs);
		

		p.setBackground(Color.gray);
		p.setLayout( new GridLayout(0, 5) );
 
        f.add(p);
 
        f.setSize(600,330);
        f.show();
	}
	
	
	//ActionListener for Duration
	public void actionPerformed(ActionEvent e){
		time1 = h1.getText()+":"+m1.getText()+":"+s1.getText();
		time2 = h2.getText()+":"+m2.getText()+":"+s2.getText();
		
		x=String.valueOf(c1.getSelectedItem());
		
		System.out.println(x);
		
		f.dispose();
	//	Read();
		Project();
		}
		
		
	//ActionListener for RadioButton	
	class Project implements ActionListener{	
	public void actionPerformed(ActionEvent e){
		
if(r11.isSelected()){    
 y="AC_L1";
 j=2;
}    
if(r12.isSelected()){    
  y="AC_L2";
  j=3;
}
if(r13.isSelected()){    
y="AC_L3";
j=4;
}    
if(r21.isSelected()){    
  y="ANT_L1";
  j=6;
}
if(r22.isSelected()){    
y="ANT_L2";
j=7;

}    
if(r23.isSelected()){    
  y="ANT_L3";
  j=8;
}
if(r31.isSelected()){    
y="SSTX_L1";
j=10;
}    
if(r32.isSelected()){    
  y="SSTX_L2";
  j=11;
}
if(r33.isSelected()){    
y="SSTX_L3";
j=12;
}    
if(r41.isSelected()){    
  y="RXSP_L1";
  j=14;
}
if(r42.isSelected()){    
y="RXSP_L2";
j=15;
}    
if(r43.isSelected()){    
  y="RXSP_L3";
  j=16;
}
if(r51.isSelected()){    
y="DISP_L1";
j=18;
}    
if(r52.isSelected()){    
  y="DISP_L2";
  j=19;
}
if(r53.isSelected()){    
y="DISP_L3";
j=20;
}    
if(r61.isSelected()){    
  y="MSSR_L1";
  j=22;
}
if(r62.isSelected()){    
y="MSSR_L2";
j=23;
}    
if(r63.isSelected()){    
  y="MSSR_L3";
  j=24;
}
if(r71.isSelected()){    
y="LIGHT_L1";
j=26;
}    
if(r72.isSelected()){    
  y="LIGHT_L2";
  j=27;
}
if(r73.isSelected()){    
y="LIGHT_L3";
j=28;
}    
if(rfs.isSelected()){    
  y="FAN SPEED";
  j=29;
}
if(rt.isSelected()){    
	y="TEMPERATURE";
  j=30;
}    
if(rh.isSelected()){    
  y="HUMIDITY";
  j=31;
}    
if(rp.isSelected()){    
	y="PRESSURE";
  j=32;
}    
if(emer1.isSelected()){    
  y="EMER1";
  j=33;
}
if(emer2.isSelected()){    
	y= "EMER2";
  j=34;
}    
if(rct.isSelected()){    
  y = "CPU Temperature";
  j=35;
}		
	//	f.dispose();
		Read();
		}
	}

public static void Read(){  
    SwingUtilities.invokeLater(() -> {
	  String title = y+" Vs "+x;
      ScatterPlot example = new ScatterPlot(
		 title,
         path,
         y,
		 x,
		 time1,
		 time2,
     j);  
      example.setSize(600, 300);  
      example.setLocationRelativeTo(null);  
      example.setVisible(true);  
    });  
  }

////////////////////////////////////////////////////////////////////////
}




//Scatter Plot
class ScatterPlot extends JFrame{  
	  static JButton b;
	  static JComboBox c1;
	  static String selected;
	 ArrayList<Double> xdata = new ArrayList<>();
	 ArrayList<Double> ydata = new ArrayList<>();
	  public ScatterPlot(String title,String path, String y, String x, String time1, String time2, int column_index) {  
	    super(title);  
	 
	    // Create dataset  
	    XYDataset dataset = createDataset(path, x, y, time1, time2, column_index);  
	 
	    // Create chart  
	    JFreeChart chart = ChartFactory.createScatterPlot(  
	        " ",  
	        x, y, dataset,PlotOrientation.VERTICAL,true,true,false);  
	 
	     
	    //Changes background color  
	    XYPlot plot = (XYPlot)chart.getPlot();  
	    plot.setBackgroundPaint(Color.white);  
	     
	     JLabel jl = new JLabel("ANALYSIS");
	     
	    String options[] = {"Linear", "Polynomial", "Exponential", "Logarithmic", "Select ALL"};
	 	c1 = new JComboBox(options);
	     
	      b = new JButton("Best Fit");
	      b.setFocusable(false);
	      b.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){
				selected=String.valueOf(c1.getSelectedItem());
			  BestFit();
		      }
		  });
	     
	    // Create Panel  
	    ChartPanel panel = new ChartPanel(chart);  
	    setContentPane(panel);
	    panel.add(jl);
	    panel.add(c1);
	    panel.add(b);
	  }  
	 
	  private XYDataset createDataset(String path, String x, String y, String time1, String time2, int column_index) {  
	    XYSeriesCollection dataset = new XYSeriesCollection();  
	   
	    XYSeries series = new XYSeries("Data");
	   
	    try(      
	                BufferedReader br = new BufferedReader(new FileReader(path));
	                CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(br);
	                ) {
	                 
	                  int index=0;
		       String t1 = "2023-07-03 "+time1;
	               String t2 = "2023-07-03 "+time2;

		       
	               SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
	               Date c = format.parse(t2);
	               Date b = format.parse(t1);
			
	               for(CSVRecord csv : parser){
	               Date a = format.parse(csv.get(0));
	               index++;
	               if(compareTime(a,b,"<=")==true) {
			    
			    System.out.print(index+"  ");
			    
			    double yData=Double.parseDouble(csv.get(column_index));
			    ydata.add(yData);
			    double xData;
			    if(x=="TIME"){
				String timeData=csv.get(x);
				xData= timeToSeconds(timeData);
				xdata.add(xData);
				}
			    
			    else{
				xData=Double.parseDouble(csv.get(x));
				xdata.add(xData);
				}
			    series.add(xData,yData);
			    
			   if(compareTime(a,c,"<")==true){
				break;
				}
			     }
	                  }
		    }
	               
	           
	         catch (Exception e) {
	            System.out.println(e);
	        }
	     
	    dataset.addSeries(series);  
	 
	    return dataset;  
	  }
	 
	     protected static boolean compareTime(Date a, Date b, String operator)
	   {
	  if (a == null)
	   {
	     return false;
	   }
	   try
	   {
	     SimpleDateFormat parser = new SimpleDateFormat("HH:mm:ss.SSS");
	     a = parser.parse(parser.format(a));
	     b = parser.parse(parser.format(b));
	     
	   }
	   catch (Exception ex)
	   {
	     System.err.println(ex);
	   }
	   switch (operator){
	         case "<=":
		    return b.compareTo(a) <= 0;
		 case "<":
		    return b.compareTo(a) < 0;
		default:
		    throw new IllegalArgumentException("Operator " + operator + " wird für Feldart Time nicht unterstützt!");
	   }
	   }
	   
	   public static double timeToSeconds(String TimeString) {
	            int dotIndex = TimeString.indexOf('.');
	        String TWF = TimeString.substring(0, dotIndex);
	         DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        LocalDateTime dateTime = LocalDateTime.parse(TWF, inputFormatter);

	        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	        String timeString = dateTime.format(outputFormatter);

	        String[] parts = timeString.split(":");
	        double hours = Double.parseDouble(parts[0]);
	        double minutes = Double.parseDouble(parts[1]);
	        double seconds = Double.parseDouble(parts[2]);
	       
	        double totseconds = hours * 3600 + minutes * 60 + seconds;

	        return totseconds;
	    }

	    public void BestFit(){
		new BestFitCorrelation(xdata, ydata, selected);
		}
	} 



//Best Fit;
class BestFitCorrelation extends JFrame{

    public BestFitCorrelation(ArrayList<Double> xData, ArrayList<Double> yData, String selected) {
        // Calculate the best fit for polynomial, exponential, and logarithmic correlations

        ArrayList<Double> polyCoefficients = polynomialBestFit(xData, yData, 2);
        ArrayList<Double> expCoefficients = exponentialBestFit(xData, yData);
        ArrayList<Double> logCoefficients = logarithmicBestFit(xData, yData);
        ArrayList<Double> linearCoefficients = linearBestFit(xData, yData);

        // Optionally, you can visualize the data and best fit curves using JFreeChart
        displayChart(xData, yData, linearCoefficients, polyCoefficients, expCoefficients, logCoefficients, selected);
    }

 // Linear best fit (y = mx + c)
    private static ArrayList<Double> linearBestFit(ArrayList<Double> xData, ArrayList<Double> yData) {
    	 SimpleRegression regression = new SimpleRegression();
    	for (int i = 0; i < xData.size(); i++) {
            regression.addData(xData.get(i), yData.get(i));
        }

    	ArrayList<Double> result = new ArrayList<>();
    	result.add(regression.getIntercept());
        result.add(regression.getSlope());
        return result;
    }
   

 // Polynomial best fit using Apache Commons Math
    private static ArrayList<Double> polynomialBestFit(ArrayList<Double> xData, ArrayList<Double> yData, int degree) {
        WeightedObservedPoints points = new WeightedObservedPoints();
        for (int i = 0; i < xData.size(); i++) {
            points.add(xData.get(i), yData.get(i));
        }

        try {
            double[] coefficients = PolynomialCurveFitter.create(degree).fit(points.toList());

            // Convert the array of doubles to an ArrayList of Doubles
            ArrayList<Double> result = new ArrayList<>();
            for (double coefficient : coefficients) {
                result.add(coefficient);
            }
            return result;
        } catch (ConvergenceException e) {
            System.out.println("Polynomial best fit did not converge. No best fit exists.");
            return null; // or handle this case as needed
        }
    }

    // Exponential best fit (y = a * e^(bx))
    private static ArrayList<Double> exponentialBestFit(ArrayList<Double> xData, ArrayList<Double> yData) {
        WeightedObservedPoints points = new WeightedObservedPoints();
        for (int i = 0; i < xData.size(); i++) {
            points.add(xData.get(i), Math.log(yData.get(i)));
        }

        try {
            PolynomialCurveFitter fitter = PolynomialCurveFitter.create(1);
            double[] coefficients = fitter.fit(points.toList());

            // Convert the coefficients back to the original form (y = a * e^(bx))
            double a = Math.exp(coefficients[0]);
            double b = coefficients[1];
            return new ArrayList<>(List.of(a, b));
        } catch (ConvergenceException e) {
            System.out.println("Exponential best fit did not converge. No best fit exists.");
            return null; // or handle this case as needed
        }
    }

    // Logarithmic best fit (y = a + b * ln(x))
    private static ArrayList<Double> logarithmicBestFit(ArrayList<Double> xData, ArrayList<Double> yData) {
        WeightedObservedPoints points = new WeightedObservedPoints();
        for (int i = 0; i < xData.size(); i++) {
            points.add(Math.log(xData.get(i)), yData.get(i));
        }

        try {
            SimpleRegression regression = new SimpleRegression();
            for (WeightedObservedPoint point : points.toList()) {
                regression.addData(point.getX(), point.getY());
            }

            double a = regression.getIntercept();
            double b = regression.getSlope();

            return new ArrayList<>(List.of(a, b));
        } catch (ConvergenceException e) {
            System.out.println("Logarithmic best fit did not converge. No best fit exists.");
            return null; // or handle this case as needed
        }
    }
    
    // Visualize the data and best fit curves using JFreeChart
    private static void displayChart(List<Double> xData, List<Double> yData, List<Double> linearCoefficients, List<Double> polyCoefficients,
            List<Double> expCoefficients, List<Double> logCoefficients, String selectedFit) {

XYSeries dataSeries = new XYSeries("Data");
for (int i = 0; i < xData.size(); i++) {
dataSeries.add(xData.get(i), yData.get(i));
}

JFreeChart chart;
XYPlot plot;

switch (selectedFit) {
case "Linear":
XYSeries linearSeries = new XYSeries("Linear Best Fit");
for (double x : xData) {
double y = evaluateLinear(linearCoefficients, x);
linearSeries.add(x, y);
}

chart = ChartFactory.createScatterPlot(
"Linear Best Fit", "X", "Y", null, PlotOrientation.VERTICAL, true, true, false);

plot = chart.getXYPlot();
plot.setBackgroundPaint(Color.white);

XYSeriesCollection linearSeriesCollection = new XYSeriesCollection();
linearSeriesCollection.addSeries(linearSeries);
linearSeriesCollection.addSeries(dataSeries);
plot.setDataset(1, linearSeriesCollection);
plot.setRenderer(1, new XYShapeRenderer());
break;

case "Polynomial":
	XYSeries polySeries = new XYSeries("Polynomial Best Fit");
	for (double x : xData) {
	double y = evaluatePolynomial(polyCoefficients, x);
	polySeries.add(x, y);
	}

	chart = ChartFactory.createScatterPlot(
	"Polynomial Best Fit", "X", "Y", null, PlotOrientation.VERTICAL, true, true, false);

	plot = chart.getXYPlot();
	plot.setBackgroundPaint(Color.white);

	XYSeriesCollection polySeriesCollection = new XYSeriesCollection();
	polySeriesCollection.addSeries(polySeries);
	polySeriesCollection.addSeries(dataSeries);
	plot.setDataset(0, polySeriesCollection);
	plot.setRenderer(0, new XYShapeRenderer());
	break;

case "Exponential":
    XYSeries expSeries = new XYSeries("Exponential Best Fit");
    for (double x : xData) {
        double y = evaluateExponential(expCoefficients, x);
        expSeries.add(x, y);
    }
    
    chart = ChartFactory.createScatterPlot(
            "Exponential Best Fit", "X", "Y", null, PlotOrientation.VERTICAL, true, true, false);
    
    plot = chart.getXYPlot();
    plot.setBackgroundPaint(Color.white);
    
    XYSeriesCollection expSeriesCollection = new XYSeriesCollection();
    expSeriesCollection.addSeries(expSeries);
    expSeriesCollection.addSeries(dataSeries);
    plot.setDataset(0, expSeriesCollection);
    plot.setRenderer(0, new XYShapeRenderer());
    break;

case "Logarithmic":
    XYSeries logSeries = new XYSeries("Logarithmic Best Fit");
    for (double x : xData) {
        double y = evaluateLogarithmic(logCoefficients, x);
        logSeries.add(x, y);
    }
    
    chart = ChartFactory.createScatterPlot(
            "Logarithmic Best Fit", "X", "Y", null, PlotOrientation.VERTICAL, true, true, false);
    
    plot = chart.getXYPlot();
    plot.setBackgroundPaint(Color.white);
    
    XYSeriesCollection logSeriesCollection = new XYSeriesCollection();
    logSeriesCollection.addSeries(logSeries);
    logSeriesCollection.addSeries(dataSeries);
    plot.setDataset(0, logSeriesCollection);
    plot.setRenderer(0, new XYShapeRenderer());
    break;
    
case "Select ALL":
    XYSeries LinearSeries = new XYSeries("Linear Best Fit");
    for (double x : xData) {
        double y = evaluateLinear(linearCoefficients, x);
        LinearSeries.add(x, y);
    }
    
    XYSeries PolySeries = new XYSeries("Polynomial Best Fit");
    for (double x : xData) {
        double y = evaluatePolynomial(polyCoefficients, x);
        PolySeries.add(x, y);
    }

    XYSeries ExpSeries = new XYSeries("Exponential Best Fit");
    for (double x : xData) {
        double y = evaluateExponential(expCoefficients, x);
        ExpSeries.add(x, y);
    }

    XYSeries LogSeries = new XYSeries("Logarithmic Best Fit");
    for (double x : xData) {
        double y = evaluateLogarithmic(logCoefficients, x);
        LogSeries.add(x, y);
    }
	
    chart = ChartFactory.createScatterPlot("Best Fit Correlations", "X", "Y", null, PlotOrientation.VERTICAL, true, true, false);
    plot = chart.getXYPlot();
    plot.setBackgroundPaint(Color.white);
    
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(LinearSeries);
    dataset.addSeries(PolySeries);
    dataset.addSeries(ExpSeries);
    dataset.addSeries(LogSeries);
    plot.setDataset(0, dataset);
    
    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    renderer.setSeriesLinesVisible(0, false);
    plot.setRenderer(0, renderer);
    
    XYSeriesCollection dataSeriesCollection = new XYSeriesCollection();
    dataSeriesCollection.addSeries(dataSeries);
    plot.setDataset(1, dataSeriesCollection);
    plot.setRenderer(1, renderer);
    
    break;

default:
chart = ChartFactory.createScatterPlot(
"Best Fit Correlations", "X", "Y", null, PlotOrientation.VERTICAL, true, true, false);

plot = chart.getXYPlot();
plot.setBackgroundPaint(Color.white);

XYSeriesCollection defaultSeriesCollection = new XYSeriesCollection();
defaultSeriesCollection.addSeries(dataSeries);
plot.setDataset(1, defaultSeriesCollection);
plot.setRenderer(1, new XYShapeRenderer());
break;
}

ChartPanel panel = new ChartPanel(chart);
panel.setPreferredSize(new Dimension(600, 300));

JFrame frame = new JFrame("Best Fit Correlations");
frame.setLayout(new BorderLayout());
frame.add(panel, BorderLayout.CENTER);
frame.pack();
frame.setVisible(true);
}

    // Evaluate the polynomial function at the given x value
    private static double evaluatePolynomial(List<Double> coefficients, double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
    }

    // Evaluate the exponential function at the given x value
    private static double evaluateExponential(List<Double> coefficients, double x) {
        double A = coefficients.get(0);
        double B = coefficients.get(1);
        return A * Math.exp(B * x);
    }

    // Evaluate the logarithmic function at the given x value
    private static double evaluateLogarithmic(List<Double> coefficients, double x) {
        double A = coefficients.get(0);
        double B = coefficients.get(1);
        return A + B * Math.log(x);
    }
    
    private static double evaluateLinear(List<Double> coefficients, double x) {
        double m = coefficients.get(1);
        double c = coefficients.get(0);
        return m * x + c;
    }
}