package lg.tmte.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class DpCard {
	   public int solution(int[] left, int[] right) {
	        int answer = 0;
	        ArrayList<Integer> leftArrList =  new ArrayList<>();
	        for(int i=0; i<left.length; i++)	leftArrList.add(left[i]);
	        
	        /*
	         * 
	         * */
	        for(int i=0; i<right.length; i++) {
	        	if(right[i] > leftArrList.get(0)) {
	        		leftArrList.remove(0);
	        	}else {
	        		answer += right[i];
	        	}
	        }
	        
	        return answer;
	    }
	   
	   public static void main(String[] args) {
		   int[] left = {3,2,5};
		   int[] right = {2,4,1};
		   new DpCard().solution(left, right);
	   }
}
