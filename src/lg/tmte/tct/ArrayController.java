package lg.tmte.tct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayController {
	
	public void start() {
//		sortArr();
		converToString();
	}
	
	/* 배열 정렬 */
	public void sortArr() {
		int[] arr = {5,4,9,7,8,1,3,5,4,8,7,6};
		Arrays.sort(arr);						// 1 3 4 4 5 5 6 7 7 8 8 9 
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	/* 배열을 string으로 변환 */
	public void converToString() {
		int[] arr = {5,4,9,7,8,1,3,5,4,8,7,6};
		String str = Arrays.toString(arr);
		System.out.println(str);
	}
	
	/* array to list */	//////////////////
	public void convertToList() {
		int[] arr = {5,4,9,7,8,1,3,5,4,8,7,6};
		List<int[]> arrList = Arrays.asList(arr);
		ArrayList<Integer> arrayList = (ArrayList)arrList;
		System.out.println(arrayList.toString());
	}
	
	public static void main(String[] args) {
		new ArrayController().start();
	}
}
