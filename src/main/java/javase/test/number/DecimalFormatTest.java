package javase.test.number;

import java.text.DecimalFormat;

public class DecimalFormatTest {

	/**
	 * 功能 :
	 * 开发：zwwang 2015-10-23 上午9:44:06
	 * @param args
	 */
	public static void main(String[] args) {
		DecimalFormat numFormat = new DecimalFormat("000");
		long id = 2345L;
		System.out.println(numFormat.format(id));
	}

}
