package lg.tmte.programmers;

public class DpSeoulToKyungsan {
	public int solution(int K, int[][] travel) {
        int answer = 0;

        int[] dp = new int[travel.length];
        dp[0] = Math.max(travel[0][1], travel[0][3]);
        
        for(int i=1; i<travel.length; i++) {
        	
        }
        

        return answer;
        
    }
	public static void main(String[] args) {
		int k = 1650;
		int[][] travel = {{500,200,200,100}
						,{800,370,300,120},
						{700,250,300,90}};
		new DpSeoulToKyungsan().solution(k, travel);
	}
}
