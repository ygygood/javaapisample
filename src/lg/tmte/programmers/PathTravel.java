package lg.tmte.programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class PathTravel {
    int cnt;
//    ArrayList<Ticket> ticketList;
//    ArrayList<Ticket> resultPath;
	boolean[] visit;
	String[] result;
	int idx = 0;
	
	public void dfs(int index, String[][] tickets) {
		visit[index] = true;
		String to = tickets[index][1];
		result[idx] = result[idx-1]+","+to+",";
		idx++;
		
		for(int i=0; i<tickets.length; i++) {
			if(!visit[i]) {
				if(tickets[i][0].equals(to))	dfs(i,tickets);
			}
		}
	}
    
	public String[] solution(String[][] tickets) {
        String[] answer = {};
        int ticketLength = tickets.length;
        cnt = 0;
        result = new String[ticketLength];
        visit = new boolean[ticketLength];
        for(int i=0; i < ticketLength; i++)	visit[i] = false;
        
        for(int i=0; i<ticketLength; i++) {
        	if(!visit[i]) {
        		result[idx++] = tickets[i][0];
        		System.out.println(result[idx-1]);
        		dfs(i,tickets);
        	}
        	 for(int j=0; j < ticketLength; j++)	visit[j] = false;
        }
        
//        boolean check = false;
        for(int i=0; i<idx; i++) {
        	System.out.println(result[i]);
        }
        
        
//        ticketList = new ArrayList<>();
//        resultPath = new ArrayList<>();
//        
//        int ticketCnt = tickets.length;
//        
//        // √ ±‚»≠
//        for(int i=0; i<ticketCnt; i++) {
//        	Ticket ticket = new Ticket(tickets[i][0],tickets[i][1],false);
//        	ticketList.add(ticket);
//        }
//        
//        for(int i=0; i<ticketCnt; i++) {
//        	if(!ticketList.get(i).isUsed()) {
//        		dfs(4,ticketList);
//        		if(cnt == ticketCnt) {
////        			System.out.println(i);
//        			System.out.println(resultPath.toString());
//        			resultPath.removeAll(ticketList);
//        		}else {
//        			resultPath.removeAll(ticketList);
//        		}
//        	}
//        	
//        	for(int j=0; j<ticketCnt; j++) {
//            	ticketList.get(j).setUsed(false);;
//            }
//        	
//        	cnt = 0;
//        }
        
        return answer;
    }
	
//	public void dfs(int i, ArrayList<Ticket> ticketList) {
//		Ticket ticket = ticketList.get(i);
//		resultPath.add(ticket);
//		cnt++;
//		ticket.setUsed(true);
////		System.out.println(ticketList.get(i).isUsed());
//		System.out.println("Ticket \t "+ticket.toString());
//		for(int j=0; j<ticketList.size(); j++) {
//			System.out.println("Next Ticket \t"+ticketList.get(j).toString());
//			if(!ticketList.get(j).isUsed() && ticketList.get(j).getFrom().equals(ticket.getTo())) {
//				System.out.println(ticketList.get(index));
//				System.out.println("go Dfs");
//				dfs(j,ticketList);
//			}
//		}
//	}
	
	public static void main(String[] args) {
//		String[][] tickets= {
//				{"ICN","JFK"},
//				{"HND","IAD"},
//				{"JFK","HND"}
//		};
		String[][] tickets= {
				{"ICN","SFO"},
				{"ICN","ATL"},
				{"SFO","ATL"},
				{"ATL","ICN"},
				{"ATL","SFO"}
		};
		
		new PathTravel().solution(tickets);
		
//		Stack<Integer> a;
	}
}

//class Ticket{
//	String from;
//	String to;
//	boolean used;
//	
//	public Ticket(String from, String to, boolean used) {
//		super();
//		this.from = from;
//		this.to = to;
//		this.used = used;
//	}
//	public String getFrom() {
//		return from;
//	}
//	public void setFrom(String from) {
//		this.from = from;
//	}
//	public String getTo() {
//		return to;
//	}
//	public void setTo(String to) {
//		this.to = to;
//	}
//	public boolean isUsed() {
//		return used;
//	}
//	public void setUsed(boolean used) {
//		this.used = used;
//	}
//	@Override
//	public String toString() {
//		return "Ticket [from=" + from + ", to=" + to + ", used=" + used + "]";
//	}
//	
//}
