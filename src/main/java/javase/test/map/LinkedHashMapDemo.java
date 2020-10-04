package javase.test.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.poifs.crypt.dsig.facets.Office2010SignatureFacet;


public class LinkedHashMapDemo {

	/**
	 * 功能 :
	 * 开发：zwwang 2015-12-23 下午2:33:20
	 * @param args
	 */
	public static void main(String[] args) {
		linkedHashMapTest();
	}
	
	private static void linkedHashMapTest() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("k1", "value1");
		map.put("k2", "value2");
		map.put("k3", "value3");
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			iterator.remove();
			System.out.println(map.size());
		}
			
		
	}

}
