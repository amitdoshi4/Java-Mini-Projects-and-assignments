

import javax.swing.*;          //This is the final package name.
import java.awt.*;
import java.awt.event.*;

/**
 * This class implements the mouse listener
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 11/17/2014
 * 
 */
public class MyMouseListener implements MouseListener {
	int startX;
	int startY;
	int endX;
	int endY;

	/**
	* MousePressed 
	* This is the mouse pressed event
	*
	* @param    e MouseEvent 
	*/	
public void mousePressed(MouseEvent e) {
	Point p = e.getPoint();
	startX = p.x;
	startY =p.y;
	System.out.println("mousePressed:");
	System.out.println("\te.getPoint(): " + e.getPoint() );
	System.out.println("\te.getClickCount(): "
		+ e.getClickCount() );
}

/**
* MouseReleased
* This is the mouse released event
*
* @param    e MouseEvent 
*/	
public void mouseReleased(MouseEvent e) {
	System.out.println("mouseReleases:");
	Point p = e.getPoint();	
	endX = p.x;
	endY = p.y;
	System.out.println("\t" + e );
	int diff=Math.abs(startX-endX);
	if(startX>endX)
	{
		int temp;
		temp=startX;
		startX=endX;
		endX=temp;
	}
	if(startY>endY)
	{
		int temp;
		temp=startY;
		startY=endY;
		endY=temp;
	}
	endY=startY+diff;
	Mandelbrot aMandelbrot = new Mandelbrot();
	aMandelbrot.setVisible(true);
	aMandelbrot.createSet(startX, startY, endX, endY, diff);
}

/**
* MouseEntered 
* 
*
* @param    e MouseEvent 
*/	
public void mouseEntered(MouseEvent e) {
	//System.out.println("mouseEntered:");
	//System.out.println("\t" + e );
}
/**
* MouseExited
*
* @param    e MouseEvent 
*/	
public void mouseExited(MouseEvent e) {
	//System.out.println("mouseExited:");
	//System.out.println("\t" + e );
}
/**
* MouseClicked
*
* @param    e MouseEvent 
*/	
public void mouseClicked(MouseEvent e) {
	//System.out.println("mouseClicked:");
	 //System.out.println("\t" + e );
}
}