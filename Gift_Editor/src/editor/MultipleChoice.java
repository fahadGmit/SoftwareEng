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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class MultipleChoice extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JScrollPane scrPanel;
	private JTextField txtTitle;
	private TextArea txtBody;
	private boolean oneAnswercheck = false;
	private static PrintWriter out;

	private ArrayList<CreateRow> multiList = new ArrayList<CreateRow>();
	private String[] labelName = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };
	private int i = 0;

	public MultipleChoice() {

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

		JLabel lblAnswer = new JLabel("Choices");
		add(lblAnswer);

		panel = new JPanel();
		panel.setLayout(new MigLayout("", "[grow]", "[min]"));

		scrPanel = new JScrollPane(panel);
		add(scrPanel, "spanx, grow, wrap,height 150");

		multiList.add(new CreateRow(labelName[i]));

		panel.add(multiList.get(i), "growx, wrap");

		ImageIcon saveadd = new ImageIcon("images/saveadd.png");
		JButton btnAddAnother = new JButton(saveadd);
		btnAddAnother.setToolTipText("Save & Add Question");
		add(btnAddAnother);

		ImageIcon add = new ImageIcon("images/add.png");
		JButton addRow = new JButton(add);
		addRow.setToolTipText("Add another Multiple Answer");
		add(addRow,"right");
		ImageIcon remove = new ImageIcon("images/remove.png");
		JButton removeRow = new JButton(remove);
		removeRow.setToolTipText("Remove Last Row");

		add(removeRow);
		final JCheckBox oneAnswer = new JCheckBox("One Answer");
		add(oneAnswer);

		oneAnswer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (oneAnswer.isSelected()) {
					oneAnswercheck = true;
					JOptionPane.showMessageDialog(null, "Make the corrcet 100");

				} else {
					oneAnswercheck = false;
				}

			}
		});

		addRow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				addAnswer(++i);
				scrPanel.updateUI();

			}
		});

		removeRow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (i > 0) {
					delRow(i--);
					scrPanel.updateUI();
				} else
					JOptionPane.showMessageDialog(null,
							"You must have at least one Answer");
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
								+ txtBody.getText() + "{\n");

						for (int i = 0; i < multiList.size(); i++) {

							int value = (Integer) (multiList.get(i).getSpn()
									.getValue());

							if (oneAnswercheck) {

								if (value > 0) {

									out.append("="
											+ multiList.get(i).getTxt()
													.getText()
											+ "\n#"
											+ multiList.get(i).getTxtFeedback()
													.getText() + "\n");
								} else {
									out.append("~"
											+ multiList.get(i).getTxt()
													.getText()
											+ "\n#"
											+ multiList.get(i).getTxtFeedback()
													.getText() + "\n");
								}

							} else {
								out.append("~%"
										+ setzero(multiList.get(i).getSpn()
												.getValue().toString())
										+ "%"
										+ multiList.get(i).getTxt().getText()
										+ "#"
										+ multiList.get(i).getTxtFeedback()
												.getText() + "\n");

							}

						}
						out.append("}\n");
						out.close();

					} catch (IOException e) {
						e.printStackTrace();

					} finally {

						JOptionPane.showMessageDialog(null,
								"Question has been saved");
						txtTitle.setText("");
						txtBody.setText("");

						for (int i = 0; i < multiList.size(); i++) {

							multiList.get(i).getTxt().setText("");
							multiList.get(i).getTxtFeedback().setText("");
							multiList.get(i).getSpn().setValue(0);
						}
					}

				}
			}

			private String setzero(String mark) {
				if (mark.compareTo("0") == 0) {
					mark = "-100";
					return mark;
				} else
					return mark;
			}

		});
	}

	private void addAnswer(int i) {

		multiList.add(new CreateRow(labelName[i]));

		for (int x = 0; x <= i; x++) {

			panel.add(multiList.get(x), "growx, wrap");
		}
	}

	private void delRow(int i) {

		panel.remove(multiList.get(i));

	}

	private class CreateRow extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private SpinnerModel spnModel;
		private JSpinner spn;
		private JTextField jtfAnswers;
		private JTextField jtfFeedbakes;
		private String row;

		public CreateRow(String arow) {

			super();
			this.row = arow;

			setLayout(new MigLayout("insets 0, gap 0", "[][grow][][grow][]",
					"[]"));

			spnModel = new SpinnerNumberModel(0, 0, 100, 5);
			spn = new JSpinner(spnModel);

			jtfAnswers = new JTextField();
			jtfFeedbakes = new JTextField();

			add(new JLabel(row));
			add(jtfAnswers, "growx");
			add(new JLabel("FeedBack"));
			add(jtfFeedbakes, "growx");
			add(new JLabel("%"));
			add(spn, "growx");

		}

		public JTextField getTxt() {
			return jtfAnswers;
		}

		public JTextField getTxtFeedback() {
			return jtfFeedbakes;
		}

		public JSpinner getSpn() {
			return spn;
		}
	}

}