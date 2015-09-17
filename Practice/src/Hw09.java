 /** 
  * @usage: java Homework9 Raviteja Gunda
  * @Author: Raviteja Gunda
  * @Date: 06 November 2013
  * @Version 1.0  
  */


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.Timer;

import java.util.*;
import java.io.*;


public class Hw09 extends JFrame implements ActionListener
{
   private JPanel colorPanel1,colorPanel2,colorPanel3,colorPanel4,colorPanel5,colorPanel6,colorPanel7, colorPanel,progressBarPanel;//changed
   private JLabel clockLabel,progressLabel1,progressLabel2;
   private static JProgressBar bar1,bar2;
   private JMenu fileMenu, helpMenu;//changed
   private JMenuItem exit,about;
   private JMenuBar jMBar;
   static int per=0;
   private final String EXIT="Exit";
   private final String FILE="File";
   private final String ABOUT="About";
   private final String HELP="Help";
   
   public Hw09()
   {
	  super("Fun with Timers");//added
      setSize(400,400);//changed
      setLocation(400,300);//changed
      setResizable(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      jMBar = new JMenuBar();
      setJMenuBar(jMBar);   
      fileMenu = new JMenu(FILE);
      helpMenu = new JMenu(HELP);
      exit = new JMenuItem(EXIT);
      about = new JMenuItem(ABOUT);
      fileMenu.add(exit);
      jMBar.add(fileMenu);
      helpMenu.add(about);
      jMBar.add(helpMenu);
      clockLabel = new JLabel(); 
      colorPanel = new JPanel();
      colorPanel.setLayout(new GridLayout(7,1));
      colorPanel1= new JPanel();
      colorPanel1.setSize(40, 20);
      colorPanel1.setBackground(Color.RED);
      colorPanel2= new JPanel();
      colorPanel2.setBackground(Color.ORANGE);
      colorPanel3= new JPanel();
      colorPanel3.setBackground(Color.YELLOW);
      colorPanel4= new JPanel();
      colorPanel4.setBackground(Color.GREEN);
      colorPanel5= new JPanel();
      colorPanel5.setBackground(Color.BLUE);
      colorPanel6= new JPanel();
      colorPanel6.setBackground(new Color(75,0,130));
      colorPanel7= new JPanel();
      colorPanel7.setBackground(new Color(247,140,247));     
      colorPanel.add(colorPanel1);
      colorPanel.add(colorPanel2);
      colorPanel.add(colorPanel3);
      colorPanel.add(colorPanel4);
      colorPanel.add(colorPanel5);
      colorPanel.add(colorPanel6);
      colorPanel.add(colorPanel7);     
      add(clockLabel,BorderLayout.NORTH);
      add(colorPanel,BorderLayout.CENTER);
      progressBarPanel = new JPanel();
      progressBarPanel.setLayout(new GridLayout(2,1));
      progressLabel1 = new JLabel("Words Progress: ", JLabel.LEFT);//changed
      progressLabel2 = new JLabel("Unabridged Progress: ", JLabel.LEFT);//changed
      bar1 = new JProgressBar(0,100);
      bar2 = new JProgressBar(0,100); 
      progressBarPanel.add(progressLabel1);
      progressBarPanel.add(bar1);
      progressBarPanel.add(progressLabel2);
      progressBarPanel.add(bar2); 
      
      bar1.setStringPainted(true);
      bar1.setIndeterminate(false);
      bar2.setValue(0);
      bar2.setStringPainted(true);
      bar2.setIndeterminate(false);
      add(progressBarPanel,BorderLayout.SOUTH);      
      setVisible(true);
      about.addActionListener(this);
      exit.addActionListener(this);
      this.addWindowListener(
            new WindowAdapter() 
            {
               public void windowClosing(WindowEvent we)
               {
                  try
                  {
                     Thread.sleep(2000);
                     System.exit(0);
                  }
                  catch(InterruptedException ie)
                  {
                     System.out.println(ie.getMessage());
                  
                  }
               }
            });        
   }
    
      /**
       *  Inner class for color changer 
       */

   class ColorModifier implements Runnable //changed
   {
      public void run()
      {
         final int START = 2000;
         final int DELAY = 800;//changed
         TimerTask Action = 
            new TimerTask()
            {
               public void run() 
               {
                  Color o = colorPanel7.getBackground();
                  colorPanel7.setBackground(colorPanel6.getBackground());
                  colorPanel6.setBackground(colorPanel5.getBackground());
                  colorPanel5.setBackground(colorPanel4.getBackground());
                  colorPanel4.setBackground(colorPanel3.getBackground());
                  colorPanel3.setBackground(colorPanel2.getBackground());
                  colorPanel2.setBackground(colorPanel1.getBackground());
                  colorPanel1.setBackground(o);
                  
                  colorPanel.add(colorPanel1);
                  colorPanel.add(colorPanel2);
                  colorPanel.add(colorPanel3);
                  colorPanel.add(colorPanel4);
                  colorPanel.add(colorPanel5);
                  colorPanel.add(colorPanel6);
                  colorPanel.add(colorPanel7);
               }              
            };   
         java.util.Timer utilTimer  = new java.util.Timer();
         utilTimer.scheduleAtFixedRate(Action, START, DELAY);     
      }
   }
   
   @SuppressWarnings("static-access")
public void actionPerformed(ActionEvent e)
   {
      Object eobj = e.getSource();
      if(eobj==about)
      {
         JOptionPane abt = new JOptionPane();
         abt.showMessageDialog(this,"java Homework9 \nAuthor: Raviteja Gunda \nDate: 06 November 2013");
      }
      else if(eobj==exit)
      {
         try
         {
            Thread.sleep(2000);
            System.exit(0);
         }
         catch(InterruptedException ie)
         {
            System.out.println(ie.getMessage());        
         }
      }
   }
      /**
       *  Inner class for ProgressImplementation 1
       */
   
   class ProgressBar1 implements Runnable //changed
   {
      public void run()
      {
         try
         {
            // counts the number of line in the file .. if byte[i] reads new line(\n) it increments the no of lines by 1
            int noOfLines =1;     
            File f = new File("C:/Users/Amit/workspace/Practice/src/words.txt");
            BufferedInputStream is = new BufferedInputStream(new FileInputStream(f));
            byte[] bytes = new byte[(int)(f.length())];
            int c = 0;
            while((c=is.read(bytes)) !=-1)
            {
               for (int i = 0;i < c;i++) 
               {
                  if (bytes[i] == '\n') 
                  {
                     ++noOfLines;
                  }
               }
            }
            String s;
            FileReader in = new FileReader("C:/Users/Amit/workspace/Practice/src/words.txt");
            BufferedReader br = new BufferedReader(in);
            int count=0;
            try
            {                  
               Thread.sleep(2000);
                  
            }
            catch(Exception e)
            {
               System.out.println(e);
            }
               
            bar1.setValue(0);
            while((s= br.readLine()) != null)
            {
            
               try
               {
                  
                  Thread.sleep(1);
                  System.out.println(s);
               }
               catch(Exception e)
               {
                  System.out.println(e);
               }
               count++;
               
               bar1.setValue((count*100/noOfLines));
            }
            try
            {
                  
                  
               Thread.sleep(2000);
                  
            }
            catch(Exception e)
            {
               System.out.println(e);
            }
            
            bar1.setString("Reading Completed");
         }
         catch(IOException e)
         {
            System.out.println("Unable to read file" + e);
         }
      }
   }
   
      /**
       *  Inner class for ProgressImplementation 2
       */
 
   class ProgressBar2 implements Runnable 
   {
      public void run()
      {
         try
         {
            // counts the number of line in the file .. if byte[i] reads new line(\n) it increments the no of lines by 1
            int noOfLines =1;
            File f = new File("C:/Users/Amit/workspace/Practice/src/UnabridgedDictionary.txt");
            BufferedInputStream is = new BufferedInputStream(new FileInputStream(f));
            byte[] bytes = new byte[(int)(f.length())];
            int c = 0;
            while((c=is.read(bytes)) !=-1)
            {
               for (int i=0;i<c;i++) 
               {
                  if (bytes[i] == '\n') 
                  {
                     ++noOfLines;
                  }
               }
            }
            System.out.println(noOfLines);
            String s;
            FileReader in = new FileReader("C:/Users/Amit/workspace/Practice/src/UnabridgedDictionary.txt");
            BufferedReader br = new BufferedReader(in);
            int count=0;
            try
            {
                  
                  
               Thread.sleep(2000);
                  
            }
            catch(Exception e)
            {
               System.out.println(e);
            }
            
            while((s= br.readLine()) != null)
            {
               try
               {
                  Thread.sleep(1);
                  System.out.println(s);
               }
               catch(Exception e)
               {
                  System.out.println(e);
               }
               count++;
               per = (count*100/noOfLines);
               bar2.setValue((count*100/noOfLines));
            }
         }
         catch(IOException e)
         {
            System.out.println("Unable to find file" + e);//changed
         }
      }
   }
   
      /**
       *  Inner class for ClockListener 
       */

   class ClockListener implements ActionListener,Runnable
   {
      public void actionPerformed(ActionEvent ae)
      {
         run();      
      }
      public void run()
      {
         Calendar cal = new GregorianCalendar();
         Date date = cal.getTime();           
         clockLabel.setFont(new Font("",Font.BOLD, 25));//added
         clockLabel.setForeground(Color.RED);//added
         clockLabel.setText(date.toString()); 
      }    
   } 
   
   
   /**
    *  Creates threads and starts. 
    */
   public static void main(String [] args)
   {
      Hw09 my_Hw09 =  new Hw09();
      Hw09.ClockListener tim = my_Hw09.new ClockListener();
      Hw09.ColorModifier cc = my_Hw09.new ColorModifier();
      Hw09.ProgressBar1 pi1 = my_Hw09.new ProgressBar1();
      Hw09.ProgressBar2 pi = my_Hw09.new ProgressBar2();
      Thread my_Thread = new Thread(tim);
      Thread my_Thread1 = new Thread(cc);
      Thread my_Thread2 = new Thread(pi1);
      Thread my_Thread3 = new Thread(pi);
      
      my_Thread.start();
      my_Thread1.start();
      //my_Thread1.stop();
      my_Thread2.start();
      my_Thread3.start();
      Timer timer = new Timer(1000,tim); 
      timer.start();
      while(true)
      {
         Thread t = (Thread)my_Thread2;
         if(!(t.isAlive()))           // if thread2 is not alive it kills the thread3
         {
            try{
               
               
             //  my_Thread1.stop(); // changed
              // my_Thread3.stop(); // changed
               Hw09.bar2.setString("Halted at "+per+"%");
            }
            catch(Exception e)
            {
               System.out.println(e);
            }
         }         
      }
   }
}