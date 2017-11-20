import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.lang.Thread.*;
import java.util.*;
import java.awt.Color;
import javax.swing.UIManager;


public class Simulator extends JFrame{

	JButton Scheduling;
	JButton Disk;
	JButton Page;
	JButton Dine;
    JButton Bank;

	Simulator(){
		Container screen = getContentPane();
		screen.setLayout(null);

		this.Scheduling = new JButton("Process Scheduling algorithms");
		this.Disk = new JButton("Disk Scheduling Algorithms");
		this.Page = new JButton("Page Replacement");
		this.Dine = new JButton("Dining Philosophers");
		this.Bank = new JButton("Bankers Problem");


		screen.add(this.Scheduling);
		screen.add(this.Disk);
		screen.add(this.Page);
		screen.add(this.Dine);
		screen.add(this.Bank);

		this.Scheduling.setBounds(100,20,250,50);
		this.Disk.setBounds(100,100,250,50);
		this.Page.setBounds(100,180,250,50);
		this.Dine.setBounds(100,260,250,50);
		this.Bank.setBounds(100,340,250,50);

		setSize(450,450);
		setVisible(true);
		ps_Click();
		ds_Click();
		pr_Click();
		dp_Click();
		bank_Click();

	}
	private void ps_Click(){
        Scheduling.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent evento) {
                //MainWindow mw = new MainWindow();
				MainWindow.main(new String[0]);
			}
       });
	}
	private void ds_Click(){
        Disk.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent evento) {
                  MainApp.Callme();
            }
       });
	}

	private void pr_Click(){
        Page.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent evento) {
            	FIFO_Sim.main(new String[0]);
            }
       });
	}

	private void dp_Click(){
        Dine.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent evento) {
                   try{Dining.Callme();}
            catch(IOException ioe){
            	System.out.println("Error");
            	}
            }
       });
	}

	private void bank_Click(){
        Bank.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent evento) {
            try{driver.Callme();}
            catch(IOException ioe){
            	System.out.println("Error");
            	}
        	}
       });
	}

	 public static void main(String[] args) {
		Simulator sim = new Simulator();
		sim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
