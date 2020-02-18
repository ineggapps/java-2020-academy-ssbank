package bank;

import java.util.Arrays;
import java.util.Scanner;

public class BankManage {
	// 발급조회
	private Scanner sc = new Scanner(System.in);
	private User user;
	private SCard scard;

	public BankManage(User user, SCard scard) {
		this.user = user;
		this.scard = scard;
	}

	// 발급 메서드
	public void issued() {
		System.out.println("계좌 발급 정보를 등록해주세요...");
		UserVO vo = new UserVO();

		System.out.print("이름?");
		vo.setName(sc.next());

		String personNum = null;
		do {
			System.out.print("주민번호?");
			// vo.setPersonNum(sc.next());
			personNum = sc.next();
			personNum = personNum.replaceAll("-", "");
//			System.out.println(personNum+"\n"+personNum.length());
			if (personNum.length() > 13) {
				System.out.println("주민번호가 올바르게 입력되지 않았습니다. 다시 입력해주세요.");
			}
		} while (personNum == null || personNum.length() > 15);
		vo.setPersonNum(personNum);

		System.out.print("계좌번호?\n");
		System.out.println("*저희는 고객님의 편의성을 위해 전화번호로 계좌를 생성하실 수 있습니다.\n전화번호를 입력해주세요");
		vo.setAccount(sc.next());

		System.out.print("비밀번호?");
		vo.setPassword(sc.next());

		System.out.print("계좌 발급 완료...\n");

		// 발급된 계좌 번호
		BankBookVO bvo = new BankBookVO();
		System.out.print("계좌번호:");
		bvo.setBbNum(vo.getAccount());
		bvo.setBalance(5000);

		System.out.println(bvo.getBbNum());

//		 발급된 otp출력
		System.out.println("otp:");
		vo.setOtp(scard.makeOTP());
		// 발급된 계좌수만큼 count
		vo.setBankBook(bvo);
		user.append(vo);

	}

	// 조회 메서드
	public void lookup() {
		System.out.println("\n조회할 계좌 정보를 입력해주세요...");

		UserVO[] list = user.getList(); // 데이터 넘겨 받음
		int cnt = user.getCount();

		// 계좌번호, 비밀번호

		System.out.println("계좌번호 입력:");
		String account = sc.next();

		System.out.println("비밀번호 입력:");
		String password = sc.next();
		
		// 위의 정보가 list가 가지고 있는 정보하고 같은지 확인
		for (int i = 0; i < cnt; i++) {
			if (account.equals(list[i].getAccount()) && password.equals(list[i].getPassword())) {

				System.out.println("이름:" + list[i].getName());
				// System.out.println("주민번호:"+list[i].getPersonNum());
				System.out.println("계좌번호:" + list[i].getAccount());
				System.out.println("비밀번호:" + list[i].getPassword());
//				System.out.println(list[i].getBankBook());
				System.out.println("잔액:" + list[i].getBankBook().getBalance());
				System.out.println("OTP:" + Arrays.toString(list[i].getOtp()));
				System.out.println("================================");
				// 계좌조회 시, 잔액도 조회가 되어야 합니다.

			} else {
				System.out.println("정보가 일치하지 않아서 계좌 조회를 할 수 없습니다.");
				System.out.println("================================");
			}

		}

	}

}