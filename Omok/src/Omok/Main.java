package Omok;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		MyMatch mMatch = new MyMatch();

		while (true) {
			System.out.println("*******���� ���� ���α׷�*******");
			System.out.println("1. �÷��̾� �Է�");
			System.out.println("2. ���� ����");
			System.out.println("3. ����");
			System.out.println("****************************");
			System.out.print("��> ");
			int key = s.nextInt();

			switch (key) {
			case 1:
				mMatch.resisterPlayer();
				break;

			case 2:
				mMatch.gameStart();
				break;

			case 3:
				System.out.println("���α׷� ����");
				return;

			default:
				System.out.println("�Է� ����");
				break;
			}
		}
	}
}
