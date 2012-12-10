package editor;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Shortanswer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JScrollPane scrPanel;
	private JTextField txtTitle;
	private TextArea txtBody;
	private static PrintWriter out;

	private ArrayList<Row> rowList = new ArrayList<Row>();
	private String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };
	int i = 0;

	public Shortanswer() {

		setLayout(new MigLayout("", "[right][grow][grow]",
				"[][grow][][]"));

		JLabel lblTitle = new JLabel("Question Title (optional)");
		add(lblTitle);

		txtTitle = new JTextField();
		add(txtTitle, "span, growx, wrap");

		JLabel lblQuestion = new JLabel("Question");
		add(lblQuestion, "alignx right,aligny top");

		txtBody = new TextArea();
		add(txtBody, "spanx, grow, wrap");

		JLabel lblAnswer = new JLabel("Answer");
		add(lblAnswer);

		panel = new JPanel();
		panel.setLayout(new MigLayout("", "[grow]", "[]"));

		scrPanel = new JScrollPane(panel);
		add(scrPanel, "spanx, grow, wrap,height 150");

		rowList.add(new Row(letters[i]));

		panel.add(rowList.get(i), "growx, wrap");

		ImageIcon saveadd = new ImageIcon("images/saveadd.png");
		JButton btnAddAnother = new JButton(saveadd);
		btnAddAnother.setToolTipText("Save & Add Question");
		add(btnAddAnother);

		ImageIcon add = new ImageIcon("images/add.png");
		JButton addAnswerRow = new JButton(add);
		addAnswerRow.setToolTipText("Add another Answer");
		add(addAnswerRow,"right");

		ImageIcon remove = new ImageIcon("images/remove.png");
		JButton rmAnswerRow = new JButton(remove);
		rmAnswerRow.setToolTipText("Remove Last Row");
		add(rmAnswerRow);

		addAnswerRow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				addAnswer(++i);
				scrPanel.updateUI();

			}
		});

		rmAnswerRow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (i > 0) {
					delAnswer(i--);
					scrPanel.updateUI();
				} else
					JOptionPane.showMessageDialog(null, "You need one Answer");
			}
		});

		btnAddAnother.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (Gift_Gui.selctedFile == null) {
					JOptionPane.showMessageDialog(null, "Create New File");

				} else {
					try {

						out = new PrintWriter(new BufferedWriter(
								new FileWriter(Gift_Gui.selctedFile, true)));
						out.append("::" + txtTitle.getText() + "::\n"
								+ txtBody.getText() + " {");

						for (int i = 0; i < rowList.size() - 1; i++) {

							out.append("=" + rowList.get(i).getTxt().getText()
									+ " ");

						}
						out.append("="
								+ rowList.get(rowList.size() - 1).getTxt()
										.getText());
						out.append("}\n");
						out.close();

					} catch (IOException e) {
						e.printStackTrace();

					} finally {

						JOptionPane.showMessageDialog(null,
								"Question has been saved");
						txtTitle.setText("");
						txtBody.setText("");

						for (int i = 0; i < rowList.size(); i++) {

							rowList.get(i).getTxt().setText("");
						}
					}

				}
			}

		});

	}

	private void addAnswer(int i) {

		rowList.add(new Row(letters[i]));

		for (int x = 0; x <= i; x++) {

			panel.add(rowList.get(x), "growx, wrap");
		}
	}

	private void delAnswer(int i) {

		panel.remove(rowList.get(i));

	}

	private class Row extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTextField txt;
		private String row;

		public Row(String arow) {

			super();
			this.row = arow;

			setLayout(new MigLayout("insets 0, gap 0", "[][grow]", "[]"));

			txt = new JTextField();

			add(new JLabel(row));
			add(txt, "growx");

		}

		public JTextField getTxt() {
			return txt;
		}
	}

}