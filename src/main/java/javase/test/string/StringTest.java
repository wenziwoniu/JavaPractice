package javase.test.string;

import javase.test.pojo.POJO;

public class StringTest {

	/**
	 * 功能 :
	 * 开发：zwwang 2015-10-20 上午11:04:20
	 * @param args
	 */
	public static void main(String[] args) {
		//indexOfDemo();
		//lastIndexOf();
		//subStringDemo();
		POJO pojo = new POJO();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("abc");
		stringBuilder.append(pojo.getName());
		System.out.println(stringBuilder.toString());
		String result = pojo.getName() + "abc";
		System.out.println(result.length());
	}
	
	/**
	 * 功能 :查找指定子字符串在字符串中的起始位置
	 */
	public static void indexOfDemo() {
		String testString = "a-bcdabc-dab-";
		//返回第一次出现的指定子字符串在此字符串中的索引
		System.out.println(testString.indexOf("-"));
		//从指定的索引处开始（包含索引处的字符），返回第一次出现的指定子字符串在此字符串中的索引
		System.out.println(testString.indexOf("-", 1));
		System.out.println(testString.indexOf("-", -3));
		//若指定字符串中没有该字符则系统返回-1 
	    System.out.println(testString.indexOf("x")); 
	}
	
	/**
	 * 功能 :查找指定子字符串在字符串中最右边的位置
	 */
	public static void lastIndexOf() {
		String test = "a-aba-";
		/**
		 * int lastIndexOf(String str)
		 * 返回在此字符串中最右边出现的指定子字符串的索引
		 */
		System.out.println(test.lastIndexOf("a"));
		/**
		 * int lastIndexOf(String str, int startIndex)
		 * 从指定的索引处（包含索引处字符）开始向后搜索，返回在此字符串中最后一次出现的指定子字符串的索引。
		 * 此例中，从指定索引处开始向后搜索，即搜索的字符串为“a-ab”  最后一次是指最右方。
		 */
		System.out.println(test.lastIndexOf("a", 3));
		//若指定字符串中没有该字符则系统返回-1 
		System.out.println(test.lastIndexOf("x"));
	}
	
	/**
	 * 功能 :截取字符串
	 */
	public static void subStringDemo() {
		String test = "ab_de";
		//从指定索引位置开始（包括索引位置）截取字符串
		System.out.println(test.substring(3));
		//从指定起始索引位置（包括索引位置）到指定结束索引位置（不包括索引位置）截取字符串
		System.out.println(test.substring(0, 3));
		
		//从后向前截取n个字符  String.substring(String.length() - n)
		System.out.println(test.substring(test.length() - 2));
		
		//截取从开始到指定符号结束的字符
		int index = test.indexOf("_");
		System.out.println(test.substring(0, index));
		
		//截取从指定字符串下一位置到结束的字符
		System.out.println(test.substring(index + 1));
		
	}
	

}
