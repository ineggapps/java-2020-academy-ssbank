package bank;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankService bs = new BankService();
		int ch;

		while (true) {
			do {
				System.out.println("\n====== SS은행 ======");
				System.out.println("1. 계좌 발급/조회");
				System.out.println("2. 입출금");
				System.out.println("3. 동전 교환");
				System.out.println("4. 환전");
				System.out.println("5. 종료");
				System.out.print("메뉴 선택 > ");
				ch = sc.nextInt();
			} while (ch < 1 || ch > 6);

			if (ch == 5) {
				break;
			}

			switch (ch) {
			case 1://계좌 발급/폐기
				bs.bankManage();
				break;
			case 2://입출금
				bs.bankIO();
				break;
			case 3://동전 교환
				bs.exchangeCoin();
				break;
			case 4://환전
				bs.exchangeCurrency();
				break;
			}
		}
		sc.close();
	}
}
