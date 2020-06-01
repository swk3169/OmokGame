package Omok;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {
	@SuppressWarnings("unused")
	private OnePlayerGUI oneGui;
	@SuppressWarnings("unused")
	private TwoPlayerGUI twoGui;
	@SuppressWarnings("unused")
	private ThreePlayerGUI threeGui;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		ImageIcon icon = new ImageIcon("main.jpg");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 700);
		contentPane = new JPanel() {
			public void paintComponent(Graphics graphics) {
				graphics.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(graphics);
			}
		};
		contentPane.setBackground(new Color(204, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);

		JLabel lblNewLabel = new JLabel("Omok Game");
		lblNewLabel.setForeground(new Color(102, 51, 51));
		lblNewLabel.setFont(new Font("210 Ω√∞Òπ‰ªÛ B", Font.BOLD, 100));

		JButton button_single = new JButton("1¿ŒøÎ ∞‘¿”Ω√¿€");
		button_single.setForeground(new Color(51, 51, 51));
		button_single.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oneGui = new OnePlayerGUI();
			}
		});
		button_single.setBackground(SystemColor.inactiveCaptionBorder);
		button_single.setFont(new Font("210 Ω√∞Òπ‰ªÛ R", Font.PLAIN, 50));

		JButton button_double = new JButton("2¿ŒøÎ ∞‘¿”Ω√¿€");
		button_double.setForeground(new Color(51, 51, 51));
		button_double.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				twoGui = new TwoPlayerGUI();
			}
		});
		button_double.setBackground(SystemColor.inactiveCaptionBorder);
		button_double.setFont(new Font("210 Ω√∞Òπ‰ªÛ R", Font.PLAIN, 50));
		
		JButton button_triple = new JButton("3¿ŒøÎ ∞‘¿”Ω√¿€");
		button_triple.setForeground(new Color(51, 51, 51));
		button_triple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				threeGui = new ThreePlayerGUI();
			}
		});
		button_triple.setBackground(SystemColor.inactiveCaptionBorder);
		button_triple.setFont(new Font("210 Ω√∞Òπ‰ªÛ R", Font.PLAIN, 50));

		JButton button_exit = new JButton("¡æ∑·");
		button_exit.setForeground(new Color(51, 51, 51));
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_exit.setBackground(SystemColor.inactiveCaptionBorder);
		button_exit.setFont(new Font("210 Ω√∞Òπ‰ªÛ R", Font.PLAIN, 65));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(146, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 648, GroupLayout.PREFERRED_SIZE)
						.addGap(130))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(252)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button_single, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_double, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_triple, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_exit, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(246, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(78)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(button_single, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(button_double, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(button_triple, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(button_exit, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(80, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
