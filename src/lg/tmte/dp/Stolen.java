package lg.tmte.dp;

import java.util.Arrays;

public class Stolen {
	public int solution(int[] money) {
        int answer = 0;
        
        int length = money.length;
        
        if(length == 3) {
        	answer = Math.max(Math.max(money[0], money[1]),money[2]);
        }else if(length == 4){
        	answer = Math.max(money[0]+money[2],money[1]+money[3]);
        }else {
        	int dp1[] = Arrays.copyOf(money, length);
            int dp2[] = Arrays.copyOf(money, length);
            
            dp1[length-4] = dp1[length-4] + dp1[length-2];
            
            for(int i=length-5; i>=0; i--) {
            	dp1[i] = dp1[i] + Math.max(dp1[i+2], dp1[i+3]);
            }
            
            System.out.println(length);
            System.out.println(dp2.length);
            dp2[length-3] = dp2[length-3]+ dp2[length-1];
            for(int i=length-4; i>=1; i--) {
            	dp2[i] = dp2[i] + Math.max(dp2[i+2], dp2[i+3]);
            }

            answer = Math.max(dp1[0], dp2[1]);
        }

        return answer;
    }
	
	public static void main(String[] args) {
		int[] money = {1,2,3,1,5,9,1};
		new Stolen().solution(money);
	}
}
