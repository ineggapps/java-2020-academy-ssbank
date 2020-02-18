package bank;

public class UserVO {
	private String name;
	private String personNum;
	private String account;
	private String password;
	private BankBookVO bankBook;
	private int[] otp;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonNum() {
		return personNum;
	}

	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public BankBookVO getBankBook() {
		return bankBook;
	}

	public void setBankBook(BankBookVO bankBook) {
		this.bankBook = bankBook;
	}

	public int[] getOtp() {
		return otp;
	}

	public void setOtp(int[] otp) {
		this.otp = otp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
