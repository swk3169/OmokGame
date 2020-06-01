package Omok;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		MyMatch mMatch = new MyMatch();

		while (true) {
			System.out.println("*******오목 게임 프로그램*******");
			System.out.println("1. 플레이어 입력");
			System.out.println("2. 게임 시작");
			System.out.println("3. 종료");
			System.out.println("****************************");
			System.out.print("ㅡ> ");
			int key = s.nextInt();

			switch (key) {
			case 1:
				mMatch.resisterPlayer();
				break;

			case 2:
				mMatch.gameStart();
				break;

			case 3:
				System.out.println("프로그램 종료");
				return;

			default:
				System.out.println("입력 오류");
				break;
			}
		}
	}
}
