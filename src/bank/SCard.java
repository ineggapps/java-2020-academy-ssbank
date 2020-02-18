package bank;

import java.util.Arrays;
import java.util.Random;

public class SCard {
	// OTP ����� (�迭�� 50��, �ȿ��� �ߺ����� �ʴ� ������ �ڵ� (1~99)
	public int[] makeOTP() {
		int otp[] = new int[50];	 // �迭����
		Random rnd = new Random(); 	// ��������

		for (int i = 0; i < 50; i++) { 		// 50�� �ݺ�
			otp[i] = rnd.nextInt(100) + 1; 	// �����߻�(1~100)
			for (int j = 0; j < i; j++) { 	// �ߺ�����
				if (otp[i] == otp[j]) { 	// �߻��� ���� ��ĥ���
					i--; 					
					break;
				}
			}
		}
	
		System.out.println(Arrays.toString(otp)); // �迭 �� ���
		return otp; 
	}
}

