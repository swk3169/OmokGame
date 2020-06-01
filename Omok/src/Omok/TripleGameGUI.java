package Omok;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.awt.*;

import javax.sql.rowset.RowSetWarning;
import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;

import Omok.SingleGameGUI.MyJPanel;

public class TripleGameGUI extends JFrame {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	MyJPanel panel;

	private Player player1; 
	private Player player2;
	private Player player3;
	private Match match = new MyMatch();
	private Position position1, position2, position3;
	private OmokBoard gameBoard = new MyBoard();

	private int id1, id2, id3;
	private int order;
	private int size;
	private String name1, name2, name3;
	private int row;
	private int first;
	private int second;
	private int third;

	private int turn = 0;

	public TripleGameGUI(int id1, int id2, int id3, String name1, String name2, String name3, int order, int size) {
		super("3인용 오목게임");

		this.id1 = id1;
		this.id2 = id2;
		this.id3 = id3;
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.order = order;
		this.size = size;

		// 오목판 설정
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

		// 사용자 설정
		if (order == 1) {
			first = 1;
			second = 2;
			third = 3;
			turn = 1;
		} else if (order == 2) {
			first = 3;
			second = 1;
			third = 2;
			turn = 2;
		} else if (order == 3) {
			first = 2;
			second = 3;
			third = 1;
			turn = 3;
		} else {
			System.out.println("order error");
		}

		player1 = new Player(id1, name1, first, 1) {

			@Override
			public Position play(OmokBoard board) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		player2 = new Player(id2, name2, second, 1) {

			@Override
			public Position play(OmokBoard board) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		player3 = new Player(id3, name3, third, 1) {

			@Override
			public Position play(OmokBoard board) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		match.setPlayer(0, player1);
		match.setPlayer(1, player2);
		match.setPlayer(2, player3);

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

		JOptionPane.showMessageDialog(null, "첫번째 공격 : 흑돌, 두번째 공격 : 백돌, 세번째 공격 : 적돌로 자동 설정됩니다.");

		if (first == 1)
			JOptionPane.showMessageDialog(null, "[흑] player1 (" + name1 + ")의 선공입니다.");
		else if (second == 1)
			JOptionPane.showMessageDialog(null, "[흑] player2 (" + name2 + ")의 선공입니다.");
		else if (third == 1)
			JOptionPane.showMessageDialog(null, "[흑] player3 (" + name3 + ")의 선공입니다.");
	}

	class MyJPanel extends JPanel implements MouseListener {
		private Point sPoint = null;
		private Vector<Point> v; // 포인터를 저장하는 벡터

		private int player1Row = 0, player1Col = 0;
		private int player2Row = 0, player2Col = 0;
		private int player3Row = 0, player3Col = 0;
		private int xPos = 0, yPos = 0;
		private int tmp_xPos = 0, tmp_yPos = 0;
		private boolean player1Win = false, player2Win = false, player3Win = false;

		public MyJPanel() {
			addMouseListener(this);
			v = new Vector<Point>();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (turn == 1) {
				sPoint = e.getPoint();
				v.add(sPoint);

				player1Play(sPoint);
				repaint();
				turn = 2;
				if (player1Win == true) {
					if (first == 1)
						JOptionPane.showMessageDialog(null, "[흑] player1 (" + name1 + ") 승리!");
					else if (first == 2)
						JOptionPane.showMessageDialog(null, "[백] player1 (" + name1 + ") 승리!");
					else if (first == 3)
						JOptionPane.showMessageDialog(null, "[적] player1 (" + name1 + ") 승리!");

					v.clear();
					gameBoard.initBoard();
					repaint();
					turn = 1;
					if (first == 1)
						JOptionPane.showMessageDialog(null, "[흑] player1 (" + name1 + ")의 선공입니다.");
					else if (second == 1)
						JOptionPane.showMessageDialog(null, "[흑] player2 (" + name2 + ")의 선공입니다.");
					else if (third == 1)
						JOptionPane.showMessageDialog(null, "[흑] player3 (" + name3 + ")의 선공입니다.");
				}
			} else if (turn == 2) {
				sPoint = e.getPoint();
				v.add(sPoint);

				player2Play(sPoint);
				repaint();
				turn = 3;
				if (player2Win == true) {
					if (second == 1)
						JOptionPane.showMessageDialog(null, "[흑] player2 (" + name2 + ") 승리!");
					else if (second == 2)
						JOptionPane.showMessageDialog(null, "[백] player2 (" + name2 + ") 승리!");
					else if (second == 3)
						JOptionPane.showMessageDialog(null, "[적] player2 (" + name2 + ") 승리!");

					v.clear();
					gameBoard.initBoard();
					repaint();
					turn = 2;

					if (first == 1)
						JOptionPane.showMessageDialog(null, "[흑] player1 (" + name1 + ")의 선공입니다.");
					else if (second == 1)
						JOptionPane.showMessageDialog(null, "[흑] player2 (" + name2 + ")의 선공입니다.");
					else if (third == 1)
						JOptionPane.showMessageDialog(null, "[흑] player3 (" + name3 + ")의 선공입니다.");
				}
			} else if (turn == 3) {
				sPoint = e.getPoint();
				v.add(sPoint);

				player3Play(sPoint);
				repaint();
				turn = 1;
				if (player3Win == true) {
					if (third == 1)
						JOptionPane.showMessageDialog(null, "[흑] player3 (" + name3 + ") 승리!");
					else if (third == 2)
						JOptionPane.showMessageDialog(null, "[백] player3 (" + name3 + ") 승리!");
					else if (third == 3)
						JOptionPane.showMessageDialog(null, "[적] player3 (" + name3 + ") 승리!");

					v.clear();
					gameBoard.initBoard();
					repaint();
					turn = 3;

					if (first == 1)
						JOptionPane.showMessageDialog(null, "[흑] player1 (" + name1 + ")의 선공입니다.");
					else if (second == 1)
						JOptionPane.showMessageDialog(null, "[흑] player2 (" + name2 + ")의 선공입니다.");
					else if (third == 1)
						JOptionPane.showMessageDialog(null, "[흑] player3 (" + name3 + ")의 선공입니다.");
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
				for (int j = -30; j <= 690; j = j + 40) { // 간격이 40이기 때문에 40씩
															// 늘려준다.
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

			/////////////// userRow, userCol은 전역변수로 선언하였음 ///////////////
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
					
					if (i % 3 == 0) {
						graphics.setColor(Color.black);
						graphics.fillOval(xPos + 35, yPos + 35, 55, 55);
					}
					else if (i % 3 == 1) {						
						graphics.setColor(Color.white);
						graphics.fillOval(xPos + 35, yPos + 35, 55, 55);	
					}
					else if (i % 3 == 2) {
						graphics.setColor(Color.red);
						graphics.fillOval(xPos + 35, yPos + 35, 55, 55);
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
					
					if (i % 3 == 0) {
						graphics.setColor(Color.black);
						graphics.fillOval(xPos + 25, yPos + 25, 45, 45);
					} else if (i % 3 == 1) {
						graphics.setColor(Color.white);
						graphics.fillOval(xPos + 25, yPos + 25, 45, 45);
					} else if (i % 3 == 2) {
						graphics.setColor(Color.red);
						graphics.fillOval(xPos + 25, yPos + 25, 45, 45);
					}
				}
			} else if (row == 19) {
				for (int i = 0; i < v.size(); i++) {
					for (int j = -30; j <= 690; j = j + 40) { // 간격이 40이기 때문에
																// 40씩 늘려준다.
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
					
					if (i % 3 == 0) {
						graphics.setColor(Color.black);
						graphics.fillOval(xPos + 20, yPos + 20, 35, 35);
					} else if (i % 3 == 1) {
						graphics.setColor(Color.white);
						graphics.fillOval(xPos + 20, yPos + 20, 35, 35);
					} else if (i % 3 == 2) {
						graphics.setColor(Color.red);
						graphics.fillOval(xPos + 20, yPos + 20, 35, 35);
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

			// 세로줄 만들기
			for (int i = 0; i < row; i++) {
				graphics.setColor(Color.black);
				graphics.drawLine(10 + i * space, 10, 10 + i * space, 10 + (row - 1) * space);
			}
			// 가로줄 만들기
			for (int i = 0; i < row; i++) {
				graphics.drawLine(10, 10 + i * space, 10 + (row - 1) * space, 10 + i * space);
			}

			// 화점 찍기
			if (row == 11) {
				for (int a = 3; a < 9; a = a + 2) {
					for (int b = 3; b < 9; b = b + 2) {
						graphics.setColor(Color.black);
						graphics.fillOval(a * space + 5, b * space + 5, 10, 10);
					}
				}
			} else if (row == 15) {
				for (int a = 3; a < 15; a = a + 4) {
					for (int b = 3; b < 15; b = b + 4) {
						graphics.setColor(Color.black);
						graphics.fillOval(a * space + 5, b * space + 5, 10, 10);
					}
				}
			} else if (row == 19) {
				for (int a = 3; a < 19; a = a + 6) {
					for (int b = 3; b < 19; b = b + 6) {
						graphics.setColor(Color.black);
						graphics.fillOval(a * space + 5, b * space + 5, 10, 10);
					}
				}
			}
		}

		public Dimension getPreferredSize() {
			return new Dimension(750, 750);
		}

		public void player1Play(Point sPoint) {
			caculate(sPoint.x, sPoint.y); // 처음에 0,0 찍히는거 방지

			while (true) {
				if (row == 11) {
					player1Row = (60 + tmp_yPos) / 70;
					player1Col = (60 + tmp_xPos) / 70;
				} else if (row == 15) {
					player1Row = (40 + tmp_yPos) / 50;
					player1Col = (40 + tmp_xPos) / 50;
				} else if (row == 19) {
					player1Row = (30 + tmp_yPos) / 40;
					player1Col = (30 + tmp_xPos) / 40;
				}

				position1 = new Position(player1Row, player1Col);

				if (first == 1) {
					match.setTurn(1);

					if (match.getCheckValidity(position1) == true) {
						gameBoard.putStone(player1Row, player1Col, StoneType.Black);
						player1Win = match.getCheckWinningCondition(position1);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "이미 돌이 있습니다.");
						break;
					}
				} else if (first == 2) {
					match.setTurn(2);

					if (match.getCheckValidity(position1) == true) {
						gameBoard.putStone(player1Row, player1Col, StoneType.White);
						player1Win = match.getCheckWinningCondition(position1);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "이미 돌이 있습니다.");
						break;
					}
				} else if (first == 3) {
					match.setTurn(3);

					if (match.getCheckValidity(position1) == true) {
						gameBoard.putStone(player1Row, player1Col, StoneType.Red);
						player1Win = match.getCheckWinningCondition(position1);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "이미 돌이 있습니다.");
						break;
					}
				}
			}

			gameBoard.display();
		}

		public void player2Play(Point sPoint) {
			caculate(sPoint.x, sPoint.y); // 처음에 0,0 찍히는거 방지

			while (true) {
				if (row == 11) {
					player2Row = (60 + tmp_yPos) / 70;
					player2Col = (60 + tmp_xPos) / 70;
				} else if (row == 15) {
					player2Row = (40 + tmp_yPos) / 50;
					player2Col = (40 + tmp_xPos) / 50;
				} else if (row == 19) {
					player2Row = (30 + tmp_yPos) / 40;
					player2Col = (30 + tmp_xPos) / 40;
				}

				position2 = new Position(player2Row, player2Col);

				if (second == 1) {
					match.setTurn(1);

					if (match.getCheckValidity(position2) == true) {
						gameBoard.putStone(player2Row, player2Col, StoneType.Black);
						player2Win = match.getCheckWinningCondition(position2);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "이미 돌이 있습니다.");
						break;
					}
				} else if (second == 2) {
					match.setTurn(2);

					if (match.getCheckValidity(position2) == true) {
						gameBoard.putStone(player2Row, player2Col, StoneType.White);
						player2Win = match.getCheckWinningCondition(position2);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "이미 돌이 있습니다.");
						break;
					}
				}
				else if (second == 3) {
					match.setTurn(3);

					if (match.getCheckValidity(position2) == true) {
						gameBoard.putStone(player2Row, player2Col, StoneType.Red);
						player2Win = match.getCheckWinningCondition(position2);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "이미 돌이 있습니다.");
						break;
					}
				}
			}

			gameBoard.display();
		}
		
		public void player3Play(Point sPoint) {
			caculate(sPoint.x, sPoint.y); // 처음에 0,0 찍히는거 방지

			while (true) {
				if (row == 11) {
					player3Row = (60 + tmp_yPos) / 70;
					player3Col = (60 + tmp_xPos) / 70;
				} else if (row == 15) {
					player3Row = (40 + tmp_yPos) / 50;
					player3Col = (40 + tmp_xPos) / 50;
				} else if (row == 19) {
					player3Row = (30 + tmp_yPos) / 40;
					player3Col = (30 + tmp_xPos) / 40;
				}

				position3 = new Position(player3Row, player3Col);

				if (third == 1) {
					match.setTurn(1);

					if (match.getCheckValidity(position3) == true) {
						gameBoard.putStone(player3Row, player3Col, StoneType.Black);
						player3Win = match.getCheckWinningCondition(position3);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "이미 돌이 있습니다.");
						break;
					}
				} else if (third == 2) {
					match.setTurn(2);

					if (match.getCheckValidity(position3) == true) {
						gameBoard.putStone(player3Row, player3Col, StoneType.White);
						player3Win = match.getCheckWinningCondition(position3);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "이미 돌이 있습니다.");
						break;
					}
				} else if (third == 3) {
					match.setTurn(3);

					if (match.getCheckValidity(position3) == true) {
						gameBoard.putStone(player3Row, player3Col, StoneType.Red);
						player3Win = match.getCheckWinningCondition(position3);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "이미 돌이 있습니다.");
						break;
					}
				}
				
			}

			gameBoard.display();
		}
	}
}