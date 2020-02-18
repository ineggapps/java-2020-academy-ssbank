package bank;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BankService {
	private Scanner sc = new Scanner(System.in);
	private User user = new User();
	// �����ڸ� ���� �������� �����ؾ� ��
	// 5. SCard (����ī��)
	SCard scard = new SCard();
	// 1. BankManage (�߱� ��ȸ)
	BankManage bankManage = new BankManage(user, scard);
	// 2. BankIO (�����)
	BankIO bankIO = new BankIO(user);
	// 3. BankEx (ȯ��)
	BankEx bankEx = new BankEx();
	// 4. CoinEx (������ȯ)
	CoinEx coinEx = new CoinEx();

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
				bankManage.issued();
				System.out.println("���� ���� ������� 5,000���� �ԱݵǾ����ϴ�.");
				break;
			case 2:
				bankManage.lookup();
				System.out.println("�ŷ� �ʱ� ȭ������ ���ư��ϴ�.");
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
			System.out.println("ȯ�� �� ��ȭ�� �������ּ���");
			System.out.println("1. USD(�̱� �޷�)");
			System.out.println("2. JPY(�Ϻ� ��)");
			System.out.println("3. CNY(�߱� ����)");
			System.out.println("4. ���� ȭ������");
			ch = sc.nextInt();
			if (ch == 4) {
				break;
			}
			System.out.println("ȯ���ҽ� ��ȭ �ݾ��� �Է��� �ּ���.");
			krw = sc.nextInt();
			NumberFormat kor = NumberFormat.getCurrencyInstance();
			System.out.print("�Է��Ͻ� �ݾ�" + kor.format(krw));
			switch (ch) {
			case 1:
				currency = BankEx.exchangeDollar(krw);
				NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
				System.out.print("��  USD(�̱��޷�)��" + us.format(currency) + "�Դϴ�.");
				break;
			case 2:
				currency = BankEx.exchangeYen(krw);
				NumberFormat jap = NumberFormat.getCurrencyInstance(Locale.JAPAN);
				System.out.print("�� JPY(�Ϻ� ��)��" + jap.format(currency) + "�Դϴ�.");
				break;
			case 3:
				currency = BankEx.exchangeYuan(krw);
				NumberFormat chi = NumberFormat.getCurrencyInstance(Locale.CHINA);
				System.out.print("��  CNY(�߱� ����)��" + chi.format(currency) + "�Դϴ�.\n");
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
