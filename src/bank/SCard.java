package bank;

import java.util.Arrays;
import java.util.Random;

public class SCard {
	private User user;
	public SCard(User user) {
		this.user = user;
	}
	// OTP 만들기 (배열이 50개, 안에는 중복되지 않는 무작위 코드 (1~99)
	public int[] makeOTP() {
		int otp[] = new int[50];	 // 배열생성
		Random rnd = new Random(); 	// 랜덤생성

		for (int i = 0; i < 50; i++) { 		// 50번 반복
			otp[i] = rnd.nextInt(100) + 1; 	// 난수발생(1~100)
			for (int j = 0; j < i; j++) { 	// 중복제거
				if (otp[i] == otp[j]) { 	// 발생된 수가 겹칠경우
					i--; 					
					break;
				}
			}
		}
	
		System.out.println(Arrays.toString(otp)); // 배열 값 출력
		return otp; 
	}
}

