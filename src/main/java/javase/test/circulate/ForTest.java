package javase.test.circulate;

public class ForTest {

	public static String name;

	/**
	 * 功能 :
	 * 开发：zwwang 2015-11-9 上午9:41:26
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(forDemo());
	}
	
	public static String forDemo() {
		for (int i = 0; i < 10; i++) {
			if (i == 400) {
				return String.valueOf(i);
			}
		}
		System.out.println("end");
		return null;
	}

}
