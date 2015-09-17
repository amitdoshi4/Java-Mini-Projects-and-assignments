

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;



public class Mandelbrot extends JFrame{//{,Thread {
 
    private final int MAX = 5000;
    private final int LENGTH   = 800;
 //   private final double ZOOM  = 1000;
    private BufferedImage I;
 //   private double zx, zy, cX, cY, tmp;
    private int[] colors = new int[MAX];
    static List<DrawIt> aList = new ArrayList<DrawIt>();
    static Mandelbrot aMandelbrot;
 
    public Mandelbrot() {
        super("Mandelbrot Set");
	
	initColors();
        setBounds(100, 100, LENGTH, LENGTH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void createSet()	{
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
            	
            	String info= ""+x+","+y;
            	
            	new Thread(new DrawIt(x,y,I,aMandelbrot.colors,info)).start();
            	//t.start();
            	//aList.add(t);
            	
            }
        }
        
        Iterator<DrawIt> it = aList.iterator();
        /*while(it.hasNext()){
			try {
				 it.next().join();
			} catch (InterruptedException e) {
			System.out.println("Interrupted!" );
			}*/
       // }
        System.out.println("here");
        //repaint();
    }
    public void initColors() {
        for (int index = 0; index < MAX; index++) {
            colors[index] = Color.HSBtoRGB(index/256f, 1, index/(index+8f));
        }
    }
 
    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }
 
    public static void main(String[] args) {
        aMandelbrot = new Mandelbrot();
		aMandelbrot.setVisible(true);
		aMandelbrot.createSet();
    }


}
