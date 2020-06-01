package Omok;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class OnePlayerGUI extends JDialog {
	private SingleGameGUI singleGameGUI;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OnePlayerGUI dialog = new OnePlayerGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OnePlayerGUI() {
		setBounds(100, 100, 515, 476);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel label_1 = new JLabel("ID");
		label_1.setForeground(new Color(51, 51, 51));
		label_1.setFont(new Font("08서울남산체 B", Font.PLAIN, 25));
		textField = new JTextField();
		textField.setForeground(SystemColor.windowBorder);
		textField.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setForeground(SystemColor.windowBorder);
		textField_1.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField_1.setColumns(10);
		JLabel label_2 = new JLabel("\uC774\uB984");
		label_2.setForeground(new Color(51, 51, 51));
		label_2.setFont(new Font("08서울남산체 B", Font.PLAIN, 25));
		JLabel label_3 = new JLabel("\uC21C\uC11C");
		label_3.setForeground(new Color(51, 51, 51));
		label_3.setFont(new Font("08서울남산체 B", Font.PLAIN, 25));
		JRadioButton radioButton = new JRadioButton("1\uBC88");
		JRadioButton radioButton_1 = new JRadioButton("2\uBC88");
		JRadioButton radioButton_2 = new JRadioButton("15x15");
		JRadioButton radioButton_3 = new JRadioButton("19x19");
		JRadioButton radioButton_4 = new JRadioButton("11x11");
		radioButton.setSelected(true);
		radioButton.setForeground(new Color(51, 51, 51));
		radioButton.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		radioButton.setBackground(SystemColor.control);
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton.setSelected(true);
				radioButton_1.setSelected(false);
			}
		});
		radioButton_1.setForeground(new Color(51, 51, 51));
		radioButton_1.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		radioButton_1.setBackground(SystemColor.control);
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton.setSelected(false);
				radioButton_1.setSelected(true);
			}
		});
		radioButton_2.setForeground(new Color(51, 51, 51));
		radioButton_2.setFont(new Font("08서울남산체 B", Font.PLAIN, 18));
		radioButton_2.setBackground(SystemColor.control);
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_2.setSelected(true);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
			}
		});
		radioButton_3.setForeground(new Color(51, 51, 51));
		radioButton_3.setFont(new Font("08서울남산체 B", Font.PLAIN, 18));
		radioButton_3.setBackground(SystemColor.control);
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(true);
				radioButton_4.setSelected(false);
			}
		});
		radioButton_4.setSelected(true);
		radioButton_4.setForeground(new Color(51, 51, 51));
		radioButton_4.setFont(new Font("08서울남산체 B", Font.PLAIN, 18));
		radioButton_4.setBackground(SystemColor.control);
		radioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(true);
			}
		});
		JLabel label_4 = new JLabel("\uC624\uBAA9\uD310");
		label_4.setForeground(new Color(51, 51, 51));
		label_4.setFont(new Font("08서울남산체 B", Font.PLAIN, 25));

		JLabel label = new JLabel("\uD50C\uB808\uC774\uC5B4 \uC124\uC815");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setForeground(new Color(51, 51, 51));
		label.setFont(new Font("210 시골밥상 R", Font.PLAIN, 70));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel
						.createParallelGroup(
								Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(33).addGroup(gl_contentPanel
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(20)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addGap(59).addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 73,
																GroupLayout.PREFERRED_SIZE)
														.addGap(59).addComponent(radioButton_4,
																GroupLayout.PREFERRED_SIZE, 90,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPanel.createSequentialGroup().addGap(20)
														.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 53,
																GroupLayout.PREFERRED_SIZE)
														.addGap(59).addComponent(radioButton,
																GroupLayout.PREFERRED_SIZE, 67,
																GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 99,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 90,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(radioButton_3, GroupLayout.PREFERRED_SIZE, 90,
																GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(38)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addGap(59).addComponent(textField, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(50, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(118, Short.MAX_VALUE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addGap(106)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(26)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE).addGap(41)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(28)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(5).addComponent(label_2,
										GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(32)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(4).addComponent(label_3,
										GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(32)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(4).addComponent(label_4,
										GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(radioButton_4, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(radioButton_3, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(47, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(SystemColor.inactiveCaptionBorder);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();

						// ID
						int id = Integer.parseInt(textField.getText());
						// 이름
						String name = textField_1.getText();
						// 순서
						int order = 1;

						if (radioButton.isSelected() == true)
							order = 1;
						else if (radioButton_1.isSelected() == true)
							order = 2;
						// 오목판 크기(0=11x11, 1=15x15, 2=19x19)
						int size = 0;

						if (radioButton_4.isSelected() == true)
							size = 0;
						else if (radioButton_2.isSelected() == true)
							size = 1;
						else if (radioButton_3.isSelected() == true)
							size = 2;

						singleGameGUI = new SingleGameGUI(id, name, order, size);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(SystemColor.inactiveCaptionBorder);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		this.setModal(true);
		this.setVisible(true);
	}
}
