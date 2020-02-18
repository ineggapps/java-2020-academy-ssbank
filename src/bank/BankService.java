package bank;

import java.util.Scanner;

public class BankService {
	private Scanner sc = new Scanner(System.in);
	private User user = new User();
	// �����ڸ� ���� �������� �����ؾ� ��
	// 1. BankManage (�߱� ��ȸ)
	BankManage bankManage = new BankManage(user);
	// 2. BankIO (�����)
	BankIO bankIO = new BankIO(user);
	// 3. BankEx (ȯ��)
	BankEx bankEx = new BankEx(user);
	// 4. CoinEx (������ȯ)
	CoinEx coinEx = new CoinEx(user);
	// 5. SCard (����ī��)
	SCard scard = new SCard(user);

	// ���� �߱� �� ��ȸ
	public void bankManage() {
		int ch;
		do {
			System.out.println("1. �߱�");
			System.out.println("2. ��ȸ");
			System.out.println("3. ���� ȭ��");
			System.out.print("���� > ");
			ch = sc.nextInt();

			if (ch == 3) {
				break;
			}

			switch (ch) {
			case 1:
				System.out.println("�߱޵Ǿ����ϴ�.");
				break;
			case 2:
				System.out.println("��ȸ �Ϸ�. �ŷ� �ʱ� ȭ������ ���ư��ϴ�.");
				break;
			}
		} while (ch < 1 || ch > 2);
	}

	// �����
	public void bankIO() {
		int ch;
		do {
			System.out.println("1. �Ա�");
			System.out.println("2. ���");
			System.out.println("3. ���� ȭ��");
			System.out.print("���� > ");
			ch = sc.nextInt();

			if (ch == 3) {
				break;
			}

			switch (ch) {
			case 1:
				System.out.println("�Ա� �Ϸ�");
				break;
			case 2:
				System.out.println("��� �Ϸ�");
				break;
			}
		} while (ch < 1 || ch > 3);
	}

	// ȯ��
	public void exchangeCurrency() {
		int ch;
		do {
			System.out.println("1. ��ȭ => �޷�");
			System.out.println("2. ��ȭ => ��");
			System.out.println("3. ��ȭ => ����");
			System.out.println("4. ���� ȭ������");
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

	// ȭ�󸦵������� ��ȯ�ϱ�
	public void exchangeCoin() {
		int ch;
		int unit[] = CoinEx.UNIT;
		int coin[] = new int[4];// 500�� 100�� 50�� 10��
		do {
			System.out.println("1. ���� �ݾ� �Է�");
			System.out.println("2. ���� ȭ������");
			System.out.print(" > ");
			ch = sc.nextInt();

			if (ch == 1) {
				// ���� �ݾ� �Է�
				for (int i = 0; i < unit.length; i++) {
					System.out.printf("%d�� ���� �� �� ? ", unit[i]);
					coin[i] = sc.nextInt();
				}
				coinEx.printBills(coinEx.exchange(coin));
			} else {
				break;
			}

		} while (ch < 1 || ch > 2);
	}

	// OTP �����
	public void OTP(UserVO userVO) {
		int ch;
		do {
			System.out.println("1. ���� / ��߱�");
			System.out.println("2. ���� ȭ������");
			ch = sc.nextInt();

			if (ch == 1) {
				// �޼��� ȣ��
				scard.makeOTP();
			} else {
				break;
			}
		} while (ch < 1 || ch > 2);
	}
}
