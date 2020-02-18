package bank;

public class User {
	private UserVO[] list;
	private int count;

	public User() {
		allocation(10);
	}

	private void allocation(int capacity) {
		UserVO[] temp = new UserVO[capacity];
		if (list != null && count > 0) {
			System.arraycopy(list, 0, temp, 0, count);
		}
		list = temp;
	}

	public UserVO[] getList() {
		return list;
	}

	public UserVO getList(int idx) {
		if (idx >= count || idx < 0) {
			return null;
		}
		return list[idx];
	}

	public int getCount() {
		return count;
	}

}
