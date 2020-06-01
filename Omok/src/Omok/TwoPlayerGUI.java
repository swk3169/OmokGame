package Omok;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Color;

@SuppressWarnings("serial")
public class TwoPlayerGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private DoubleGameGUI doubleGameGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TwoPlayerGUI dialog = new TwoPlayerGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TwoPlayerGUI() {
		setModal(true);
		setBounds(100, 100, 510, 625);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel label_1 = new JLabel("player1 ID");
		label_1.setForeground(new Color(51, 51, 51));
		label_1.setFont(new Font("08서울남산체 B", Font.PLAIN, 15));
		textField = new JTextField();
		textField.setForeground(SystemColor.windowBorder);
		textField.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setForeground(SystemColor.windowBorder);
		textField_1.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField_1.setColumns(10);
		JLabel label_2 = new JLabel("player1 \uC774\uB984");
		label_2.setForeground(new Color(51, 51, 51));
		label_2.setFont(new Font("08서울남산체 B", Font.PLAIN, 15));
		JLabel label_3 = new JLabel("player2 ID");
		label_3.setForeground(new Color(51, 51, 51));
		label_3.setFont(new Font("08서울남산체 B", Font.PLAIN, 15));
		JLabel label_4 = new JLabel("player2 \uC774\uB984");
		label_4.setForeground(new Color(51, 51, 51));
		label_4.setFont(new Font("08서울남산체 B", Font.PLAIN, 15));
		textField_2 = new JTextField();
		textField_2.setForeground(SystemColor.windowBorder);
		textField_2.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_3 = new JTextField();
		textField_3.setForeground(SystemColor.windowBorder);
		textField_3.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField_3.setColumns(10);
		JLabel label_5 = new JLabel("\uC120\uACF5");
		label_5.setForeground(new Color(51, 51, 51));
		label_5.setFont(new Font("08서울남산체 B", Font.PLAIN, 25));
		JLabel label_6 = new JLabel("\uC624\uBAA9\uD310");
		label_6.setForeground(new Color(51, 51, 51));
		label_6.setFont(new Font("08서울남산체 B", Font.PLAIN, 25));
		JRadioButton radioButton = new JRadioButton("Player1");
		JRadioButton radioButton_2 = new JRadioButton("Player2");
		radioButton.setSelected(true);
		radioButton.setForeground(new Color(51, 51, 51));
		radioButton.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		radioButton.setBackground(SystemColor.control);
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton.setSelected(true);
				radioButton_2.setSelected(false);
			}
		});
		radioButton_2.setForeground(new Color(51, 51, 51));
		radioButton_2.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		radioButton_2.setBackground(SystemColor.control);
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton.setSelected(false);
				radioButton_2.setSelected(true);
			}
		});
		JRadioButton radioButton_1 = new JRadioButton("11x11");
		JRadioButton radioButton_3 = new JRadioButton("15x15");
		JRadioButton radioButton_4 = new JRadioButton("19x19");
		radioButton_1.setSelected(true);
		radioButton_1.setForeground(new Color(51, 51, 51));
		radioButton_1.setFont(new Font("08서울남산체 B", Font.PLAIN, 18));
		radioButton_1.setBackground(SystemColor.control);
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_1.setSelected(true);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
			}
		});
		radioButton_3.setForeground(new Color(51, 51, 51));
		radioButton_3.setFont(new Font("08서울남산체 B", Font.PLAIN, 18));
		radioButton_3.setBackground(SystemColor.control);
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_1.setSelected(false);
				radioButton_3.setSelected(true);
				radioButton_4.setSelected(false);
			}
		});
		radioButton_4.setForeground(new Color(51, 51, 51));
		radioButton_4.setFont(new Font("08서울남산체 B", Font.PLAIN, 18));
		radioButton_4.setBackground(SystemColor.control);
		radioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_1.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(true);
			}
		});

		JLabel label = new JLabel("\uD50C\uB808\uC774\uC5B4 \uC124\uC815");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setForeground(new Color(51, 51, 51));
		label.setFont(new Font("210 시골밥상 R", Font.PLAIN, 70));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_contentPanel.createSequentialGroup().addContainerGap(45, Short.MAX_VALUE).addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 73,
												GroupLayout.PREFERRED_SIZE)
										.addGap(34)
										.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addGap(36)
										.addComponent(radioButton_3, GroupLayout.PREFERRED_SIZE, 81,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(radioButton_4, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 132,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26).addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 111,
												GroupLayout.PREFERRED_SIZE)
										.addGap(47).addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 132,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26).addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 111,
												GroupLayout.PREFERRED_SIZE)
										.addGap(47).addComponent(textField, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 73,
												GroupLayout.PREFERRED_SIZE)
										.addGap(34)
										.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(31))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addGap(98)))));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(27).addComponent(label).addGap(41)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(44)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(3).addComponent(radioButton,
										GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(3).addComponent(radioButton_2,
										GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(gl_contentPanel
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(4).addComponent(label_6,
										GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
								.addComponent(radioButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(radioButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(radioButton_4))
						.addContainerGap(40, Short.MAX_VALUE)));
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
						int id1 = Integer.parseInt(textField.getText());
						int id2 = Integer.parseInt(textField_3.getText());

						// 이름
						String name1 = textField_1.getText();
						String name2 = textField_2.getText();

						// 순서
						int first = 0;

						if (radioButton.isSelected() == true)
							first = 1; // 플레이어 1이 선
						else
							first = 2; // 플레이어 2가 선

						// 오목판 크기
						int size = 0;

						if (radioButton_1.isSelected() == true)
							size = 0;
						else if (radioButton_3.isSelected() == true)
							size = 1;
						else if (radioButton_4.isSelected() == true)
							size = 2;

						doubleGameGUI = new DoubleGameGUI(id1, id2, name1, name2, first, size);
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

		setVisible(true);
	}
}
