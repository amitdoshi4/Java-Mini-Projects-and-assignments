
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
public class DrawIt extends JFrame implements Runnable{
	private int x,y;
    private final static int MAX = 5000;
    private final int LENGTH   = 800;
    private final double ZOOM  = 1000;
    private BufferedImage I;
    private double zx, zy, cX, cY, tmp;
    int[] colors = new int[MAX];
    static int number = 0;
    String info;
    
	public DrawIt(int x1,int y1, BufferedImage I, int[] colors2, String info)
	{
		x=x1;
		y=y1;
		this.I=I;
		this.colors=colors2;
		this.info=info;
	}
	public void run()
	{
		  zx = zy = 0;
          cX = (x - LENGTH) / ZOOM;			//centers the picture
          cY = (y - LENGTH) / ZOOM;
          int iter = 0;
          System.out.println(info);
          while ( (zx * zx + zy * zy < 4 ) && ( iter < MAX - 1 ) ) {
              tmp = zx * zx - zy * zy + cX;
              zy = 2.0 * zx * zy + cY;                   //put in run
              zx = tmp;
              iter++;
          }
	if ( iter > 0 )
		I.setRGB(x, y, colors[iter]);
	else
		I.setRGB(x, y, iter | (iter << 8));
    repaint();
	}
	  @Override
	    public void paint(Graphics g) {
	        g.drawImage(I, 0, 0, this);
	    }
}
