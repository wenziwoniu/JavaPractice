package javase.test.list;

import java.util.ArrayList;
import java.util.List;

import javase.test.pojo.POJO;

public class ListTest {

	/**
	 * 功能 :
	 * 开发：zwwang 2015-11-13 下午4:38:05
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	String teString = null;
		List<String> list = new ArrayList<String>();
		list.add("abc");
		System.out.println(list.contains(teString));*/
		removeList();
		System.out.println("a");
	}
	
	public static void modifyList() {
		List<POJO> list = new ArrayList<POJO>();
		POJO pojo = new POJO();
		pojo.setName("wang");
		list.add(pojo);
		System.out.println(list.get(0).getName());
		POJO pojo2 = new POJO();
		pojo2 = list.get(0);
		pojo2.setName("xia");
		System.out.println(list.get(0).getName());
	}
	
	public static void removeList() {
		List<POJO> list = new ArrayList<POJO>();
		POJO pojo = new POJO();
		pojo.setName("wang");
		list.add(pojo);
		POJO pojo2 = new POJO();
		pojo2.setName("xia");
		list.add(pojo2);
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				System.out.println("a");
				list.remove(0);
			}
		}
	}

}
