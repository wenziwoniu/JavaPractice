package javase.test.type;

import javase.test.pojo.POJO;

public class StringTest {

	/**
	 * 功能 :
	 * 开发：zwwang 2015-10-12 上午11:05:19
	 * @param args
	 */
	public static void main(String[] args) {
		POJO pojo = new POJO();
		String stringTest = "" + pojo.getAmount();
		System.out.println(stringTest);
	}

}
