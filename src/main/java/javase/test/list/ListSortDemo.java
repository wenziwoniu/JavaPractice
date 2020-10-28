package javase.test.list;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javase.test.pojo.POJO;

public class ListSortDemo {

	/**
	 * 功能 : List排序
	 * 开发：zwwang 2016-1-5 下午5:25:34
	 * @param args
	 */
	public static void main(String[] args) {
		listSort();
//		listComplexSort();
	}
	
	public static void listSort() {
		List<String> list = new ArrayList<String>();
		list.add("ab");
		list.add("a");
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		Collections.sort(list, new Comparator<String>() {

			public int compare(String o1, String o2) {
				BigDecimal bigDecimal = new BigDecimal(o1);
				BigDecimal bigDecimal2 = new BigDecimal(o2);
				return bigDecimal.compareTo(bigDecimal2);
			}
		});
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void listComplexSort() {
		List<POJO> list = new ArrayList<POJO>();
		POJO pojo = new POJO();
		pojo.setName("b");
		pojo.setAmount(10L);
		POJO pojo2 = new POJO();
		pojo2.setName("a");
		pojo2.setAmount(40L);
		POJO pojo3 = new POJO();
		pojo3.setName("a");
		pojo3.setAmount(30L);
		list.add(pojo);
		list.add(pojo2);
		list.add(pojo3);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + list.get(i).getAmount());
		}
		Collections.sort(list, new Comparator<POJO>() {

			/**
			 * 功能 : 根据name升序排序  name相同时根据amount升序排序
			 * 开发：zwwang 2016-1-5 下午6:07:12
			 * @param o1
			 * @param o2
			 * @return
			 *//*
			@Override
			public int compare(POJO o1, POJO o2) {
				if (o1.getName().compareTo(o2.getName()) == 0) {
					return o1.getAmount().compareTo(o2.getAmount());
				}
				return o1.getName().compareTo(o2.getName());
			}*/

			/**
			 * 功能 : o1.getName().compareTo(o2.getName()) 对name进行升序排序
			 * o2.getName().compareTo(o1.getName()) 对name进行降序排序
			 * 开发：zwwang 2016-1-5 下午6:01:02
			 * @param o1
			 * @param o2
			 * @return
			 */
			/**
			 * 功能 :
			 * 开发：zwwang 2016-1-5 下午6:07:04
			 * @param o1
			 * @param o2
			 * @return
			 */
			public int compare(POJO o1, POJO o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + list.get(i).getAmount());
		}
	}

}
