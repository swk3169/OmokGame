package Omok;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.PrivilegedActionException;
import java.util.Vector;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.sql.rowset.RowSetWarning;
import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;

public class SingleGameGUI extends JFrame {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	MyJPanel panel;

	private Player user, com;
	private Match match = new MyMatch();
	private Position position1, position2;
	private OmokBoard gameBoard = new MyBoard();

	private int id, order, size;
	private String name;
	private int row;

	public SingleGameGUI(int id, String name, int order, int size) {
		super("1�ο� �������");

		this.id = id;
		this.name = name;
		this.order = order;
		this.size = size;

		// ������ ����
		if (size == 0)
			row = 11;
		else if (size == 1)
			row = 15;
		else if (size == 2)
			row = 19;

		gameBoard.setBoardSize(size);
		gameBoard.initBoard();
		match.setBoard(gameBoard);
		gameBoard.display();

		// ����� ����
		user = new Player(id, name, order, 1) {
			@Override
			public Position play(OmokBoard board) {
				return null;
			}
		};
		match.setPlayer(0, user); // players[0] = user

		// ��ǻ�� ����
		if (order == 1) {
			com = new ComputerPlayer(-10000, "COMPUTER", 2, 2);
			match.setPlayer(1, com); // players[1] = computer
		} else {
			com = new ComputerPlayer(-10000, "COMPUTER", 1, 2);
			match.setPlayer(1, com); // players[1] = computer
		}

		initializeComponents();
	}

	public void main(String[] args) {
		// SingleGameGUI app = new SingleGameGUI(id, name, order, size);
	}

	private void initializeComponents() {
		ImageIcon icon = new ImageIcon("background.jpg");

		Container c = this.getContentPane();
		c.setBackground(new Color(230, 201, 167));

		panel = new MyJPanel() {
			public void paintComponent(Graphics graphics) {
				graphics.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(graphics);
			}
		};
		c.setLayout(new FlowLayout());
		c.add(panel);

		this.setSize(760, 780);
		this.setLocation(100, 100);
		this.setVisible(true);
		this.setResizable(false);

		JOptionPane.showMessageDialog(null, "����� : �浹, ��ǻ�� : �鵹�� �ڵ� �����˴ϴ�.");

		if (order == 1)
			JOptionPane.showMessageDialog(null, "[��] ����� (" + name + ")�� �����Դϴ�.");
		else
			JOptionPane.showMessageDialog(null, "[��] ��ǻ���� �����Դϴ�.");
	}

	class MyJPanel extends JPanel implements MouseListener {
		private Point sPoint = null;
		private Vector<Point> v; // �����͸� �����ϴ� ����

		private int comRow = 0, comCol = 0;
		private int userRow = 0, userCol = 0;
		private int xPos = 0, yPos = 0;
		private int tmp_xPos = 0, tmp_yPos = 0;
		private boolean userWin = false, comWin = false;

