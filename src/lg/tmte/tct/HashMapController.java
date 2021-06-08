package lg.tmte.tct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HashMapController {
	
	public void start() {
		sortHashMap();
	}
	
	/* value 기준으로 정렬 */
	public void sortHashMap() {
		HashMap<String,String> hashMap = new HashMap<>();
		hashMap.put("2","d");
		hashMap.put("1","b");
		hashMap.put("5","e");
		hashMap.put("3","a");
		hashMap.put("4","c");
		
		Iterator iter = sortByValue(hashMap).iterator();
		while(iter.hasNext()) {
			String temp = (String) iter.next();
			System.out.println(temp + " = " + hashMap.get(temp));
		}
	}
	
	//별도의 스태틱 함수로 구현
	public static List sortByValue(final HashMap map) {
		List<String> list = new ArrayList();
		list.addAll(map.keySet());
	
		Collections.sort(list,new Comparator() {
			public int compare(Object o1,Object o2) {
			Object v1 = map.get(o1);
			Object v2 = map.get(o2);
		
			return ((Comparable) v2).compareTo(v1);
			}
		});
//		Collections.reverse(list); // 주석시 내림차순
		return list;
	}
	
	public static void main(String[] args) {
		new HashMapController().start();
	}
}
