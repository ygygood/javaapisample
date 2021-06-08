package lg.tmte.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PChangeWord {
	boolean [] visit;
	int answer = 0;
    ArrayList<Integer> arrList;
    List<String> wordList;
	
	public int solution(String begin, String target, String[] words) {
		
		arrList = new ArrayList<>();
		wordList = new ArrayList<>();
		
		wordList = Arrays.asList(words);
		
        int length = words.length;
        visit = new boolean[length];
        for(int i=0; i<length ;i++)	visit[i] = false;
        
        
        if(wordList.contains(target)) {
        	 for(int i=0; i<length; i++) {
             	if(compareStr(begin,words[i]) == 1 && visit[i] == false && words[i].equals(target)) {
             		arrList.add(1);
             	}else if(compareStr(begin,words[i]) == 1 && visit[i] == false) {
             		dfs(i, target, words);
             	}
             	 for(int j=0; j<length ;j++)	visit[j] = false;
             }
        }else {
        	arrList.add(0);
        }
        Collections.sort(arrList);
        System.out.println(arrList.toString());
        answer = arrList.get(0);
        return answer;
    }
	
	public void dfs(int idx, String target, String[] words) {
		visit[idx] = true;
		answer++;
		if(compareStr(words[idx],target) == 1) {
			arrList.add(answer+1);
			answer = answer -1;
		}else {
			for(int i=0; i<words.length; i++){
				if(visit[i] == false && compareStr(words[idx], words[i]) == 1)
					dfs(i, target, words);
			}
		}
	}
	
	public int compareStr(String str1, String str2) {
		int result = 0;
		for(int i=0; i<str1.length(); i++){
			if(str1.charAt(i) != str2.charAt(i))	result++;
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
//		String[] words = {"hot","dot","dog","lot","log"};
		String[] words = {"hot","dot","dog","lot","log","cog"};
		new PChangeWord().solution(begin, target, words);
	}
}