		public MyJPanel() {
			addMouseListener(this);
			v = new Vector<Point>();

			if (order == 2) {
				computerPlay();
				repaint();
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			sPoint = e.getPoint();
			v.add(sPoint);

			userPlay(sPoint);
			computerPlay();
			repaint();

			// ����� �¸�
			if (userWin == true) {
				JOptionPane.showMessageDialog(null, "[��] ����� �¸�");

				v.clear();
				gameBoard.initBoard();
				repaint();

				if (order == 1)
					JOptionPane.showMessageDialog(null, "[��] ����� (" + name + ")�� �����Դϴ�.");
				else {
					JOptionPane.showMessageDialog(null, "[��] ��ǻ���� �����Դϴ�.");
					computerPlay();
					repaint();
				}
			}
			// ��ǻ�� �¸�
			if (comWin == true) {
				JOptionPane.showMessageDialog(null, "[��] ��ǻ�� �¸�");

				v.clear();
				gameBoard.initBoard();
				repaint();

				if (order == 1)
					JOptionPane.showMessageDialog(null, "[��] ����� (" + name + ")�� �����Դϴ�.");
				else {
					JOptionPane.showMessageDialog(null, "[��] ��ǻ���� �����Դϴ�.");
					computerPlay();
					repaint();
				}
			}
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void caculate(int xPos, int yPos) {
			if (row == 11) {
				for (int j = -60; j <= 640; j = j + 70) {
					if (xPos - 35 >= j && xPos - 35 <= j + 70) {
						tmp_xPos = j;
						break;
					}
				}

				for (int k = -60; k <= 640; k = k + 70) {
					if (yPos - 35 >= k && yPos - 35 <= k + 70) {
						tmp_yPos = k;
						break;
					}
				}
			} else if (row == 15) {
				for (int j = -40; j <= 760; j = j + 50) {
					if (xPos - 35 >= j && xPos - 35 <= j + 50) {
						tmp_xPos = j;
						break;
					}
				}

				for (int k = -40; k <= 760; k = k + 50) {
					if (yPos - 35 >= k && yPos - 35 <= k + 50) {
						tmp_yPos = k;
						break;
					}
				}
			} else if (row == 19) {
				for (int j = -30; j <= 690; j = j + 40) {
					if (xPos - 20 >= j && xPos - 20 <= j + 40) {
						tmp_xPos = j;
						break;
					}
				}

				for (int k = -30; k <= 690; k = k + 40) {
					if (yPos - 20 >= k && yPos - 20 <= k + 40) {
						tmp_yPos = k;
						break;
					}
				}
			}
		}

		public void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);

			drawBoard(graphics);

			/////////////// userRow, userCol�� ���������� �����Ͽ��� ///////////////
			if (row == 11) {
				for (int i = 0; i < v.size(); i++) {
					for (int j = -60; j <= 640; j = j + 70) {
						if (v.get(i).x - 35 >= j && v.get(i).x - 35 <= j + 70) {
							xPos = j;
							break;
						}
					}

					for (int k = -60; k <= 640; k = k + 70) {
						if (v.get(i).y - 35 >= k && v.get(i).y - 35 <= k + 70) {
							yPos = k;
							break;
						}
					}

					if (order == 1) // ����ڰ� ������ ��
					{
						if (i % 2 == 0) {
							graphics.setColor(Color.BLACK);
							graphics.fillOval(xPos + 35, yPos + 35, 55, 55);
						} else if (i % 2 == 1) {
							graphics.setColor(Color.WHITE);
							graphics.fillOval(xPos + 35, yPos + 35, 55, 55);
						}
					} else if (order == 2) // ����ڰ� �İ��� ��
					{
						if (i % 2 == 0) {
							graphics.setColor(Color.WHITE);
							graphics.fillOval(xPos + 35, yPos + 35, 55, 55);
						} else if (i % 2 == 1) {
							graphics.setColor(Color.BLACK);
							graphics.fillOval(xPos + 35, yPos + 35, 55, 55);
						}
					}
				}
			} else if (row == 15) {
				for (int i = 0; i < v.size(); i++) {
					for (int j = -40; j <= 760; j = j + 50) {
						if (v.get(i).x - 35 >= j && v.get(i).x - 35 <= j + 50) {
							xPos = j;
							break;
						}
					}

					for (int k = -40; k <= 760; k = k + 50) {
						if (v.get(i).y - 35 >= k && v.get(i).y - 35 <= k + 50) {
							yPos = k;
							break;
						}
					}

					if (order == 1) // ����ڰ� ������ ��
					{
						if (i % 2 == 0) {
							graphics.setColor(Color.BLACK);
							graphics.fillOval(xPos + 25, yPos + 25, 45, 45);
						} else if (i % 2 == 1) {
							graphics.setColor(Color.WHITE);
							graphics.fillOval(xPos + 25, yPos + 25, 45, 45);
						}
					} else if (order == 2) // ����ڰ� �İ��� ��
					{
						if (i % 2 == 0) {
							graphics.setColor(Color.WHITE);
							graphics.fillOval(xPos + 25, yPos + 25, 45, 45);
						} else if (i % 2 == 1) {
							graphics.setColor(Color.BLACK);
							graphics.fillOval(xPos + 25, yPos + 25, 45, 45);
						}
					}
				}
			} else if (row == 19) {
				for (int i = 0; i < v.size(); i++) {
					for (int j = -30; j <= 690; j = j + 40) { // ������ 40�̱� ������
																// 40�� �÷��ش�.
						if (v.get(i).x - 20 >= j && v.get(i).x - 20 <= j + 40) {
							xPos = j;
							break;
						}
					}

					for (int k = -30; k <= 690; k = k + 40) {
						if (v.get(i).y - 20 >= k && v.get(i).y - 20 <= k + 40) {
							yPos = k;
							break;
						}
					}

					if (order == 1) // ����ڰ� ������ ��
					{
						if (i % 2 == 0) {
							graphics.setColor(Color.BLACK);
							graphics.fillOval(xPos + 20, yPos + 20, 35, 35);
						} else if (i % 2 == 1) {
							graphics.setColor(Color.WHITE);
							graphics.fillOval(xPos + 20, yPos + 20, 35, 35);
						}
					} else if (order == 2) // ����ڰ� �İ��� ��
					{
						if (i % 2 == 0) {
							graphics.setColor(Color.WHITE);
							graphics.fillOval(xPos + 20, yPos + 20, 35, 35);
						} else if (i % 2 == 1) {
							graphics.setColor(Color.BLACK);
							graphics.fillOval(xPos + 20, yPos + 20, 35, 35);
						}
					}
				}
			}
		}

