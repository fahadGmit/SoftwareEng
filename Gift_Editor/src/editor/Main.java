package editor;



import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Main {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		// new Gui();
////		new TrueFalseQ();
////		new Multiiple();
//		new Matching();
////		new AddComponentOnJFrameAtRuntime();
//
//	}
	
	public static void main(String[] a) throws IOException {
	    JFrame f = new JFrame("Gift Editor");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JTabbedPane jtp = new JTabbedPane();
	    jtp.addTab("Matching", new Matching());
	    jtp.addTab("True-False", new TrueFalseQ());
	    jtp.addTab("Multiiple Choiese",new Multiiple());
	    f.add(jtp);
	    f.pack();
	    f.setSize(1000, 600);
	    f.setVisible(true);
	    
	  }

	



}
