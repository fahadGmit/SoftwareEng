package editor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButtonMenuItem;

public class Gui {

	private JFrame frame;
	private JTextField textField;
	private RadioButtonGroupPanel rdbtnmntmNewRadioItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 966, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JButton btnSave = new JButton("Save");
		frame.getContentPane().add(btnSave, "flowx,cell 0 0");
		
		JButton btnClose = new JButton("Close");
		frame.getContentPane().add(btnClose, "cell 0 0");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "cell 0 1,grow");
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("True_False", null, panel, null);
		panel.setLayout(new MigLayout("", "[100px,right][grow][grow][][]", "[][100px,grow,top][grow][][][][]"));
		
		JLabel lblQuestionTitleoptional = new JLabel("Question Title (optional)");
		panel.add(lblQuestionTitleoptional, "cell 0 0");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 0 4 1,growx");
		textField.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Question");
		panel.add(lblQuestion, "cell 0 1,aligny top");
		
		JTextPane textPane = new JTextPane();
		panel.add(textPane, "cell 1 1 4 1,grow");
		
		JButton btnSaveToTest = new JButton("Save To test file");
		panel.add(btnSaveToTest, "cell 0 2,alignx left");
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, "cell 1 2,grow");
		
//		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("New radio item");
		RadioButtonGroupPanel rdbtnmntmNewRadioItem = new RadioButtonGroupPanel(new String[] {
				"True", "False" }, "True");
		panel_6.add(rdbtnmntmNewRadioItem);
		
		
		
		JButton btnCancelclearQuestionText = new JButton("Cancel/Clear Question Text");
		panel.add(btnCancelclearQuestionText, "cell 4 2,alignx right,aligny top");
		
		JButton btnAddAnpther = new JButton("Add another True/False Question");
		panel.add(btnAddAnpther, "cell 0 5 5 1,alignx left");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
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