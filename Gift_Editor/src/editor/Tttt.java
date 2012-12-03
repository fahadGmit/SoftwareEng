package editor;

import java.awt.EventQueue;
import java.awt.Event.*;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButtonMenuItem;
import java.awt.*;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tttt {

	private JFrame frame;
	private JTextField textField;
	private JTextField questionTitle_multi;
	private JTextField choiseTextFilde1;
	private JTextField choiseTextFilde2;
	private JTextField choiseTextFilde3;
	private JTextField choiseTextFilde4;
	static JButton btnAddAnpther;
	static JTextPane textPane;
	RadioButtonHandler handler;
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Gui window = new Gui();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Tttt() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 966, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JButton btnNew = new JButton("New Text File");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnNew, "flowx,cell 0 0");
		
		JButton btnClose = new JButton("Close");
		frame.getContentPane().add(btnClose, "cell 0 0");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "cell 0 1,grow");
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("True_False", null, panel, null);
		panel.setLayout(new MigLayout("", "[153px][4px][96px][410px][218px]", "[28px][169px][29px][29px][29px]"));
		
		JLabel lblQuestionTitleoptional = new JLabel("Question Title (optional)");	////true
		panel.add(lblQuestionTitleoptional, "cell 0 0,alignx left,aligny center");
		
		textField = new JTextField();
		panel.add(textField, "cell 2 0 3 1,growx,aligny top");
		textField.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Question");
		panel.add(lblQuestion, "cell 0 1,alignx right,aligny top");
		
		textPane = new JTextPane();
		panel.add(textPane, "cell 2 1 3 1,grow");
		
		////////////////////////////////////////////////////////////RadioButtonGroup
		RadioButtonHandler handler = new RadioButtonHandler();
		
		JRadioButton rdbtnTrue = new JRadioButton("True");
		JRadioButton rdbtnFalse = new JRadioButton("Fales");
		
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
		
		panel.add(radioPanelGroup, "cell 2 2 2097051 1,alignx left,aligny top");
		
		
		
		
		
		
		
		
		
		
	
		
		JButton btnCancelclearQuestionText = new JButton("Cancel/Clear Question Text");
		panel.add(btnCancelclearQuestionText, "cell 4 2,alignx right,aligny top");
		
		btnAddAnpther = new JButton("Add another True/False Question"); //True
		panel.add(btnAddAnpther, "cell 0 4 3 1,alignx left,aligny top");
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Multiiple Choice", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][grow][][][][][][][][]"));
		
		JLabel lblQuestionTitleoptional_1 = new JLabel("Question Title (optional)");
		panel_1.add(lblQuestionTitleoptional_1, "cell 0 0,alignx right");
		
		questionTitle_multi = new JTextField();
		panel_1.add(questionTitle_multi, "cell 1 0,growx");
		questionTitle_multi.setColumns(10);
		
		JLabel lblQuestion_1 = new JLabel("Question");
		panel_1.add(lblQuestion_1, "cell 0 1,alignx right,aligny top");
		
		JTextPane question_mulit = new JTextPane();
		panel_1.add(question_mulit, "cell 1 1,grow");
		
		JButton btnCancelclearQuestionText_1 = new JButton("Cancel/Clear Question Text");
		panel_1.add(btnCancelclearQuestionText_1, "cell 1 2,alignx right");
		
		JButton btnAddAnswer = new JButton("Add Answer");
		panel_1.add(btnAddAnswer, "cell 0 3,alignx left");
		
		choiseTextFilde1 = new JTextField();
		panel_1.add(choiseTextFilde1, "flowx,cell 1 3,growx");
		choiseTextFilde1.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		panel_1.add(spinner, "cell 1 3");
		
		choiseTextFilde2 = new JTextField();
		panel_1.add(choiseTextFilde2, "flowx,cell 1 4,growx");
		choiseTextFilde2.setColumns(10);
		
		JSpinner spinner_1 = new JSpinner();
		panel_1.add(spinner_1, "cell 1 4");
		
		choiseTextFilde3 = new JTextField();
		panel_1.add(choiseTextFilde3, "flowx,cell 1 5,growx");
		choiseTextFilde3.setColumns(10);
		
		JSpinner spinner_2 = new JSpinner();
		panel_1.add(spinner_2, "cell 1 5");
		
		choiseTextFilde4 = new JTextField();
		panel_1.add(choiseTextFilde4, "flowx,cell 1 6,growx");
		choiseTextFilde4.setColumns(10);
		
		JSpinner spinner_3 = new JSpinner();
		panel_1.add(spinner_3, "cell 1 6");
		
		JButton btnSaveToTest_1 = new JButton("Save to test file");
		panel_1.add(btnSaveToTest_1, "cell 0 7");
		
		JButton btnAddAnotherMultiple = new JButton("Add Another Multiple Choice");	//Multi
		panel_1.add(btnAddAnotherMultiple, "cell 0 9 2097051 1");
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_5, null);
	}

}
