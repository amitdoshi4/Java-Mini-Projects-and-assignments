// original from: http://rosettacode.org/wiki/Mandelbrot_set#Java
// modified for color

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

 
public class MandelBrot2 extends JFrame {
 
    private final int MAX = 5000;
    private final int LENGTH   = 800;
    private final double ZOOM  = 1000;
    private final double ZOOM2  = 1000;
    private BufferedImage I;
    public Image I1;
    private double zx, zy, cX, cY, tmp;
    private int[] colors = new int[MAX];
 
    public MandelBrot2() {
        super("Mandelbrot Set2");
	
	initColors();
        setBounds(100, 100, LENGTH, LENGTH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void createSet()	{
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                zx = zy = 0;
                cX = (x - LENGTH) / ZOOM;
                cY = (y - LENGTH) / ZOOM;
                int iter = 0;
                while ( (zx * zx + zy * zy < 4 ) && ( iter < MAX - 1 ) ) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter++;
                }
		if ( iter > 0 )
			I.setRGB(x, y, colors[iter]);
		else
			I.setRGB(x, y, iter | (iter << 8));
		//repaint();
		I1 =  I.getScaledInstance(800, 800, Image.SCALE_FAST);
            }
        }
        repaint();
    }
    
    public void createSet(int startX, int startY, int endX, int endY)	{
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        System.out.println("here");
        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                zx = zy = 0;
                cX = (x - LENGTH) / ZOOM2;
                cY = (y - LENGTH) / ZOOM2;
                int iter = 0;
                while ( (zx * zx + zy * zy < 4 ) && ( iter < MAX - 1 ) ) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter++;
                }
		if ( iter > 0 )
			I.setRGB(x, y, colors[iter]);
		else
			I.setRGB(x, y, iter | (iter << 8));
		//repaint();
		I1 =  I.getScaledInstance(800, 800, Image.SCALE_FAST);
            }
        }
        //I1 =  I.getScaledInstance(800, 800, Image.SCALE_FAST);
        repaint();
    }
    public void initColors() {
        for (int index = 0; index < MAX; index++) {
            colors[index] = Color.HSBtoRGB(index/256f, 1, index/(index+8f));
        }
    }
 
    @Override
    public void paint(Graphics g) {
    	System.out.println("hehe");
        g.drawImage(I1, 0, 0,this); 
    }
 
    public static void main(String[] args) {
        Mandelbrot aMandelbrot = new Mandelbrot();
	aMandelbrot.setVisible(true);
	aMandelbrot.createSet();
    }
}