import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 *  
 *
 * Version 1.0
 * 
 * @author Swanand Pathak
 * @author Amit Doshi
 * Date: 11/11/2014
 * 
 */


/**
 * Convertor class which extends JFrame, Wherein the labels, Buttons and TextField  
 * for the given Frame are built
 *  
 */
public class Convertor extends JFrame{
	
	JButton convdegtocel,convceltodeg,convkmphtomph,convmphtokmph,convinchtometre,convmetertoinch,convkmtolightyear,convlightyeartokm,one,two,three,four,five,six,seven,eight,nine,zero,clear;
	JTextField userip,result;
	JLabel input,rs;
	static String num2="0";
	public Convertor()
	{
		setLayout(new GridBagLayout());	                  //setting Layout
		GridBagConstraints c=new GridBagConstraints();	  //Creating object c
	
		input=new JLabel("         Enter Here");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;										   
		c.gridwidth=3;
		add(input,c);
		
		userip=new JTextField(10);						  
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=3;
		c.gridy=0;
		c.gridwidth=3;
		add(userip,c);
	
		clear=new JButton("Clear");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=0;
		c.gridwidth=1;
		add(clear,c);
		
		convdegtocel=new JButton("C to F");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=3;
		c.gridwidth=1;
		add(convdegtocel,c);
		
		convceltodeg=new JButton("F to C");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=1;
		add(convceltodeg,c);
		
		convkmphtomph=new JButton("km/hr to M/hr");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=3;
		c.gridwidth=1;
		add(convkmphtomph,c);
		
		convmphtokmph=new JButton("M/hr to km/hr");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=4;
		c.gridwidth=1;
		add(convmphtokmph,c);
		
		convinchtometre=new JButton("Inches to Meter");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=3;
		c.gridy=3;
		c.gridwidth=1;
		add(convinchtometre,c);
		
		convmetertoinch=new JButton("Meter to Inches");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=3;
		c.gridy=2;
		c.gridwidth=1;
		add(convmetertoinch,c);
		
		convkmtolightyear=new JButton("Km to Lightyear");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=2;
		c.gridwidth=1;
		add(convkmtolightyear,c);	
		
		convlightyeartokm=new JButton("Lightyear to Km");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=4;
		c.gridwidth=1;
		add(convlightyeartokm,c);	
		
		one=new JButton("1");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=5;
		c.gridwidth=1;
		add(one,c);
		
		two=new JButton("2");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=6;
		c.gridwidth=1;
		add(two,c);
		
		three=new JButton("3");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=7;
		c.gridwidth=1;
		add(three,c);
		
		four=new JButton("4");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=3;
		c.gridy=5;
		c.gridwidth=1;
		add(four,c);
		
		five=new JButton("5");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=5;
		c.gridwidth=1;
		add(five,c);
		
		six=new JButton("6");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=3;
		c.gridy=6;
		c.gridwidth=1;
		add(six,c);
		
		seven=new JButton("7");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=6;
		c.gridwidth=1;
		add(seven,c);
		
		eight=new JButton("8");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=3;
		c.gridy=7;
		c.gridwidth=1;
		add(eight,c);
		
		nine=new JButton("9");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=7;
		c.gridwidth=1;
		add(nine,c);
		
		zero=new JButton("0");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=3;
		c.gridy=4;
		c.gridwidth=1;
		add(zero,c);
		rs=new JLabel(" Result");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=10;										   
		c.gridwidth=3;
		add(rs,c);
		result=new JTextField(30);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=3;
		c.gridy=10;
		c.gridwidth=3;
		add(result,c);
		
		
		userip.setText("0");
		userip.setForeground(Color.RED);
		
		event a =new event();							// Object of class event a created 
		convdegtocel.addActionListener(a);
		convceltodeg.addActionListener(a);
		convkmphtomph.addActionListener(a);
		convmphtokmph.addActionListener(a);
		convinchtometre.addActionListener(a);
		convmetertoinch.addActionListener(a);
		convkmtolightyear.addActionListener(a);
		convlightyeartokm.addActionListener(a);			
		clear.addActionListener(a);
		one.addActionListener(a);
		two.addActionListener(a);
		three.addActionListener(a);
		four.addActionListener(a);
		five.addActionListener(a);
		six.addActionListener(a);
		seven.addActionListener(a);
		eight.addActionListener(a);
		nine.addActionListener(a);
		zero.addActionListener(a);
		
		
		
	}
	/**
	 * class event which implements ActionListener where functionality of all the labels, buttons 
	 * and textFields. 
	 *  
	 */
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent a){
			double num;
		   
			String op=a.getActionCommand();
			if(op.equals("1"))
			{
				userip.setText(num2+"1");
				userip.setForeground(Color.RED);
				num2=num2+"1";
			}
			else if(op.equals("2"))
			{
				userip.setText(num2+"2");
				userip.setForeground(Color.RED);
				num2=num2+"2";
			}
			else if(op.equals("3"))
			{
				userip.setText(num2+"3");
				userip.setForeground(Color.RED);
				num2=num2+"3";
			}
			else if(op.equals("4"))
			{
				userip.setText(num2+"4");
				userip.setForeground(Color.RED);
				num2=num2+"4";
			}
			else if(op.equals("5"))
			{
				userip.setText(num2+"5");
				userip.setForeground(Color.RED);
				num2=num2+"5";
			}
			else if(op.equals("6"))
			{
				userip.setText(num2+"6");
				userip.setForeground(Color.RED);
				num2=num2+"6";
			}
			else if(op.equals("7"))
			{
				userip.setText(num2+"7");
				userip.setForeground(Color.RED);
				num2=num2+"7";
			}
			else if(op.equals("8"))
			{
				userip.setText(num2+"8");
				userip.setForeground(Color.RED);
				num2=num2+"8";
			}
			else if(op.equals("9"))
			{
				userip.setText(num2+"9");
				userip.setForeground(Color.RED);
				num2=num2+"9";
			}
			else if(op.equals("0"))
			{
				userip.setText(num2+"0");
				userip.setForeground(Color.RED);
				num2=num2+"0";
			}
			
			else if(op.equals("C to F"))
			{
				 num=Double.parseDouble(userip.getText());
				double far=((num*(9.0/5.0))+32.0);
				result.setText(far+"F");
				result.setForeground(Color.RED);
				
			}
			else if(op.equals("F to C"))
			{
				 num=Double.parseDouble(userip.getText());
				double cel=(((num-32.0)*5.0)/9.0);
				result.setText(cel+"C");
				result.setForeground(Color.RED);
				
			}
			else if(op.equals("km/hr to M/hr"))
			{
				 num=Double.parseDouble(userip.getText());
				double mph=num*1.609344;
				result.setText(mph+"M/hr");
				result.setForeground(Color.RED);
			}
			else if(op.equals("M/hr to km/hr"))
			{
				 num=Double.parseDouble(userip.getText());
				double kmph=num/1.609344;
				result.setText(kmph+"km/hr");
				result.setForeground(Color.RED);
			}
			else if(op.equals("Inches to Meter"))
			{
				 num=Double.parseDouble(userip.getText());
				double meter=num/39.37;
				result.setText(meter+" m");
				result.setForeground(Color.RED);
			}
			else if(op.equals("Meter to Inches"))
			{
				num=Double.parseDouble(userip.getText());
				double inch=num*39.37;
				result.setText(inch+" inch");
				result.setForeground(Color.RED);
			}
			else if(op.equals("Km to Lightyear"))
			{
				num=Double.parseDouble(userip.getText());
				double Lightyear=num*1.05702341;
				result.setText(Lightyear+"x 10^-13 Lightyear");
				result.setForeground(Color.RED);
			}
			else if(op.equals("Lightyear to Km"))
			{
				num=Double.parseDouble(userip.getText());
				double Km=num*9.4605284;
				result.setText(Km+"x 10^12 Km");
				result.setForeground(Color.RED);
			}
			else if(op.equals("Clear"))
			{
				userip.setText("0");
				userip.setForeground(Color.RED);
				num2="0";
			}
		}
	}
	/**
	 * The main program.
	 *
	 * @param args command line arguments (ignored)
	 */
	public static void main(String args[])
	{
		Convertor gui=new Convertor();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setBounds(100, 100, 400, 400);
		gui.setTitle("Convertor");
		
	}

}
