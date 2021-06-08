package com.ygygood.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HashMapHandler {
	
	HashMap<Integer,Integer> hashMap;
	
	HashMapHandler(){
		hashMap = new HashMap<>();
		hashMap.put(1, 101);
		hashMap.put(2, 214);
		hashMap.put(5, 114);
		hashMap.put(8, 102);
		hashMap.put(11, 365);
		hashMap.put(4, 887);
	}
	
	public void sort() {
		Iterator iter = sortByValue(hashMap).iterator();
		while(iter.hasNext()) { 
			int temp = (Integer) iter.next(); 
			System.out.println(temp + " = " + hashMap.get(temp)); }

	}
	
	public List sortByValue(HashMap map) {
		List<Integer> list = new ArrayList<>();
		list.addAll(map.keySet());
		
		Collections.sort(list,new Comparator() {

			@Override
			public int compare(Object arg0, Object arg1) {
				// TODO Auto-generated method stub
				Object v1 = map.get(arg0);
				Object v2 = map.get(arg1);
				return ((Comparable)v2).compareTo(v1);
			}
		});
		
		Collections.reverse(list);		// 주석시 내림차순
		return list;
	}
	
	public static void main(String[] args) {
		HashMapHandler hashMapHandler = new HashMapHandler();
		hashMapHandler.sort();
		
	}
}
