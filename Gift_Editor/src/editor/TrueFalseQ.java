package editor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import editor.Gui.myAction;

public class TrueFalseQ {
	private JFrame frame;
	private JTextField textfildeTitle;
	private JTextPane textpanQ;
	private JButton btnAddAnpther;
	private char answer;
	public static PrintWriter out;

	public TrueFalseQ() throws IOException {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 966, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new MigLayout("", "[grow]", "[][grow]"));

		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[153px][4px][96px][410px][218px]",
				"[28px][169px][29px][29px][29px]"));

		JLabel lblQuestionTitleoptional = new JLabel(
				"Question Title (optional)"); // //true
		panel.add(lblQuestionTitleoptional,
				"cell 0 0,alignx left,aligny center");

		textfildeTitle = new JTextField();
		panel.add(textfildeTitle, "cell 2 0 3 1,growx,aligny top");
		textfildeTitle.setColumns(10);

		JLabel lblQuestion = new JLabel("Question");
		panel.add(lblQuestion, "cell 0 1,alignx right,aligny top");

		textpanQ = new JTextPane();
		panel.add(textpanQ, "cell 2 1 3 1,grow");

		JRadioButton rdbtnTrue = new JRadioButton("True");
		JRadioButton rdbtnFalse = new JRadioButton("Fales");
		rdbtnFalse.addActionListener(new myAction());
		rdbtnTrue.addActionListener(new myAction());

		JPanel radioPanelGroup = new JPanel();

		radioPanelGroup.setLayout(new MigLayout("", "[grow 99]", "[grow 99]"));
		radioPanelGroup.setBorder(BorderFactory.createLineBorder(Color.black));
		TitledBorder title = BorderFactory.createTitledBorder("Answer");
		radioPanelGroup.setBorder(title);

		radioPanelGroup.add(rdbtnTrue);
		radioPanelGroup.add(rdbtnFalse);

		ButtonGroup ttt = new ButtonGroup();
		ttt.add(rdbtnTrue);
		ttt.add(rdbtnFalse);

		JButton btnCancelclearQuestionText = new JButton(
				"Cancel/Clear Question Text");
		panel.add(btnCancelclearQuestionText,
				"cell 4 2,alignx right,aligny top");

		btnAddAnpther = new JButton("Save and Add another True/False Question"); // True

		btnAddAnpther.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String qusetionTitle = textfildeTitle.getText();
				String qusetionQ = textpanQ.getText();

				try {
					out = new PrintWriter(new BufferedWriter(new FileWriter(
							"ExamQ.txt", true)));
					
					out.append("::" + qusetionTitle + "::" + qusetionQ + "{"
							+ answer + "}" + "\n");
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		panel.add(btnAddAnpther, "cell 0 4 3 1,alignx left,aligny top");

		panel.add(radioPanelGroup, "cell 2 2 2097051 1,alignx left,aligny top");

		frame.add(panel);
		frame.setVisible(true);

	}

	public class myAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "True") {
				answer = 'T';

			} else
				answer = 'F';

		}

	}

}
