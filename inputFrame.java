import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class inputFrame extends Frame implements ActionListener{
	JTextField z01, z02, z03, z04, z11, z12, z13, z14, z21, z22, z23, z24,
		   z31, z32, z33, z34, z41, z42, z43, z44, z51, z52, z53, z54,
		   z61, z62, z63, z64, z71, z72, z73, z74, z81, z82, z83, z84,
		   z91, z92, z93, z94, za1, za2, za3, za4, zb1, zb2, zb3, zb4,
                   zc1, zc2, zc3, zc4;
	JRadioButton P1, P2, P3, P4, P5;
        JRadioButton s1, s2, s3, s4, s5;
	String process;
	frameData fd;
	GUI changed;
        String spd;

    	static JFrame frame = new JFrame("INPUT");

    	public static void setupframe() {
        	frame.setSize(400,500);
        	frame.setVisible(true);

		frame.getContentPane().setLayout (new BorderLayout(1,1));

	        WindowListener l = new WindowAdapter() {
        	    public void windowClosing(WindowEvent e) {frame.dispose();}
        	};

		frame.addWindowListener(l);
    	}

	public inputFrame(driver parent) {
		changed = new GUI();
		changed.addObserver((java.util.Observer)parent);

		String P1String = "Process 0";
		String P2String = "Process 1";
		String P3String = "Process 2";
		String P4String = "Process 3";
		String P5String = "Process 4";

		Insets i = new Insets(0,0,0,0);
		GridBagConstraints gbc;
		GridBagLayout gbl = new GridBagLayout();
		setupframe();

 	    	JPanel p1 = new JPanel();
 	    	p1.setBorder(BorderFactory.createEmptyBorder(1, 12, 1, 12));
		p1.setLayout ( gbl);
		JLabel y = new JLabel ("    Max                        ");
		JLabel y0 = new JLabel ("                       Allocated");
		gbc = new GridBagConstraints (0, 0, 1, 1, 0.0, 0.0,
                  GridBagConstraints.CENTER, GridBagConstraints.NONE, i, 0, 0);
//		gbl.setConstraints(y, gbc);
		p1.add (y, gbc);
		gbc = new GridBagConstraints (1, 0, 1, 1, 0.0, 0.0,
                  GridBagConstraints.CENTER, GridBagConstraints.NONE, i, 0, 0);
//		gbl.setConstraints(y0, gbc);
		p1.add (y0, gbc);


	      	JPanel p2 = new JPanel();
		p2.setLayout (new BoxLayout (p2, BoxLayout.X_AXIS));
		JLabel x = new JLabel
                  ("      A            B            C            D   ",
                    JLabel.CENTER);
		JLabel x0 = new JLabel
                  ("            A             B             C            D  ",
                    JLabel.CENTER);
		p2.add (x);
		p2.add (x0);

      		JPanel p3 = new JPanel();
      		p3.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 10));
		p3.setLayout (new BoxLayout (p3, BoxLayout.X_AXIS));
		JLabel z0 = new JLabel ("P0", JLabel.CENTER);
		z01 = new JTextField ("5",1);
		z02 = new JTextField ("1",1);
		z03 = new JTextField ("1",1);
		z04 = new JTextField ("1",1);

		JLabel z1 = new JLabel ("P0", JLabel.CENTER);
		z11 = new JTextField ("3",1);
		z12 = new JTextField ("0",1);
		z13 = new JTextField ("1",1);
		z14 = new JTextField ("1",1);


		p3.add (z0);
		p3.add (z01);p3.add (z02);p3.add (z03);p3.add (z04);
		p3.add (z1);
		p3.add (z11);p3.add (z12);p3.add (z13);p3.add (z14);


      		JPanel p4 = new JPanel();
      		p4.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 10));
		p4.setLayout (new BoxLayout (p4, BoxLayout.X_AXIS));
		JLabel z4 = new JLabel ("P1", JLabel.CENTER);
		z41 = new JTextField ("0",1);
		z42 = new JTextField ("2",1);
		z43 = new JTextField ("2",1);
		z44 = new JTextField ("2",1);

		JLabel z5 = new JLabel ("P1", JLabel.CENTER);
		z51 = new JTextField ("0",1);
		z52 = new JTextField ("0",1);
		z53 = new JTextField ("0",1);
		z54 = new JTextField ("0",1);

		p4.add (z4);p4.add (z41);p4.add (z42);p4.add (z43);p4.add (z44);
		p4.add (z5);p4.add (z51);p4.add (z52);p4.add (z53);p4.add (z54);


      		JPanel p5 = new JPanel();
      		p5.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 10));
		p5.setLayout (new BoxLayout (p5, BoxLayout.X_AXIS));
		JLabel z6 = new JLabel ("P2", JLabel.CENTER);
		z61 = new JTextField ("4",1);
		z62 = new JTextField ("2",1);
		z63 = new JTextField ("1",1);
		z64 = new JTextField ("0",1);

		JLabel z7 = new JLabel ("P2", JLabel.CENTER);
		z71 = new JTextField ("1",1);
		z72 = new JTextField ("1",1);
		z73 = new JTextField ("1",1);
		z74 = new JTextField ("0",1);

		p5.add (z6);p5.add (z61);p5.add (z62);p5.add (z63);p5.add (z64);
		p5.add (z7);p5.add (z71);p5.add (z72);p5.add (z73);p5.add (z74);


      		JPanel p6 = new JPanel();
      		p6.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 10));
		p6.setLayout (new BoxLayout (p6, BoxLayout.X_AXIS));
		JLabel z8 = new JLabel ("P3", JLabel.CENTER);
		z81 = new JTextField ("1",1);
		z82 = new JTextField ("1",1);
		z83 = new JTextField ("1",1);
		z84 = new JTextField ("1",1);

		JLabel z9 = new JLabel ("P3", JLabel.CENTER);
		z91 = new JTextField ("1",1);
		z92 = new JTextField ("1",1);
		z93 = new JTextField ("0",1);
		z94 = new JTextField ("1",1);

		p6.add (z8);p6.add (z81);p6.add (z82);p6.add (z83);p6.add (z84);
		p6.add (z9);p6.add (z91);p6.add (z92);p6.add (z93);p6.add (z94);


      		JPanel p7 = new JPanel();
      		p7.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 10));
		p7.setLayout (new BoxLayout (p7, BoxLayout.X_AXIS));
		JLabel za = new JLabel ("P4", JLabel.CENTER);
		za1 = new JTextField ("2",1);
		za2 = new JTextField ("1",1);
		za3 = new JTextField ("1",1);
		za4 = new JTextField ("1",1);

		JLabel zb = new JLabel ("P4", JLabel.CENTER);
		zb1 = new JTextField ("0",1);
		zb2 = new JTextField ("1",1);
		zb3 = new JTextField ("0",1);
		zb4 = new JTextField ("0",1);

		p7.add (za);p7.add (za1);p7.add (za2);p7.add (za3);p7.add (za4);
		p7.add (zb);p7.add (zb1);p7.add (zb2);p7.add (zb3);p7.add (zb4);


		JPanel p12 = new JPanel();
		p12.setLayout (new BoxLayout (p12, BoxLayout.X_AXIS));
 	    	p12.setBorder(BorderFactory.createEmptyBorder(1, 12, 1, 12));
		JLabel y2 = new JLabel("Available Resource");
		p12.add(y2);

		JPanel p13 = new JPanel();
		p13.setLayout (new BoxLayout (p13, BoxLayout.X_AXIS));
		JLabel x2 = new JLabel
                 ("A             B             C           D");
		p13.add(x2);

 		JPanel p130 = new JPanel();
		p130.setLayout (new BoxLayout (p130, BoxLayout.X_AXIS));
		JLabel x3 = new JLabel
                 ("A             B             C           D");
		p130.add(x3);


		JPanel p14 = new JPanel();
		p14.setLayout (new BoxLayout (p14, BoxLayout.X_AXIS));
 	    	p14.setBorder(BorderFactory.createEmptyBorder(0, 120, 0, 120));
		zc1 = new JTextField ("1",1);
		zc2 = new JTextField ("0",1);
		zc3 = new JTextField ("2",1);
		zc4 = new JTextField ("0",1);
		p14.add (zc1);p14.add (zc2);p14.add (zc3);p14.add (zc4);


                JPanel p20 = new JPanel();
                p20.setLayout(new BoxLayout (p20, BoxLayout.X_AXIS ));
 	    	p20.setBorder(BorderFactory.createEmptyBorder(1, 12, 1, 12));
                JLabel req = new JLabel("User Resource Request");
                p20.add(req);


                JPanel p21 = new JPanel();
                p21.setLayout(new BoxLayout (p21, BoxLayout.X_AXIS ));
 	    	p21.setBorder(BorderFactory.createEmptyBorder(0, 120, 5, 120));
		z31 = new JTextField ("0",1);
		z32 = new JTextField ("0",1);
		z33 = new JTextField ("0",1);
		z34 = new JTextField ("0",1);
		p21.add (z31);p21.add (z32);p21.add (z33);p21.add (z34);

                JPanel p15 = new JPanel();
                p15.setLayout(new BoxLayout (p15, BoxLayout.X_AXIS ));
 	    	p15.setBorder(BorderFactory.createEmptyBorder(1, 12, 1, 12));
                JLabel speed = new JLabel("Animation speed");
                p15.add(speed);


                JPanel p11 = new JPanel();
                p11.setLayout(new BoxLayout (p11, BoxLayout.X_AXIS ));
 	    	p11.setBorder(BorderFactory.createEmptyBorder(1, 0, 1, 0));
		s1 = new JRadioButton("Slowest");
		s2 = new JRadioButton("Slower");
		s3 = new JRadioButton("Medium");
		s3.setMnemonic('b');
		s3.setActionCommand("Medium");
		s3.setSelected(true);
		s4 = new JRadioButton("Faster");
		s5 = new JRadioButton("Fastest");
		ButtonGroup speed_group = new ButtonGroup();
		speed_group.add(s1);
	        speed_group.add(s2);
		speed_group.add(s3);
		speed_group.add(s4);
		speed_group.add(s5);
		p11.add (s1);
		p11.add (s2);
		p11.add (s3);
		p11.add (s4);
		p11.add (s5);
		s1.addActionListener(this);
		s2.addActionListener(this);
		s3.addActionListener(this);
		s4.addActionListener(this);
		s5.addActionListener(this);


		JPanel p8 = new JPanel();
		p8.setLayout (new BoxLayout (p8, BoxLayout.X_AXIS));
 	    	p8.setBorder(BorderFactory.createEmptyBorder(1, 0, 1, 0));
		JButton b1 = new JButton ("Update");
