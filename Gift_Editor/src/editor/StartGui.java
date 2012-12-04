package editor;

import javax.swing.*;
import javax.swing.SwingUtilities;

public class StartGui extends JPanel {

	  public void init() {
	    try {
	      SwingUtilities.invokeAndWait(new Runnable() {
	        public void run() {
	          makeGUI();
	        }
	      });
	    } catch (Exception exc) {
	      System.out.println("Can't create because of " + exc);
	    }
	  }

	  public void makeGUI() {

	    JTabbedPane jtp = new JTabbedPane();
//	    jtp.addTab("Matching", new Matching());
//	    jtp.addTab("True-False", new TrueFalseQ());
	    jtp.add("Multiiple Choiese",new Multiiple());
	    add(jtp);
	  }
	}
