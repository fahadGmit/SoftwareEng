package editor;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class Main {
	
	/**
	 * @param args
	 * @throws IOException 
	 */

	
	public static void main(String[] a) {
	    JFrame f = new JFrame("Gift Editor");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JTabbedPane jtp = new JTabbedPane();
	    jtp.addTab("Multiiple Choiese",new Multiiple());
	    jtp.addTab("Missing Word",new Missing_Word());
	    jtp.addTab("Short Answer", new Shortanswer());
	    jtp.addTab("Matching", new Matching());
	    jtp.addTab("True-False", new TrueFalseQ());
	    jtp.addTab("Essay", new Essay());
	    
	    f.add(jtp);
	    f.pack();
	    f.setSize(1000, 600);
	    f.setVisible(true);
	    
	  }

	



}
