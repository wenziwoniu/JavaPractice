package javase.test.enums;

public class EnumTest {

	public static void main(String[] args) {
		Test test = Test.valueOf("excels");
		System.out.println(test.name());
	}
}
