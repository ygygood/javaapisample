package lg.tmte.programmers;

import java.util.Arrays;

public class EntranceCountry {
	public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;
        long max = (long)n*times[times.length-1];
        long mid = 0;
        long sum;
        long answer = max;
        
        while(min <= max) {
        	sum = 0;
        	mid = (min+max)/2;
        	for(int time : times) {
        		sum += mid/time;
        	}
        	
        	if(sum >= n) {
        		if(mid < answer) {
        			answer = mid;
        		}
        		max = mid-1;
        	}else {
        		min = mid + 1;
        	}
        	
        }
        System.out.println(answer);
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 6;
		int []times = {7,10};
		new EntranceCountry().solution(n, times);
	}
}
