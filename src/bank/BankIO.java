package bank;

import java.util.Scanner;

public class BankIO {
	private User user;

	public BankIO(User user) {
		this.user = user;
	}

	Scanner sc = new Scanner(System.in);

	public void input() {
		int input = 0;
		int n = 0;
		String ac;
		UserVO vo;
		BankBookVO bvo;
		do {
			System.out.print("���¹�ȣ�� �Է��ϼ���.");
			ac = sc.next();
			vo = user.getList(ac);
			if (vo == null) {
				System.out.println("���¹�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				return;
			}
			bvo = vo.getBankBook();
			if (bvo == null || !bvo.getBbNum().equals(ac)) {
				System.out.println("���¹�ȣ Ʋ�Ƚ��ϴ�.");
				return;
			}
			System.out.print("�ݾ��� �Է��ϼ���.");
			input = sc.nextInt();
			if (input <= 0) {
				System.out.println("�Է� �� �ݾ��� �ʹ� �۽��ϴ�.");
				return;
			}
			System.out.printf("�Ա� �� �ݾ��� %d\n���� �½��ϱ�? [���:1 ���:2]", input);
			n = sc.nextInt();
			if (n == 1) {
				System.out.printf("%d �Ա� �Ǿ����ϴ�.", input);
				deposit(input, ac);
			}
		} while (input == 2);
		print(bvo);
	}

	public void deposit(int deposit, String ac) {
		UserVO vo = user.getList(ac);
		BankBookVO bb = vo.getBankBook();
		long balance = bb.getBalance();
		bb.setBalance(balance + deposit);
	}

	public void print(BankBookVO vo) {
		System.out.println("�ܾ�: " + vo.getBalance());
	}

	public void output() {
		String ac, pw;
		int output = 0;
		System.out.print("��� �� ���¹�ȣ�� �Է��ϼ���.");
		ac = sc.next();
		UserVO vo = user.getList(ac);
		if (vo == null) {
			System.out.println("���¹�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			return;
		}
		BankBookVO bvo = vo.getBankBook();
		if (bvo == null || !bvo.getBbNum().equals(ac)) {
			System.out.println("���¹�ȣ Ʋ�Ƚ��ϴ�.");
			return;
		}
		System.out.print("�ݾ��� �Է��ϼ���.");
		output = sc.nextInt();
		if (output <= 0) {
			System.out.println("�Է� �� �ݾ��� �ʹ� �۽��ϴ�.");
			return;
		}
		System.out.print("��й�ȣ�� �Է��ϼ���.");
		pw = sc.next();
		String pp = vo.getPassword();
		if (!pp.equals(pw)) {
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			return;
		}
		draw(output, vo.getAccount());
		print(user.getList(ac).getBankBook());
	}

	public void draw(int deposit, String ac) {
		UserVO vo = user.getList(ac);
		BankBookVO bb = vo.getBankBook();
		long balance = bb.getBalance();
		long after = balance-deposit;
		if(after>=0) {
			bb.setBalance(after);
			System.out.println("��ݵǾ����ϴ�. ");
		}else {
			System.out.println("�ܾ��� �����Ͽ� ����Ͻ� �� �����ϴ�.");
		}
	}
}