//		JButton b2 = new JButton ("Clear");
		p8.add(b1);
//		p8.add(b2);


		JPanel p9 = new JPanel();
		p9.setLayout (new BoxLayout (p9, BoxLayout.X_AXIS));
 	    	p9.setBorder(BorderFactory.createEmptyBorder(1, 0, 1, 0));
		JButton b3 = new JButton ("Start");
		JButton b4 = new JButton ("Stop");
		JButton b5 = new JButton ("Resume");
		JButton b6 = new JButton ("Quit");
		p9.add (b3);
		p9.add (b4);
		p9.add (b5);
		p9.add (b6);
		b1.addActionListener(this);
//		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);

		JPanel p10 = new JPanel();
		p10.setLayout (new BoxLayout (p10, BoxLayout.X_AXIS));
		P1 = new JRadioButton(P1String);
		P1.setMnemonic('b');
		P1.setActionCommand(P1String);
		P1.setSelected(true);
		P2 = new JRadioButton(P2String);
		P3 = new JRadioButton(P3String);
		P4 = new JRadioButton(P4String);
		P5 = new JRadioButton(P5String);
		ButtonGroup proc_group = new ButtonGroup();
		proc_group.add(P1);
		proc_group.add(P2);
		proc_group.add(P3);
		proc_group.add(P4);
		proc_group.add(P5);
		p10.add (P1);
		p10.add (P2);
		p10.add (P3);
		p10.add (P4);
		p10.add (P5);
		P1.addActionListener(this);
		P2.addActionListener(this);
		P3.addActionListener(this);
		P4.addActionListener(this);
		P5.addActionListener(this);

  		JPanel p30 = new JPanel();
		p30.setLayout (new BoxLayout (p30, BoxLayout.X_AXIS));
 	    	p30.setBorder(BorderFactory.createEmptyBorder(1, 12, 1, 12));
		JLabel y1 = new JLabel("Total Number of Resources");
		p30.add(y1);

		JPanel p31 = new JPanel();
		p31.setLayout (new BoxLayout (p31, BoxLayout.X_AXIS));
		JLabel x1 = new JLabel
                  ("A            B             C            D");
		p31.add(x1);

		JPanel p32 = new JPanel();
		p32.setLayout (new BoxLayout (p32, BoxLayout.X_AXIS));
 	    	p32.setBorder(BorderFactory.createEmptyBorder(0, 120, 0, 120));
		z21 = new JTextField ("6",1);
		z22 = new JTextField ("3",1);
		z23 = new JTextField ("4",1);
		z24 = new JTextField ("2",1);
		p32.add (z21);p32.add (z22);p32.add (z23);p32.add (z24);


	    	Container c = frame.getContentPane();
		c.setLayout (new BoxLayout (c, BoxLayout.Y_AXIS));
                c.add(p30); c.add(p31); c.add(p32);
      		c.add(p1); c.add(p2); c.add(p3); c.add(p4); c.add(p5); c.add(p6); c.add(p7);
		c.add(p12); c.add(p130); c.add(p14);
                c.add(p20); c.add(p13); c.add(p21); c.add(p10);
                c.add(p15); c.add(p11);
		c.add(p8); c.add(p9);

		frame.show();
	}

   	public void actionPerformed (ActionEvent evt) {
          String cmd = evt.getActionCommand();
	  System.out.println (cmd);

	  if (cmd == "Process 1" || cmd == "Process 2" ||
            cmd == "Process 3"||cmd == "Process 4" || cmd == "Process 5")
	      process = cmd;

          else if (cmd == "Slowest" || cmd == "Slower" || cmd == "Medium"
            || cmd == "Faster" || cmd == "Fastest")
              spd = cmd;

	  else if (cmd == "Update") {
	    fd = new frameData(Integer.parseInt(z01.getText()),
            Integer.parseInt(z02.getText()), Integer.parseInt(z03.getText()),
            Integer.parseInt(z04.getText()), Integer.parseInt(z11.getText()),
	    Integer.parseInt(z12.getText()), Integer.parseInt(z13.getText()),
            Integer.parseInt(z14.getText()), Integer.parseInt(z21.getText()),
            Integer.parseInt(z22.getText()), Integer.parseInt(z23.getText()),
	    Integer.parseInt(z24.getText()), Integer.parseInt(z31.getText()),
            Integer.parseInt(z32.getText()), Integer.parseInt(z33.getText()),
            Integer.parseInt(z34.getText()), Integer.parseInt(z41.getText()),
	    Integer.parseInt(z42.getText()), Integer.parseInt(z43.getText()),
            Integer.parseInt(z44.getText()), Integer.parseInt(z51.getText()),
            Integer.parseInt(z52.getText()), Integer.parseInt(z53.getText()),
	    Integer.parseInt(z54.getText()), Integer.parseInt(z61.getText()),
            Integer.parseInt(z62.getText()), Integer.parseInt(z63.getText()),
            Integer.parseInt(z64.getText()), Integer.parseInt(z71.getText()),
	    Integer.parseInt(z72.getText()), Integer.parseInt(z73.getText()),
            Integer.parseInt(z74.getText()), Integer.parseInt(z81.getText()),
            Integer.parseInt(z82.getText()), Integer.parseInt(z83.getText()),
	    Integer.parseInt(z84.getText()), Integer.parseInt(z91.getText()),
            Integer.parseInt(z92.getText()), Integer.parseInt(z93.getText()),
            Integer.parseInt(z94.getText()), Integer.parseInt(za1.getText()),
	    Integer.parseInt(za2.getText()), Integer.parseInt(za3.getText()),
            Integer.parseInt(za4.getText()), Integer.parseInt(zb1.getText()),
            Integer.parseInt(zb2.getText()), Integer.parseInt(zb3.getText()),
	    Integer.parseInt(zb4.getText()), process, spd);

	    changed.input(fd);
	  }

	  else if (cmd == "Start" || cmd == "Stop" || cmd == "Resume"
            || cmd == "Quit")
	      changed.input(cmd);
	}

	public void updateInputFrame(int [][]alloc, int[]avail, int[]req) {
		z11.setText(Integer.toString(alloc[0][0]));
		z12.setText(Integer.toString(alloc[0][1]));
		z13.setText(Integer.toString(alloc[0][2]));
		z14.setText(Integer.toString(alloc[0][3]));
	}
}