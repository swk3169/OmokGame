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
public class ThreePlayerGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_player1_id;
	private JTextField textField_player1_name;
	private JTextField textField_player2_id;
	private JTextField textField_player2_name;
	private JTextField textField_player3_id;
	private JTextField textField_player3_name;

	private TripleGameGUI tripleGameGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ThreePlayerGUI dialog = new ThreePlayerGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ThreePlayerGUI() {
		setModal(true);
		setBounds(150, 150, 610, 725);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(9, 9, 9, 9));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label_player1_id = new JLabel("player1 ID");
		label_player1_id.setForeground(new Color(51, 51, 51));
		label_player1_id.setFont(new Font("08서울남산체 B", Font.PLAIN, 15));
		textField_player1_id = new JTextField();
		textField_player1_id.setForeground(SystemColor.windowBorder);
		textField_player1_id.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField_player1_id.setColumns(10);
		
		JLabel label_player1_name = new JLabel("player1 이름");
		label_player1_name.setForeground(new Color(51, 51, 51));
		label_player1_name.setFont(new Font("08서울남산체 B", Font.PLAIN, 15));
		textField_player1_name = new JTextField();
		textField_player1_name.setForeground(SystemColor.windowBorder);
		textField_player1_name.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField_player1_name.setColumns(10);
		
		JLabel label_player2_id = new JLabel("player2 ID");
		label_player2_id.setForeground(new Color(51, 51, 51));
		label_player2_id.setFont(new Font("08서울남산체 B", Font.PLAIN, 15));
		textField_player2_id = new JTextField();
		textField_player2_id.setForeground(SystemColor.windowBorder);
		textField_player2_id.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField_player2_id.setColumns(10);
		
		JLabel label_player2_name = new JLabel("player2 이름");
		label_player2_name.setForeground(new Color(51, 51, 51));
		label_player2_name.setFont(new Font("08서울남산체 B", Font.PLAIN, 15));
		textField_player2_name = new JTextField();
		textField_player2_name.setForeground(SystemColor.windowBorder);
		textField_player2_name.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField_player2_name.setColumns(10);
		
		JLabel label_player3_id = new JLabel("player3 ID");
		label_player3_id.setForeground(new Color(51, 51, 51));
		label_player3_id.setFont(new Font("08서울남산체 B", Font.PLAIN, 15));
		textField_player3_id = new JTextField();
		textField_player3_id.setForeground(SystemColor.windowBorder);
		textField_player3_id.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField_player3_id.setColumns(10);
		
		JLabel label_player3_name = new JLabel("player3 이름");
		label_player3_name.setForeground(new Color(51, 51, 51));
		label_player3_name.setFont(new Font("08서울남산체 B", Font.PLAIN, 15));
		textField_player3_name = new JTextField();
		textField_player3_name.setForeground(SystemColor.windowBorder);
		textField_player3_name.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		textField_player3_name.setColumns(10);
		
		JLabel label_first_attack = new JLabel("선공");
		label_first_attack.setForeground(new Color(51, 51, 51));
		label_first_attack.setFont(new Font("08서울남산체 B", Font.PLAIN, 25));
		JLabel label_omok_board = new JLabel("오목판");
		label_omok_board.setForeground(new Color(51, 51, 51));
		label_omok_board.setFont(new Font("08서울남산체 B", Font.PLAIN, 25));
		
		JRadioButton radioButton_player1 = new JRadioButton("Player1");
		JRadioButton radioButton_player2 = new JRadioButton("Player2");
		JRadioButton radioButton_player3 = new JRadioButton("Player3");
		
		radioButton_player1.setSelected(true);
		radioButton_player1.setForeground(new Color(51, 51, 51));
		radioButton_player1.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		radioButton_player1.setBackground(SystemColor.control);
		radioButton_player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_player1.setSelected(true);
				radioButton_player2.setSelected(false);
				radioButton_player3.setSelected(false);
			}
		});
		
		radioButton_player2.setForeground(new Color(51, 51, 51));
		radioButton_player2.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		radioButton_player2.setBackground(SystemColor.control);
		radioButton_player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_player1.setSelected(false);
				radioButton_player2.setSelected(true);
				radioButton_player3.setSelected(false);
			}
		});
		
		radioButton_player3.setForeground(new Color(51, 51, 51));
		radioButton_player3.setFont(new Font("08서울남산체 B", Font.PLAIN, 20));
		radioButton_player3.setBackground(SystemColor.control);
		radioButton_player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_player1.setSelected(false);
				radioButton_player2.setSelected(false);
				radioButton_player3.setSelected(true);
			}
		});
		
		JRadioButton radioButton_11x11 = new JRadioButton("11x11");
		JRadioButton radioButton_15x15 = new JRadioButton("15x15");
		JRadioButton radioButton_19x19 = new JRadioButton("19x19");
		
		radioButton_11x11.setSelected(true);
		radioButton_11x11.setForeground(new Color(51, 51, 51));
		radioButton_11x11.setFont(new Font("08서울남산체 B", Font.PLAIN, 18));
		radioButton_11x11.setBackground(SystemColor.control);
		radioButton_11x11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_11x11.setSelected(true);
				radioButton_15x15.setSelected(false);
				radioButton_19x19.setSelected(false);
			}
		});
		
		radioButton_15x15.setForeground(new Color(51, 51, 51));
		radioButton_15x15.setFont(new Font("08서울남산체 B", Font.PLAIN, 18));
		radioButton_15x15.setBackground(SystemColor.control);
		radioButton_15x15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_11x11.setSelected(false);
				radioButton_15x15.setSelected(true);
				radioButton_19x19.setSelected(false);
			}
		});
		
		radioButton_19x19.setForeground(new Color(51, 51, 51));
		radioButton_19x19.setFont(new Font("08서울남산체 B", Font.PLAIN, 18));
		radioButton_19x19.setBackground(SystemColor.control);
		radioButton_19x19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_11x11.setSelected(false);
				radioButton_15x15.setSelected(false);
				radioButton_19x19.setSelected(true);
			}
		});

		JLabel label = new JLabel("플레이어 선택");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setForeground(new Color(51, 51, 51));
		label.setFont(new Font("210 시골밥상 R", Font.PLAIN, 40));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_contentPanel.createSequentialGroup().addContainerGap(45, Short.MAX_VALUE).addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_omok_board, GroupLayout.PREFERRED_SIZE, 73,
												GroupLayout.PREFERRED_SIZE)
										.addGap(34).addComponent(radioButton_11x11, GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addGap(36).addComponent(radioButton_15x15, GroupLayout.PREFERRED_SIZE, 81,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(radioButton_19x19, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_player1_id, GroupLayout.PREFERRED_SIZE, 111,
												GroupLayout.PREFERRED_SIZE)
										.addGap(47).addComponent(textField_player1_id, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_player1_name, GroupLayout.PREFERRED_SIZE, 132,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26).addComponent(textField_player1_name, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_player2_id, GroupLayout.PREFERRED_SIZE, 111,
												GroupLayout.PREFERRED_SIZE)
										.addGap(47).addComponent(textField_player2_id, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_player2_name, GroupLayout.PREFERRED_SIZE, 132,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26).addComponent(textField_player2_name, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_player3_id, GroupLayout.PREFERRED_SIZE, 111,
												GroupLayout.PREFERRED_SIZE)
										.addGap(47).addComponent(textField_player3_id, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_player3_name, GroupLayout.PREFERRED_SIZE, 132,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26).addComponent(textField_player3_name, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(label_first_attack, GroupLayout.PREFERRED_SIZE, 73,
												GroupLayout.PREFERRED_SIZE)
										.addGap(34)
										.addComponent(radioButton_player1, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton_player2, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton_player3, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(31))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addGap(98)))));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(27).addComponent(label).addGap(41)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_player1_id, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_player1_id, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_player1_name, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_player1_name, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(44)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_player2_id, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_player2_id, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_player2_name, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_player2_name, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_player3_id, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_player3_id, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_player3_name, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_player3_name, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_first_attack, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(3).addComponent(radioButton_player1,
										GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(3).addComponent(radioButton_player2,
										GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(3).addComponent(radioButton_player3,
										GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(gl_contentPanel
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(4).addComponent(label_omok_board,
										GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
								.addComponent(radioButton_11x11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(radioButton_15x15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(radioButton_19x19))
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
						int id1 = Integer.parseInt(textField_player1_id.getText());
						int id2 = Integer.parseInt(textField_player2_id.getText());
						int id3 = Integer.parseInt(textField_player3_id.getText());

						// 이름
						String name1 = textField_player1_name.getText();
						String name2 = textField_player2_name.getText();
						String name3 = textField_player3_name.getText();

						// 순서
						int flag = 0;

						if (radioButton_player1.isSelected() == true)
							flag = 1; // 플레이어 1이 선
						else if (radioButton_player2.isSelected() == true)
							flag = 2; // 플레이어 2가 선
						else if (radioButton_player3.isSelected() == true)
							flag = 3;
						// 오목판 크기
						int size = 0;

						if (radioButton_11x11.isSelected() == true)
							size = 0;
						else if (radioButton_15x15.isSelected() == true)
							size = 1;
						else if (radioButton_19x19.isSelected() == true)
							size = 2;

						tripleGameGUI = new TripleGameGUI(id1, id2, id3, name1, name2, name3, flag, size);
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
