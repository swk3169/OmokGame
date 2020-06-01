package Omok;

public class MyBoard extends OmokBoard {
	public MyBoard() {
		super();
	}

	public MyBoard(int rows, int cols) {
		super(rows, cols);
	}

	public void initBoard() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				matrix[i][j] = StoneType.None;
			}
		}
	}

	public void setBoardSize(int BoardSize) {
		if (BoardSize == 0) {
			ROWS = 11;
			COLS = 11;
			matrix = new StoneType[11][11];
		} else if (BoardSize == 1) {
			ROWS = 15;
			COLS = 15;
			matrix = new StoneType[15][15];
		} else if (BoardSize == 2) {
			ROWS = 19;
			COLS = 19;
			matrix = new StoneType[19][19];
		}
	}

	public void display() {
		// ������ �� �� ��ȣ
		System.out.print("  ");
		for (int i = 0; i < getColCount(); i++) {
			System.out.print(String.format("%02d", i + 1));
			System.out.print(" ");
		}
		System.out.println();

		for (int i = 0; i < getRowCount(); i++) {
			System.out.print(String.format("%02d", i + 1)); // ������ ���� ��ȣ
			for (int j = 0; j < getColCount(); j++) {
				if (getStone(i, j) == StoneType.White) {
					System.out.print(" �� ");
				} else if (getStone(i, j) == StoneType.Black) {
					System.out.print(" �� ");
				} else if (getStone(i, j) == StoneType.Red) {
					System.out.print(" * ");
				} else if (getStone(i, j) == StoneType.None) {
					System.out.print("������");
				}
			}
			System.out.print(String.format("%02d", i + 1)); // ������ ������ ��ȣ
			System.out.println();
		}
		// ������ �Ʒ� �� ��ȣ
		System.out.print("  ");
		for (int i = 0; i < getColCount(); i++) {
			System.out.print(String.format("%02d", i + 1));
			System.out.print(" ");
		}
		System.out.println();
	}
}
