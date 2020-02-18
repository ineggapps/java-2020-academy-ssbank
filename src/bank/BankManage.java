package bank;

import java.util.Arrays;
import java.util.Scanner;

public class BankManage {
	// �߱���ȸ
	private Scanner sc = new Scanner(System.in);
	private User user;
	private SCard scard;

	public BankManage(User user, SCard scard) {
		this.user = user;
		this.scard = scard;
	}

	// �߱� �޼���
	public void issued() {
		System.out.println("���� �߱� ������ ������ּ���...");
		UserVO vo = new UserVO();

		System.out.print("�̸�?");
		vo.setName(sc.next());

		String personNum = null;
		do {
			System.out.print("�ֹι�ȣ?");
			// vo.setPersonNum(sc.next());
			personNum = sc.next();
			personNum = personNum.replaceAll("-", "");
//			System.out.println(personNum+"\n"+personNum.length());
			if (personNum.length() > 13) {
				System.out.println("�ֹι�ȣ�� �ùٸ��� �Էµ��� �ʾҽ��ϴ�. �ٽ� �Է����ּ���.");
			}
		} while (personNum == null || personNum.length() > 15);
		vo.setPersonNum(personNum);

		System.out.print("���¹�ȣ?\n");
		System.out.println("*����� ������ ���Ǽ��� ���� ��ȭ��ȣ�� ���¸� �����Ͻ� �� �ֽ��ϴ�.\n��ȭ��ȣ�� �Է����ּ���");
		vo.setAccount(sc.next());

		System.out.print("��й�ȣ?");
		vo.setPassword(sc.next());

		System.out.print("���� �߱� �Ϸ�...\n");

		// �߱޵� ���� ��ȣ
		BankBookVO bvo = new BankBookVO();
		System.out.print("���¹�ȣ:");
		bvo.setBbNum(vo.getAccount());
		bvo.setBalance(5000);

		System.out.println(bvo.getBbNum());

//		 �߱޵� otp���
		System.out.println("otp:");
		vo.setOtp(scard.makeOTP());
		// �߱޵� ���¼���ŭ count
		vo.setBankBook(bvo);
		user.append(vo);

	}

	// ��ȸ �޼���
	public void lookup() {
		System.out.println("\n��ȸ�� ���� ������ �Է����ּ���...");

		UserVO[] list = user.getList(); // ������ �Ѱ� ����
		int cnt = user.getCount();

		// ���¹�ȣ, ��й�ȣ

		System.out.println("���¹�ȣ �Է�:");
		String account = sc.next();

		System.out.println("��й�ȣ �Է�:");
		String password = sc.next();
		
		// ���� ������ list�� ������ �ִ� �����ϰ� ������ Ȯ��
		for (int i = 0; i < cnt; i++) {
			if (account.equals(list[i].getAccount()) && password.equals(list[i].getPassword())) {

				System.out.println("�̸�:" + list[i].getName());
				// System.out.println("�ֹι�ȣ:"+list[i].getPersonNum());
				System.out.println("���¹�ȣ:" + list[i].getAccount());
				System.out.println("��й�ȣ:" + list[i].getPassword());
//				System.out.println(list[i].getBankBook());
				System.out.println("�ܾ�:" + list[i].getBankBook().getBalance());
				System.out.println("OTP:" + Arrays.toString(list[i].getOtp()));
				System.out.println("================================");
				// ������ȸ ��, �ܾ׵� ��ȸ�� �Ǿ�� �մϴ�.

			} else {
				System.out.println("������ ��ġ���� �ʾƼ� ���� ��ȸ�� �� �� �����ϴ�.");
				System.out.println("================================");
			}

		}

	}

}