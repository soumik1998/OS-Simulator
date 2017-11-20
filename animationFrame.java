import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;


public class animationFrame extends Frame {
	int avail[] = new int[4];
	int alloc[][] = new int[5][4];

   	public animationFrame (int[][] al, int[] av) {
   		alloc = al;
		avail = av;
		setSize(600, 290);
		show();
  	}

	public void paint (Graphics g){
	      Graphics2D g2d = ( Graphics2D ) g;

		g2d.setPaint(Color.black);
		g2d.drawString("A", 70, 44);
		g2d.drawString("B", 220, 44);
		g2d.drawString("C", 370, 44);
		g2d.drawString("D", 520, 44);
		g2d.drawRect(20,50,100,20);
		g2d.drawRect(170,50,100,20);
		g2d.drawRect(320,50,100,20);
		g2d.drawRect(470,50,100,20);

		for (int i=0; i<4; i++) {
			for (int j=1; j<=avail[i]; j++) {
				if (i==0) g2d.setPaint(Color.red);
				else if (i==1) g2d.setPaint(Color.green);
				else if (i==2) g2d.setPaint(Color.cyan);
				else g2d.setPaint(Color.blue);
				g2d.fillRect(((21+i*150)+11*(j-1)), 51, 10, 19);
			}
		}

		for (int j=0; j<5; j++){
			g2d.setPaint(Color.black);
			g2d.drawRect(15+115*j, 100, 100, 150);
		}
		g2d.drawString("Process 0", 38, 270);
		g2d.drawString("Process 1", 153, 270);
		g2d.drawString("Process 2", 268, 270);
		g2d.drawString("Process 3", 383, 270);
		g2d.drawString("Process 4", 498, 270);

		for (int j=0; j<5; j++) {
			g2d.setPaint(Color.red);
			for (int k=1; k<=alloc[j][0]; k++)
				g2d.fillRect((16+115*j+11*(k-1)), 105, 10, 19);
		}

		for (int j=0; j<5; j++) {
			g2d.setPaint(Color.green);
			for (int k=1; k<=alloc[j][1]; k++)
				g2d.fillRect((16+115*j+11*(k-1)), 145, 10, 19);
		}

		for (int j=0; j<5; j++) {
			g2d.setPaint(Color.cyan);
			for (int k=1; k<=alloc[j][2]; k++)
				g2d.fillRect((16+115*j+11*(k-1)), 185, 10, 19);
		}

		for (int j=0; j<5; j++) {
			g2d.setPaint(Color.blue);
			for (int k=1; k<=alloc[j][3]; k++)
				g2d.fillRect((16+115*j+11*(k-1)), 225, 10, 19);
		}
   	}

}