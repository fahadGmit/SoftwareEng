package editor;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;

public class Fill_in_the_blank2 extends JPanel {

	
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public Fill_in_the_blank2() {
		
		setLayout(new MigLayout("debug", "[right][grow]", "[]10[252.00,grow,top][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Quistion Titil (optional) ");
		add(lblNewLabel, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblQuistion = new JLabel("Quistion");
		add(lblQuistion, "cell 0 1,alignx right");
		
		JTextPane textArea = new JTextPane();
		add(textArea, "cell 1 1,grow");
		
		
		
		JButton btnNewButton = new JButton("Save and Add a other Question");
		add(btnNewButton, "cell 1 3,alignx right");
		
		
	}

}
