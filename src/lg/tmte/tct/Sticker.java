package lg.tmte.tct;

public class Sticker {
	
	public void solution(int[] sticker) {

		int answer = 0;

        int len = sticker.length;

        if (len == 1) {
        	System.out.println(sticker[0]);
        }

        int[] dp1 = new int[len];
        int[] dp2 = new int[len];

        //ù��° ��ƼĿ�� ���� ���
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i = 2; i < len-1;i++) {
        	System.out.println("dp1["+(i-1)+"]:"+dp1[i-1]+"//dp1["+(i-2)+"]:"+dp1[i-2]+"+"+sticker[i]);
        	dp1[i] = Math.max(dp1[i-1],dp1[i-2] + sticker[i]);
        	System.out.print(dp1[i]+" ");
        }


        //ù��° ��ƼĿ�� ���� �ʴ� ���
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < len; i++) dp2[i] = Math.max(dp2[i-1],dp2[i-2] + sticker[i]);

        answer = Math.max(dp1[len-2],dp2[len-1]);
		
		
	}
	
	public static void main(String[] args) {
	
		int[] sticker = {14,6,5,11,3,9,2,10};
		new Sticker().solution(sticker);
	}
}
