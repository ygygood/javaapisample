package lg.tmte.tct;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListController {
	
	public void init() {
	}
	
	public void start() {
		sortArrList();
	}
	
	public void sortArrList() {
		ArrayList<Integer> intArrList = new ArrayList<>();
		intArrList.add(2);intArrList.add(3);
		intArrList.add(1);intArrList.add(5);
		intArrList.add(4);
		System.out.println("========정렬 전=========");
		System.out.println(intArrList.toString());
		System.out.println("========정렬 후=========");
		Collections.sort(intArrList);
		System.out.println(intArrList.toString());
	}
	public static void main(String[] args) {
		new ArrayListController().start();
	}
}
