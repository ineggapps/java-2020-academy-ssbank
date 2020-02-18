package bank;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BankService {
	private Scanner sc = new Scanner(System.in);
	private User user = new User();
	// 생성자를 통한 의존관계 생성해야 함
	// 5. SCard (보안카드)
	SCard scard = new SCard();
	// 1. BankManage (발급 조회)
	BankManage bankManage = new BankManage(user, scard);
	// 2. BankIO (입출금)
	BankIO bankIO = new BankIO(user);
	// 3. BankEx (환전)
	BankEx bankEx = new BankEx();
	// 4. CoinEx (동전교환)
	CoinEx coinEx = new CoinEx();

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
				bankManage.issued();
				System.out.println("계좌 개설 기념으로 5,000원이 입금되었습니다.");
				break;
			case 2:
				bankManage.lookup();
				System.out.println("거래 초기 화면으로 돌아갑니다.");
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
				bankIO.input();
				break;
			case 2:
				bankIO.output();
				break;
			}
		} while (ch < 1 || ch > 3);
	}

	public void exchangeCurrency() {
		double krw;
		double currency = 0;
		int ch;
		do {
			System.out.println("환전 할 통화를 선택해주세요");
			System.out.println("1. USD(미국 달러)");
			System.out.println("2. JPY(일본 엔)");
			System.out.println("3. CNY(중국 위안)");
			System.out.println("4. 이전 화면으로");
			ch = sc.nextInt();
			if (ch == 4) {
				break;
			}
			System.out.println("환전할실 원화 금액을 입력해 주세요.");
			krw = sc.nextInt();
			NumberFormat kor = NumberFormat.getCurrencyInstance();
			System.out.print("입력하신 금액" + kor.format(krw));
			switch (ch) {
			case 1:
				currency = BankEx.exchangeDollar(krw);
				NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
				System.out.print("은  USD(미국달러)로" + us.format(currency) + "입니다.");
				break;
			case 2:
				currency = BankEx.exchangeYen(krw);
				NumberFormat jap = NumberFormat.getCurrencyInstance(Locale.JAPAN);
				System.out.print("은 JPY(일본 엔)로" + jap.format(currency) + "입니다.");
				break;
			case 3:
				currency = BankEx.exchangeYuan(krw);
				NumberFormat chi = NumberFormat.getCurrencyInstance(Locale.CHINA);
				System.out.print("은  CNY(중국 위안)로" + chi.format(currency) + "입니다.\n");
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
