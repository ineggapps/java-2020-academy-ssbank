package bank;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankService bs = new BankService();
		int ch;

		while (true) {
			do {
				System.out.println("====== SS���� ======");
				System.out.println("1. ���� �߱�/���");
				System.out.println("2. �Ա�");
				System.out.println("3. ���");
				System.out.println("4. ���� ��ȯ");
				System.out.println("5. ȯ��");
				System.out.println("6. ����");
				System.out.print("�޴� ���� > ");
				ch = sc.nextInt();
			} while (ch < 1 || ch > 6);

			if (ch == 6) {
				break;
			}

			switch (ch) {
			case 1://���� �߱�/���
				bs.bankManage();
				break;
			case 2://�Ա�
				bs.bankIO();
				break;
			case 3://���
				bs.bankIO();
				break;
			case 4://���� ��ȯ
				bs.exchangeCoin();
				break;
			case 5://ȯ��
				bs.exchangeCurrency();
				break;
			}
		}
		sc.close();
	}
}
