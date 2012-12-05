package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

public class Matching extends JPanel{
	private JTextField tfTitle;
	private JTextPane jtpQ;
	private JTextField jtfAq;
	private JTextField jtfAn;
	private JTextField jtfBq;
	private JTextField jtfBn;
	private JTextField jtfCq;
	private JTextField jtfCn;
	public static PrintWriter out;

	public Matching() {

		
		setLayout(new MigLayout("",
				"[172.00][-18.00][grow,fill][][][][149.00,grow,fill][]",
				"[][grow][][][][][][][][][][][][]"));

		JLabel lblNewLabel_4 = new JLabel("Question Title (optional)");
		add(lblNewLabel_4, "cell 0 0,alignx right");
		JLabel lblQ = new JLabel("Question");
		add(lblQ, "cell 0 1,alignx right ,top");
		JLabel lblA_1 = new JLabel("A");
		add(lblA_1, "cell 1 3,alignx trailing");
		JLabel lblNewLabel_5 = new JLabel("A");
		add(lblNewLabel_5, "cell 4 3");
		JLabel lblNewLabel_6 = new JLabel("B");
		add(lblNewLabel_6, "cell 1 5,alignx trailing");
		JLabel lblB = new JLabel("B");
		add(lblB, "cell 4 5");
		JLabel lblC = new JLabel("C");
		add(lblC, "cell 1 7,alignx trailing");
		JLabel lblC_1 = new JLabel("C");
		add(lblC_1, "cell 4 7");

		tfTitle = new JTextField();
		add(tfTitle, "cell 2 0,growx,span");
		tfTitle.setColumns(10);
		jtpQ = new JTextPane();
		add(jtpQ, "cell 2 1,span,grow");
		jtfAq = new JTextField();
		add(jtfAq, "cell 2 3,alignx left");
		jtfAq.setColumns(10);
		jtfAn = new JTextField();
		add(jtfAn, "cell 6 3,growx");
		jtfAn.setColumns(10);
		jtfBq = new JTextField();
		add(jtfBq, "cell 2 5,growx");
		jtfBq.setColumns(10);
		jtfBn = new JTextField();
		add(jtfBn, "cell 6 5,growx");
		jtfBn.setColumns(10);
		jtfCq = new JTextField();
		add(jtfCq, "cell 2 7,growx");
		jtfCq.setColumns(10);
		jtfCn = new JTextField();
		add(jtfCn, "cell 6 7,growx");
		jtfCn.setColumns(10);

		// JButton btnNewButton_3 = new JButton("Add Q&A");
		// panel_2.add(btnNewButton_3, "cell 0 2,alignx left");
		// JButton btnNewButton_4 = new JButton("Delete Selected");
		// panel_2.add(btnNewButton_4, "cell 7 8");
		// JButton btnSaveToTest = new JButton("Save to test file");
		// panel_2.add(btnSaveToTest, "cell 0 10");
		JButton btnAddAnother = new JButton(
				"Save and Add another Matching Question");
		add(btnAddAnother, "cell 0 13 3 1,alignx center,span");

		// JCheckBox chckbxDelete_1 = new JCheckBox("Delete");
		// panel_2.add(chckbxDelete_1, "cell 7 2");
		// JCheckBox chckbxDelete_2 = new JCheckBox("Delete");
		// panel_2.add(chckbxDelete_2, "cell 7 4");
		// JCheckBox chckbxDelete_3 = new JCheckBox("Delete");
		// panel_2.add(chckbxDelete_3, "cell 7 6");

		btnAddAnother.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String qusetionTitle = tfTitle.getText();
				String qusetionQ = jtpQ.getText();

				String matchA = jtfAq.getText();
				String answerA = jtfAn.getText();
				String matchB = jtfBq.getText();
				String answerB = jtfBn.getText();

				String matchC = jtfCq.getText();
				String answerC = jtfCn.getText();

				try {
					out = new PrintWriter(new BufferedWriter(new FileWriter(
							"ExamQ.txt", true)));

					out.append("::" + qusetionTitle + "::" + qusetionQ + "{"
							+ "\n=" + matchA + " -> " + answerA + "\n="
							+ matchB + " -> " + answerB + "\n=" + matchC
							+ " -> " + answerC + "\n}" + "\n");
					out.close();

					tfTitle.setText("");
					jtpQ.setText("");

					jtfAq.setText("");
					jtfAn.setText("");
					jtfBq.setText("");
					jtfBn.setText("");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

}
