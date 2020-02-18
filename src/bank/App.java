package bank;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankService bs = new BankService();
		int ch;

		while (true) {
			do {
				System.out.println("\n====== SS���� ======");
				System.out.println("1. ���� �߱�/��ȸ");
				System.out.println("2. �����");
				System.out.println("3. ���� ��ȯ");
				System.out.println("4. ȯ��");
				System.out.println("5. ����");
				System.out.print("�޴� ���� > ");
				ch = sc.nextInt();
			} while (ch < 1 || ch > 6);

			if (ch == 5) {
				break;
			}

			switch (ch) {
			case 1://���� �߱�/���
				bs.bankManage();
				break;
			case 2://�����
				bs.bankIO();
				break;
			case 3://���� ��ȯ
				bs.exchangeCoin();
				break;
			case 4://ȯ��
				bs.exchangeCurrency();
				break;
			}
		}
		sc.close();
	}
}
