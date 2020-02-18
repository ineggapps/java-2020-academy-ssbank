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
			System.out.print("계좌번호를 입력하세요.");
			ac = sc.next();
			vo = user.getList(ac);
			if (vo == null) {
				System.out.println("계좌번호를 잘못 입력하셨습니다.");
				return;
			}
			bvo = vo.getBankBook();
			if (bvo == null || !bvo.getBbNum().equals(ac)) {
				System.out.println("계좌번호 틀렸습니다.");
				return;
			}
			System.out.print("금액을 입력하세요.");
			input = sc.nextInt();
			if (input <= 0) {
				System.out.println("입력 한 금액이 너무 작습니다.");
				return;
			}
			System.out.printf("입금 할 금액이 %d\n원이 맞습니까? [계속:1 취소:2]", input);
			n = sc.nextInt();
			if (n == 1) {
				System.out.printf("%d 입금 되었습니다.", input);
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
		System.out.println("잔액: " + vo.getBalance());
	}

	public void output() {
		String ac, pw;
		int output = 0;
		System.out.print("출금 할 계좌번호를 입력하세요.");
		ac = sc.next();
		UserVO vo = user.getList(ac);
		if (vo == null) {
			System.out.println("계좌번호를 잘못 입력하셨습니다.");
			return;
		}
		BankBookVO bvo = vo.getBankBook();
		if (bvo == null || !bvo.getBbNum().equals(ac)) {
			System.out.println("계좌번호 틀렸습니다.");
			return;
		}
		System.out.print("금액을 입력하세요.");
		output = sc.nextInt();
		if (output <= 0) {
			System.out.println("입력 한 금액이 너무 작습니다.");
			return;
		}
		System.out.print("비밀번호를 입력하세요.");
		pw = sc.next();
		String pp = vo.getPassword();
		if (!pp.equals(pw)) {
			System.out.println("비밀번호가 틀렸습니다.");
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
			System.out.println("출금되었습니다. ");
		}else {
			System.out.println("잔액이 부족하여 출금하실 수 없습니다.");
		}
	}
}
