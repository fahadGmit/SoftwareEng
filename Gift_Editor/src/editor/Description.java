package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

public class Description extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JTextField jtfTitle;
	private JTextPane jtfQ;
	public static PrintWriter out;

	public Description() {

		setLayout(new MigLayout("", "[right][grow]",
				"[]10[252.00,grow,top][grow][]"));


		JLabel lblQuistion = new JLabel("Description");
		
		add(lblQuistion, "cell 0 1,alignx right");

		jtfQ = new JTextPane();
		add(jtfQ, "cell 1 1,grow");
		
		JButton jbtcancel = new JButton("Clear");
		add(jbtcancel, "cell 1 3,alignx right");
		
		jbtcancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				jtfTitle.setText(null);
				jtfQ.setText(null);
				
			}
		});
		

		ImageIcon saveadd = new ImageIcon("images/saveadd.png");
		JButton btnAddAnother = new JButton(
				saveadd);
		btnAddAnother.setToolTipText("Save and Add another Matching Question");
		add(btnAddAnother, "cell 1 3,alignx right");
		
		btnAddAnother.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Gift_Gui.selctedFile == null) {
					JOptionPane.showMessageDialog(null, "Create New File");

				} else {
				
				try {
					out = new PrintWriter(new BufferedWriter(new FileWriter(
							Gift_Gui.selctedFile, true)));
					
					String qusetionQ = jtfQ.getText();
					
					out.append( qusetionQ + "\n");
					out.close();
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
		});

	}
}