		public void drawBoard(Graphics graphics) {
			int space = 0;

			if (row == 11)
				space = 70;
			else if (row == 15)
				space = 50;
			else if (row == 19)
				space = 40;

			// ������ �����
			for (int i = 0; i < row; i++) {
				graphics.setColor(Color.BLACK);
				graphics.drawLine(10 + i * space, 10, 10 + i * space, 10 + (row - 1) * space);
			}
			// ������ �����
			for (int i = 0; i < row; i++) {
				graphics.drawLine(10, 10 + i * space, 10 + (row - 1) * space, 10 + i * space);
			}

			// ȭ�� ���
			if (row == 11) {
				for (int a = 3; a < 9; a = a + 2) {
					for (int b = 3; b < 9; b = b + 2) {
						graphics.setColor(Color.BLACK);
						graphics.fillOval(a * space + 5, b * space + 5, 10, 10);
					}
				}
			} else if (row == 15) {
				for (int a = 3; a < 15; a = a + 4) {
					for (int b = 3; b < 15; b = b + 4) {
						graphics.setColor(Color.BLACK);
						graphics.fillOval(a * space + 5, b * space + 5, 10, 10);
					}
				}
			} else if (row == 19) {
				for (int a = 3; a < 19; a = a + 6) {
					for (int b = 3; b < 19; b = b + 6) {
						graphics.setColor(Color.BLACK);
						graphics.fillOval(a * space + 5, b * space + 5, 10, 10);
					}
				}
			}
		}

		public Dimension getPreferredSize() {
			return new Dimension(750, 750);
		}

		public void userPlay(Point sPoint) {
			caculate(sPoint.x, sPoint.y); // ó���� 0,0 �����°� ����
			match.setTurn(1);

			while (true) {
				if (row == 11) {
					userRow = (60 + tmp_yPos) / 70;
					userCol = (60 + tmp_xPos) / 70;
				} else if (row == 15) {
					userRow = (40 + tmp_yPos) / 50;
					userCol = (40 + tmp_xPos) / 50;
				} else if (row == 19) {
					userRow = (30 + tmp_yPos) / 40;
					userCol = (30 + tmp_xPos) / 40;
				}

				position1 = new Position(userRow, userCol);

				if (match.getCheckValidity(position1) == true) {
					gameBoard.putStone(userRow, userCol, StoneType.Black);
					userWin = match.getCheckWinningCondition(position1);
					break;
				} else {
					System.out.println("�̹� ���� �ֽ��ϴ�.");
					JOptionPane.showMessageDialog(null, "�̹� ���� �ֽ��ϴ�.");
					break;
				}
			}

			gameBoard.display();
		}

		public void computerPlay() {
			int x = 0, y = 0;

			position2 = match.players[1].play(gameBoard);
			match.setTurn(2);

			gameBoard.putStone(position2.getRow(), position2.getColumn(), StoneType.White);

			gameBoard.display();

			comRow = position2.getRow() + 1;
			comCol = position2.getColumn() + 1;

			if (row == 11) {
				x = (70 * comRow) - 60;
				y = (70 * comCol) - 60;
			} else if (row == 15) {
				x = (50 * comRow) - 40;
				y = (50 * comCol) - 40;
			} else if (row == 19) {
				x = (40 * comRow) - 30;
				y = (40 * comCol) - 30;
			}

			v.add(new Point(y, x)); // null pointer ������ new point�� ����

			comWin = match.getCheckWinningCondition(position2);
		}
	}
}