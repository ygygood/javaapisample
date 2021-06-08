package lg.tmte.dfsbfs;

public class PNetwork {
	
	boolean visit[];
	
	public int solution(int n, int[][] computers) {
		int answer = 0;
		
		visit = new boolean[n];
		// 방문 노드 초기화
		for(int i=0; i<n; i++)	visit[i] = false;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(computers[i][j] == 1 && visit[j] == false) {
					dfs(j,computers);
					answer++;									// network 증가
				}
			}
		}
		return answer;
	}
	
	public void dfs(int idx, int[][] computers) {
		visit[idx] = true;
		System.out.println((idx+1)+" is visited");
		for(int i=0; i<computers.length; i++) {
			if(computers[idx][i] == 1 && visit[i] == false)	dfs(i,computers);
		}
	}
	
	public static void main(String[] args) {
		int n = 7;
		int[][] computers = {
				{1,1,0,0,0,0,1},
				{1,1,0,0,0,0,0},
				{0,0,1,1,0,0,0},
				{0,0,1,1,0,0,0},
				{0,0,0,0,1,1,1},
				{0,0,0,0,1,1,0},
				{1,0,0,0,1,0,1},
		};
		new PNetwork().solution(n, computers);
	}
}
