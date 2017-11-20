import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JApplet;
import java.util.Observer;
import java.util.Observable;


public class driver extends JApplet implements Observer {

	int request[] = new int[4];
	int Max[][] = new int[5][4];
	int Allocation [][] = new int[5][4];
	int Available[] = new int[4];
	int process_chosen;
        int animation_speed;

	inputFrame inpf;
	animationFrame anif;
        status sta;

	banker b;

	public void init () {
		inpf = new inputFrame(this);
//		inpf.pack();
		anif = new animationFrame(Allocation, Available);
                sta = new status();
//              sta.pack();
		b = null;

	}

	public static void Callme()throws IOException{
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("appletviewer banker.html");
	}

	public void update (Observable obj, Object arg) {
		if (arg instanceof String) {
		  if (((String)arg).equals("Start"))
			b = new banker (Max, Allocation, Available, request,
                          process_chosen, inpf, anif, sta, animation_speed);
		  else if (((String)arg).equals("Stop") && b!=null) {
			b.thread.suspend();
			System.out.println ("thread paused...");
                        sta.upStatus("thread paused...") ;
		  }
		  else if (((String)arg).equals("Resume") && b!=null) {
			b.thread.resume();
                        sta.upStatus("thread resumed...") ;
		  }
                  else if (((String)arg).equals("Quit")) {
			if (b!=null)
			b.thread.stop();
			anif.dispose();
			sta.upStatus("Quitting simulation.... ");
		  }
		}
		else if (arg instanceof frameData) {
			getArrays((frameData)arg);
			System.out.println("process chosen is "+process_chosen);
                        sta.upStatus("User inputs updated... Initial request"
                          +" by process "+process_chosen+" for "
                          +Integer.toString(request[0]) + "A "
                          +Integer.toString(request[1]) + "B "
                          +Integer.toString(request[2]) + "C "
                          +Integer.toString(request[3]) + "D");
		}
	}

	private void getArrays(frameData in) {
		request[0] = in.getR0();
		request[1] = in.getR1();
		request[2] = in.getR2();
		request[3] = in.getR3();
		Available[0] = in.getV0();
		Available[1] = in.getV1();
		Available[2] = in.getV2();
		Available[3] = in.getV3();
		Max[0][0] = in.getM00();
		Max[0][1] = in.getM01();
		Max[0][2] = in.getM02();
		Max[0][3] = in.getM03();
		Max[1][0] = in.getM10();
		Max[1][1] = in.getM11();
		Max[1][2] = in.getM12();
		Max[1][3] = in.getM13();
		Max[2][0] = in.getM20();
		Max[2][1] = in.getM21();
		Max[2][2] = in.getM22();
		Max[2][3] = in.getM23();
		Max[3][0] = in.getM30();
		Max[3][1] = in.getM31();
		Max[3][2] = in.getM32();
		Max[3][3] = in.getM33();
		Max[4][0] = in.getM40();
		Max[4][1] = in.getM41();
		Max[4][2] = in.getM42();
		Max[4][3] = in.getM43();
		Allocation[0][0] = in.getA00();
		Allocation[0][1] = in.getA01();
		Allocation[0][2] = in.getA02();
		Allocation[0][3] = in.getA03();
		Allocation[1][0] = in.getA10();
		Allocation[1][1] = in.getA11();
		Allocation[1][2] = in.getA12();
		Allocation[1][3] = in.getA13();
		Allocation[2][0] = in.getA20();
		Allocation[2][1] = in.getA21();
		Allocation[2][2] = in.getA22();
		Allocation[2][3] = in.getA23();
		Allocation[3][0] = in.getA30();
		Allocation[3][1] = in.getA31();
		Allocation[3][2] = in.getA32();
		Allocation[3][3] = in.getA33();
		Allocation[4][0] = in.getA40();
		Allocation[4][1] = in.getA41();
		Allocation[4][2] = in.getA42();
		Allocation[4][3] = in.getA43();
		process_chosen = in.getProcess();
                animation_speed = in.getSpeed();
	}

}