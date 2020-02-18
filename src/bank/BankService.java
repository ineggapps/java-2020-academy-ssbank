package bank;

import java.util.Scanner;

public class BankService {
	private Scanner sc = new Scanner(System.in);
	private User user = new User();
	// 생성자를 통한 의존관계 생성해야 함
	// 1. BankManage (발급 조회)
	BankManage bankManage = new BankManage(user);
	// 2. BankIO (입출금)
	BankIO bankIO = new BankIO(user);
	// 3. BankEx (환전)
	BankEx bankEx = new BankEx(user);
	// 4. CoinEx (동전교환)
	CoinEx coinEx = new CoinEx(user);
	// 5. SCard (보안카드)
	SCard scard = new SCard(user);

	// 계좌 발급 및 조회
	public void bankManage() {
		int ch;
		do {
			System.out.println("1. 발급");
			System.out.println("2. 조회");
			System.out.println("3. 이전 화면");
			System.out.print("선택 > ");
			ch = sc.nextInt();

			if (ch == 3) {
				break;
			}

			switch (ch) {
			case 1:
				System.out.println("발급되었습니다.");
				break;
			case 2:
				System.out.println("조회 완료. 거래 초기 화면으로 돌아갑니다.");
				break;
			}
		} while (ch < 1 || ch > 2);
	}

	// 입출금
	public void bankIO() {
		int ch;
		do {
			System.out.println("1. 입금");
			System.out.println("2. 출금");
			System.out.println("3. 이전 화면");
			System.out.print("선택 > ");
			ch = sc.nextInt();

			if (ch == 3) {
				break;
			}

			switch (ch) {
			case 1:
				System.out.println("입금 완료");
				break;
			case 2:
				System.out.println("출금 완료");
				break;
			}
		} while (ch < 1 || ch > 3);
	}

	// 환전
	public void exchangeCurrency() {
		int ch;
		do {
			System.out.println("1. 원화 => 달러");
			System.out.println("2. 원화 => 엔");
			System.out.println("3. 원화 => 위안");
			System.out.println("4. 이전 화면으로");
			ch = sc.nextInt();

			if (ch == 4) {
				break;
			}

			switch (ch) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;

			}
		} while (ch < 1 || ch > 4);
	}

	// 화폐를동전으로 교환하기
	public void exchangeCoin() {
		int ch;
		int unit[] = CoinEx.UNIT;
		int coin[] = new int[4];// 500원 100원 50원 10원
		do {
			System.out.println("1. 동전 금액 입력");
			System.out.println("2. 이전 화면으로");
			System.out.print(" > ");
			ch = sc.nextInt();

			if (ch == 1) {
				// 현재 금액 입력
				for (int i = 0; i < unit.length; i++) {
					System.out.printf("%d원 동전 몇 개 ? ", unit[i]);
					coin[i] = sc.nextInt();
				}
				coinEx.printBills(coinEx.exchange(coin));
			} else {
				break;
			}

		} while (ch < 1 || ch > 2);
	}

	// OTP 만들기
	public void OTP(UserVO userVO) {
		int ch;
		do {
			System.out.println("1. 생성 / 재발급");
			System.out.println("2. 이전 화면으로");
			ch = sc.nextInt();

			if (ch == 1) {
				// 메서드 호출
				scard.makeOTP();
			} else {
				break;
			}
		} while (ch < 1 || ch > 2);
	}
}
