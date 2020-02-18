package bank;

public class BankEx {
	private static double usd = 1189.20;
	private static double jpy = 1083.60;
	private static double cny = 169.89;

	public static double exchangeDollar(double krw) {
		return krw / usd;
	}

	public static double exchangeYen(double krw) {
		return krw / jpy * 100;
	}

	public static double exchangeYuan(double krw) {
		return krw / cny;
	}

}
