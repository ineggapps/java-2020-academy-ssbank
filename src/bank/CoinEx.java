package bank;

public class CoinEx {
	private User user;
	public static final int[] UNIT = new int[] { 500, 100, 50, 10 };
	public static final int[] BILL_UNIT = new int[] { 50000, 10000, 5000, 1000 };

	public CoinEx(User user) {
		this.user = user;
	}

	// 동전 => 화폐 교환 메서드
	// 동전 INT배열 입력하면 화폐 INT배열이 출력됨
	public int[] exchange(int[] coin) {
		int bill[] = new int[BILL_UNIT.length];
		int sum, balanceCoin;

		// 총액 계산
		// 500원 20개
		// 100원 10개
		// 50원 10개
		// 10원 100개
		// => 500*20+100*10+50*10+100*10
		// => 10000+1000+500+1000=12000원
		// 나머지 500원은 교환이 되지 않음
		// 지폐는 1만원권 1장, 5천원권 0장 1천원권 2장
		sum = 0;
		for (int i = 0; i < UNIT.length; i++) {
			sum += UNIT[i] * coin[i];
		}

		balanceCoin = sum % 1000;
		System.out.printf("***** 화폐 교환금액: %d원.\n***** 반환 금액: %d\n", sum - balanceCoin, balanceCoin);
		// 화폐교환 시작
		for (int i = 0; i < BILL_UNIT.length; i++) {
			bill[i] = sum / BILL_UNIT[i];
			sum -= bill[i] * BILL_UNIT[i];
		}

		return bill;
	}

	public void printBills(int[] bill) {
		if (bill == null) {
			System.out.println("출력할 화폐가 없습니다.");
			return;
		}
		// 화폐 매수 결과 출력
		for (int i = 0; i < BILL_UNIT.length; i++) {
			System.out.printf("%d원권 %d장\n", BILL_UNIT[i], bill[i]);
		}
	}
}
