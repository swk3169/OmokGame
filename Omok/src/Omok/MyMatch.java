package Omok;

import java.util.Scanner;

public class MyMatch extends Match {
	private Position m;

	public MyMatch() {
		super();
	}

	public boolean getCheckWinningCondition(Position m) {
		boolean checkWinning = checkWinningCondition(m);

		return checkWinning;
	}

	public boolean getCheckValidity(Position m) {
		boolean checkVal = checkValidity(m);

		return checkVal;
	}

	//////////// ���� ���� �޼ҵ� ////////////
	public void resisterPlayer() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		int userID = -1, userOrder = -1;
		String userName = "";

		System.out.print("<���� Ÿ��> 1. �����vs��ǻ��, 2. �����vs�����, 3. �����vs�����vs����� : ");
		int gameType = s.nextInt();

		switch (gameType) {
		case 1:
			// �����vs��ǻ��
			System.out.println("<�÷��̾� �Է� - �����>");
			System.out.print("ID : ");
			userID = s.nextInt();
			System.out.print("�̸� : ");
			userName = s.next();
			System.out.print("����(1,2) : ");
			userOrder = s.nextInt();

			Player p = new Player(userID, userName, userOrder, 1) {
				@Override
				public Position play(OmokBoard board) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			setPlayer(0, p);

			// ��ǻ�� ���� ����
			if (p.getOrder() == 1)
				userOrder = 2;
			else if (p.getOrder() == 2)
				userOrder = 1;

			Player com = new ComputerPlayer(-10000, "COMPUTER", userOrder, 1);
			setPlayer(1, com);

			System.out.println("�÷��̾� ���� �Ϸ�!");
			break;
			
		case 2:
			// �����vs�����
			System.out.println("<�÷��̾� �Է� - ����� 1>");
			System.out.print("ID : ");
			userID = s.nextInt();
			System.out.print("�̸� : ");
			userName = s.next();
			System.out.print("����(1,2) : ");
			userOrder = s.nextInt();

			Player p1 = new Player(userID, userName, userOrder, 2) {
				@Override
				public Position play(OmokBoard board) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			setPlayer(0, p1);

			System.out.println("<�÷��̾� �Է� - ����� 2>");
			System.out.print("ID : ");
			userID = s.nextInt();
			for (int i = 0; i < 2; i++) {
				if (p1.getID() == userID) {
					System.out.println("ID �ߺ�.");
					return;
				}
			}
			System.out.print("�̸� : ");
			userName = s.next();
			// ���� ����
			if (p1.getOrder() == 1) {
				System.out.println("�ڵ����� 2��° ������ �����˴ϴ�.");
				userOrder = 2;
			} else if (p1.getOrder() == 2) {
				System.out.println("�ڵ����� 1��° ������ �����˴ϴ�.");
				userOrder = 1;
			}

			Player p2 = new Player(userID, userName, userOrder, 2) {
				@Override
				public Position play(OmokBoard board) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			setPlayer(1, p2);

			System.out.println("�÷��̾� ���� �Ϸ�!");
			break;
			
		case 3:
			// �����vs�����vs�����
			System.out.println("<�÷��̾� �Է� - ����� 1>");
			System.out.print("ID : ");
			userID = s.nextInt();
			System.out.print("�̸� : ");
			userName = s.next();
			System.out.print("����(1,2,3) : ");
			userOrder = s.nextInt();

			Player player1 = new Player(userID, userName, userOrder, 3) {
				@Override
				public Position play(OmokBoard board) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			setPlayer(0, player1);

			System.out.println("<�÷��̾� �Է� - ����� 2>");
			System.out.print("ID : ");
			userID = s.nextInt();
			for (int i = 0; i < 2; i++) {
				if (player1.getID() == userID) {
					System.out.println("ID �ߺ�.");
					return;
				}
			}
			System.out.print("�̸� : ");
			userName = s.next();
			System.out.print("����(1,2,3) : ");
			userOrder = s.nextInt();

			Player player2 = new Player(userID, userName, userOrder, 3) {
				@Override
				public Position play(OmokBoard board) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			setPlayer(1, player2);
			
			System.out.println("<�÷��̾� �Է� - ����� 3>");
			System.out.print("ID : ");
			userID = s.nextInt();
			for (int i = 0; i < 2; i++) {
				if (player1.getID() == userID || player2.getID() == userID) {
					System.out.println("ID �ߺ�.");
					return;
				}
			}
			System.out.print("�̸� : ");
			userName = s.next();
			// ���� ����
			if (player1.getOrder() == 1 && player2.getOrder() == 2 || player1.getOrder() == 2 && player2.getOrder() == 1) {
				System.out.println("�ڵ����� 3��° ������ �����˴ϴ�.");
				userOrder = 3;
			} else if (player1.getOrder() == 1 && player2.getOrder() == 3 || player1.getOrder() == 3 && player2.getOrder() == 1) {
				System.out.println("�ڵ����� 2��° ������ �����˴ϴ�.");
				userOrder = 2;
				
			} else if (player1.getOrder() == 2 && player2.getOrder() == 3 || player1.getOrder() == 3 && player2.getOrder() == 2) {
				System.out.println("�ڵ����� 1��° ������ �����˴ϴ�.");
				userOrder = 1;
			}

			Player player3 = new Player(userID, userName, userOrder, 3) {
				@Override
				public Position play(OmokBoard board) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			setPlayer(2, player3);

			System.out.println("�÷��̾� ���� �Ϸ�!");
			break;

		default:
			System.out.println("�Է� ����");
			break;
		}
	}

	public void gameStart() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		// ������ ����
		if (players[0] == null || players[1] == null) {
			System.out.println("�÷��̾ �Է����ּ���.");
			return;
		}

		System.out.print("������ ũ�� (0:10x10, 1:15x15, 2:19x19) : ");
		int userBoardSize = s.nextInt();

		OmokBoard temp = new MyBoard();
		temp.setBoardSize(userBoardSize);
		setBoard(temp);
		temp.initBoard();

		System.out.println("<������ ���� �Ϸ�>");

		OmokBoard gameBoard = getBoard();
		gameBoard.display();

		// �����vs��ǻ��, �����vs�����, �����vs�����vs����� Ȯ��
		int gameType = 0;

		if (players[0].getPlayerType() == 1 || players[1].getPlayerType() == 1) {
			// �����vs��ǻ��
			if (players[1].getOrder() == 1) // ��ǻ�Ͱ� ��
				gameType = 1;
			else if (players[1].getOrder() == 2) // ����ڰ� ��
				gameType = 2;
		else if (players[0].getPlayerType() == 2 || players[1].getPlayerType() == 2)
			// �����vs�����
			gameType = 3;
		} else if (players[0].getPlayerType() == 3 || players[1].getPlayerType() == 3 || players[2].getPlayerType() == 3){
			// �����vs�����vs�����
			gameType = 4;
		}

		switch (gameType) {
		
		case 1:
			// ��ǻ�Ͱ� ��
			System.out.println("�����:�浹, ��ǻ��:�鵹�� �ڵ� �����˴ϴ�.");

			while (true) {
				boolean win = false;

				// ��ǻ��
				setTurn(2);
				System.out.println("<��> ��ǻ���� �����Դϴ�.");

				m = players[1].play(gameBoard);

				gameBoard.putStone(m.getRow(), m.getColumn(), StoneType.White);
				win = getCheckWinningCondition(m);

				gameBoard.display();

				int comRow = m.getRow() + 1;
				int comCol = m.getColumn() + 1;
				System.out.println("<��> ��ǻ�� : " + comRow + "�� " + comCol + "���� ����");

				if (win == true) {
					System.out.println("<��ǻ�� �¸�>");
					break;
				}

				// �����
				setTurn(1);
				System.out.println("<��> " + players[0].getID() + "(" + players[0].getName() + ") ���� �����Դϴ�.");

				while (true) {
					int userRow = 0;
					int userCol = 0;

					System.out.print("�� : ");
					userRow = s.nextInt();
					System.out.print("�� : ");
					userCol = s.nextInt();
					m = new Position(userRow - 1, userCol - 1);

					if (getCheckValidity(m) == true) {
						gameBoard.putStone(userRow - 1, userCol - 1, StoneType.Black);
						win = getCheckWinningCondition(m);
						break;
					} else {
						System.out.println("�̹� ���� �ֽ��ϴ�.");
					}
				}

				gameBoard.display();

				if (win == true) {
					System.out.println("<" + players[0].getID() + "(" + players[0].getName() + ") �¸�>");
					break;
				}
			}
			break;

		case 2:
			// ����ڰ� ��
			System.out.println("�����:�浹, ��ǻ��:�鵹�� �ڵ� �����˴ϴ�.");

			while (true) {
				boolean win = false;

				// �����
				setTurn(1);
				System.out.println("<��> " + players[0].getID() + "(" + players[0].getName() + ") ���� �����Դϴ�.");

				while (true) {
					int userRow = 0;
					int userCol = 0;

					System.out.print("�� : ");
					userRow = s.nextInt();
					System.out.print("�� : ");
					userCol = s.nextInt();
					m = new Position(userRow - 1, userCol - 1);

					if (getCheckValidity(m) == true) {
						gameBoard.putStone(userRow - 1, userCol - 1, StoneType.Black);
						win = getCheckWinningCondition(m);
						break;
					} else {
						System.out.println("�̹� ���� �ֽ��ϴ�.");
					}
				}

				gameBoard.display();

				if (win == true) {
					System.out.println("<" + players[0].getID() + "(" + players[0].getName() + ") �¸�>");
					break;
				}

				// ��ǻ��
				setTurn(2);
				System.out.println("<��> ��ǻ���� �����Դϴ�.");

				m = players[1].play(gameBoard);

				gameBoard.putStone(m.getRow(), m.getColumn(), StoneType.White);
				win = getCheckWinningCondition(m);

				gameBoard.display();

				int comRow = m.getRow() + 1;
				int comCol = m.getColumn() + 1;
				System.out.println("<��> ��ǻ�� : " + comRow + "�� " + comCol + "���� ����");

				if (win == true) {
					System.out.println("<��ǻ�� �¸�>");
					break;
				}
			}
			break;
			
		case 3:
			// �����vs�����
			System.out.println("ù��° ����:�浹, �ι�° ����:�鵹���� �ڵ� �����˴ϴ�.");

			while (true) {
				int firstPlayer = 0;
				int secondPlayer = 0;
				boolean win = false;

				for (int i = 0; i < 2; i++) {
					if (players[i].getOrder() == 1)
						firstPlayer = i;
					else if (players[i].getOrder() == 2)
						secondPlayer = i;
				}

				// 1�� �÷��̾� ����
				setTurn(1);
				System.out.println(
						"<��> " + players[firstPlayer].getID() + "(" + players[firstPlayer].getName() + ") ���� �����Դϴ�.");

				while (true) {
					int userRow = 0;
					int userCol = 0;

					System.out.print("�� : ");
					userRow = s.nextInt();
					System.out.print("�� : ");
					userCol = s.nextInt();
					m = new Position(userRow - 1, userCol - 1);

					if (getCheckValidity(m) == true) {
						gameBoard.putStone(userRow - 1, userCol - 1, StoneType.Black);
						win = getCheckWinningCondition(m);
						break;
					} else {
						System.out.println("�̹� ���� �ֽ��ϴ�.");
					}
				}

				gameBoard.display();

				if (win == true) {
					System.out.println("<�� �¸�>");
					break;
				}

				// 2�� �÷��̾� ����
				setTurn(2);
				System.out.println(
						"<��> " + players[secondPlayer].getID() + "(" + players[secondPlayer].getName() + ") ���� �����Դϴ�.");

				while (true) {
					int userRow = 0;
					int userCol = 0;

					System.out.print("�� : ");
					userRow = s.nextInt();
					System.out.print("�� : ");
					userCol = s.nextInt();
					m = new Position(userRow - 1, userCol - 1);

					if (getCheckValidity(m) == true) {
						gameBoard.putStone(userRow - 1, userCol - 1, StoneType.White);
						win = getCheckWinningCondition(m);
						break;
					} else {
						System.out.println("�̹� ���� �ֽ��ϴ�.");
					}
				}

				gameBoard.display();

				if (win == true) {
					System.out.println("<�� �¸�>");
					break;
				}
			}
			break;
			
		case 4:
			// �����vs�����vs�����
			System.out.println("ù��° ����:�浹, �ι�° ����:�鵹, ����° ����:������ �ڵ� �����˴ϴ�.");

			while (true) {
				int firstPlayer = 0;
				int secondPlayer = 0;
				int thirdPlayer = 0;
				boolean win = false;

				for (int i = 0; i < 3; i++) {
					if (players[i].getOrder() == 1)
						firstPlayer = i;
					else if (players[i].getOrder() == 2)
						secondPlayer = i;
					else if (players[i].getOrder() == 3)
						thirdPlayer = i;
				}

				// 1�� �÷��̾� ����
				setTurn(1);
				System.out.println(
						"<��> " + players[firstPlayer].getID() + "(" + players[firstPlayer].getName() + ") ���� �����Դϴ�.");

				while (true) {
					int userRow = 0;
					int userCol = 0;

					System.out.print("�� : ");
					userRow = s.nextInt();
					System.out.print("�� : ");
					userCol = s.nextInt();
					m = new Position(userRow - 1, userCol - 1);

					if (getCheckValidity(m) == true) {
						gameBoard.putStone(userRow - 1, userCol - 1, StoneType.Black);
						win = getCheckWinningCondition(m);
						break;
					} else {
						System.out.println("�̹� ���� �ֽ��ϴ�.");
					}
				}

				gameBoard.display();

				if (win == true) {
					System.out.println("<�� �¸�>");
					break;
				}

				// 2�� �÷��̾� ����
				setTurn(2);
				System.out.println(
						"<��> " + players[secondPlayer].getID() + "(" + players[secondPlayer].getName() + ") ���� �����Դϴ�.");

				while (true) {
					int userRow = 0;
					int userCol = 0;

					System.out.print("�� : ");
					userRow = s.nextInt();
					System.out.print("�� : ");
					userCol = s.nextInt();
					m = new Position(userRow - 1, userCol - 1);

					if (getCheckValidity(m) == true) {
						gameBoard.putStone(userRow - 1, userCol - 1, StoneType.White);
						win = getCheckWinningCondition(m);
						break;
					} else {
						System.out.println("�̹� ���� �ֽ��ϴ�.");
					}
				}

				gameBoard.display();

				if (win == true) {
					System.out.println("<�� �¸�>");
					break;
				}
				
				// 3�� �÷��̾� ����
				setTurn(3);
				System.out.println(
						"<��> " + players[thirdPlayer].getID() + "(" + players[thirdPlayer].getName() + ") ���� �����Դϴ�.");

				while (true) {
					int userRow = 0;
					int userCol = 0;

					System.out.print("�� : ");
					userRow = s.nextInt();
					System.out.print("�� : ");
					userCol = s.nextInt();
					m = new Position(userRow - 1, userCol - 1);

					if (getCheckValidity(m) == true) {
						gameBoard.putStone(userRow - 1, userCol - 1, StoneType.Red);
						win = getCheckWinningCondition(m);
						break;
					} else {
						System.out.println("�̹� ���� �ֽ��ϴ�.");
					}
				}

				gameBoard.display();

				if (win == true) {
					System.out.println("<�� �¸�>");
					break;
				}
			}
			break;

		default:
			break;
		}
	}
}
