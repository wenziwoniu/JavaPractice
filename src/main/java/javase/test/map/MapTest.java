package javase.test.map;

import java.util.HashMap;
import java.util.Map;

import javase.test.pojo.POJO;

public class MapTest {

	/**
	 * 功能 :a
	 * 开发：zwwang 2015-12-17 下午5:11:35
	 * @param args
	 */
	public static void main(String[] args) {

//		modifyMap();
//		removeMap();
		castMapDemo();
	}
	
	/**
	 * 功能 : 即使map里不含Key 或该key值为null  也可以进行对象类型转换  转换的结果为null
	 * 开发：zwwang 2015-12-17 下午7:32:02
	 */
	public static void mapGetDemo() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("k1", null);
		String test = (String) map.get("k1");
		String test1 = (String) map.get("k2");
		if (test1 == null) {
			System.out.println("null23");
		}
		if (test == null) {
			System.out.println("null456");
		}
	}
	
	public static void modifyMap() {
		Map<Object, POJO> map = new HashMap<Object, POJO>();
		POJO pojo = new POJO();
		pojo.setName("wang");
		map.put("name", pojo);
		POJO pojo2 = map.get("name");
		pojo2.setName("xiali");
		System.out.println(map.get("name").getName());
	}
	
	public static void removeMap() {
		Map<String, String> map = new HashMap<String,  String>();
		map.put("key1", "wang");
		map.put("key2", "xia");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals("key1")) {
				map.remove("key1");
			}
		}
	}
	
	public static void castMapDemo() {
		String test = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test", 256);
		test = map.get("test").toString();
		if (map.get("tt") == null) {
			System.out.println("abc");
		}
	}

}
