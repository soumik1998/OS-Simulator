import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class status extends Frame {
	JTextField statusLine;
        JButton b;

     	static JFrame sframe = new JFrame("STATUS");

    	public static void setupframe() {
        	sframe.setSize(600,100);
        	sframe.setVisible(true);

		sframe.getContentPane().setLayout (new BorderLayout(10,7));

	        WindowListener l = new WindowAdapter() {
        	    public void windowClosing(WindowEvent e) {sframe.dispose();}
        	};

		sframe.addWindowListener(l);
    	}

	public status() {
            setupframe();

	    JPanel p = new JPanel();
      	    p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            p.setLayout (new BoxLayout (p, BoxLayout.X_AXIS));
            statusLine = new JTextField
              ("Please make selections in the INPUT window", 500);
            statusLine.setEditable(false);
 	    p.add(statusLine);

            Container c = sframe.getContentPane() ;
            c.setLayout (new BorderLayout(10,7));
            c.add(p);

            sframe.show();
        }

        public void upStatus (String t) {
              statusLine.setText(t);
        }
}