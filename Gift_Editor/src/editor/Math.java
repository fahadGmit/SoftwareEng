package editor;

import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class Math extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	public Math() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setLayout(new MigLayout("", "[84.00][148.00,grow][][82.00,grow][51.00][66.00,grow,fill][67.00][grow][][grow]", "[][grow][]"));
		
		JLabel lblQusitionTitleoptional = new JLabel("Qusition Title (optional)");
		add(lblQusitionTitleoptional, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 1 0 9 1,growx");
		textField.setColumns(10);
		
		JLabel lblQusition = new JLabel("Qusition");
		add(lblQusition, "cell 0 1,alignx right,aligny top");
		
		JTextArea textArea = new JTextArea();
		add(textArea, "cell 1 1 9 1,grow");
		
		JLabel lblNewLabel = new JLabel("Specifed interval end points ?");
		add(lblNewLabel, "flowx,cell 1 2");
		
		JLabel lblAnswre = new JLabel("Answer");
		add(lblAnswre, "cell 2 2,alignx trailing");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		add(chckbxNewCheckBox, "cell 1 2");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 3 2,growx");
		textField_1.setColumns(10);
		
		JLabel lblRange = new JLabel("Range +/-");
		add(lblRange, "cell 4 2,alignx trailing");
		
		JSpinner spinner = new JSpinner();
		add(spinner, "cell 5 2,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Start Point");
		add(lblNewLabel_1, "cell 6 2,alignx trailing");
		
		textField_3 = new JTextField();
		add(textField_3, "cell 7 2,growx");
		textField_3.setColumns(10);
		
		JLabel lblEndPoint = new JLabel("End Point");
		add(lblEndPoint, "cell 8 2,alignx trailing");
		
		textField_4 = new JTextField();
		add(textField_4, "cell 9 2,growx");
		textField_4.setColumns(10);
		
//		setVisible(true);
	}

}
