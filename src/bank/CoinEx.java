package bank;

public class CoinEx {
	private User user;
	public static final int[] UNIT = new int[] { 500, 100, 50, 10 };
	public static final int[] BILL_UNIT = new int[] { 50000, 10000, 5000, 1000 };

	public CoinEx(User user) {
		this.user = user;
	}

	// ���� => ȭ�� ��ȯ �޼���
	// ���� INT�迭 �Է��ϸ� ȭ�� INT�迭�� ��µ�
	public int[] exchange(int[] coin) {
		int bill[] = new int[BILL_UNIT.length];
		int sum, balanceCoin;

		// �Ѿ� ���
		// 500�� 20��
		// 100�� 10��
		// 50�� 10��
		// 10�� 100��
		// => 500*20+100*10+50*10+100*10
		// => 10000+1000+500+1000=12000��
		// ������ 500���� ��ȯ�� ���� ����
		// ����� 1������ 1��, 5õ���� 0�� 1õ���� 2��
		sum = 0;
		for (int i = 0; i < UNIT.length; i++) {
			sum += UNIT[i] * coin[i];
		}

		balanceCoin = sum % 1000;
		System.out.printf("***** ȭ�� ��ȯ�ݾ�: %d��.\n***** ��ȯ �ݾ�: %d\n", sum - balanceCoin, balanceCoin);
		// ȭ��ȯ ����
		for (int i = 0; i < BILL_UNIT.length; i++) {
			bill[i] = sum / BILL_UNIT[i];
			sum -= bill[i] * BILL_UNIT[i];
		}

		return bill;
	}

	public void printBills(int[] bill) {
		if (bill == null) {
			System.out.println("����� ȭ�� �����ϴ�.");
			return;
		}
		// ȭ�� �ż� ��� ���
		for (int i = 0; i < BILL_UNIT.length; i++) {
			System.out.printf("%d���� %d��\n", BILL_UNIT[i], bill[i]);
		}
	}
}
