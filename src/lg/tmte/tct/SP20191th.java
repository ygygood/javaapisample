package lg.tmte.tct;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 코로나 전파자 검색
 * 
 *                                1
 *                 2              3              4
 *           5          6     7         8    9        10
 *        11    12    13    14 15      16     17    18  19
 * **/

class CovidGraph{
	
	class Person{
		int id;
		int depth;
		boolean marked;
		LinkedList<Person> adjcents;
		Person(int id){
			this.id = id;
			depth = 0;
			marked = false;
			adjcents = new LinkedList<Person>();
		}
	}
	
	ArrayList<Person> personList;
	int depth = 0;
 	CovidGraph(){
		personList = new ArrayList<>();
	}
	
	void addPerson(int id1, int id2) {
		boolean check = false;
		Person tmpP = null;
		for(Person p : personList) {
			if(p.id == id1) {
				check = true;
				tmpP = p;
				break;
			}
		}
		
		if(check) {							// 기존에 등록된 id1 일 경우
			Person p2 = new Person(id2);
			personList.add(p2);
			tmpP.adjcents.add(p2);			// 연결
		}else {								// 처음 등록된 id1일 경우
			Person p1 = new Person(id1);
			Person p2 = new Person(id2);
			personList.add(p1);
			personList.add(p2);
			p1.adjcents.add(p2);			// 연결
		}
	}
	void addEdge(Person p1, Person p2) {
		if(!p1.adjcents.contains(p2)) {		// p1이 p2를 child로 안가지고 있을 경우
			p1.adjcents.add(p2);
		}
		if(!p2.adjcents.contains(p1)) {
			p2.adjcents.add(p1);
		}
	}
	void dfs(int id) {
		for(Person p : personList) {
			if(p.id == id) {
				dfsR(p);
				p.depth = depth-1;
				depth = 0;
				System.out.println();
				System.out.print("depth of "+p.id +" is "+p.depth);
			}
		}
	}
	void dfsR(Person p) {
		if(p == null)	return;
		p.marked = true;
		visit(p);
		depth++;
		for(Person tmp : p.adjcents) {
			if(tmp.marked == false)	dfsR(tmp);
		}
	}
	void visit(Person p){
		System.out.print(p.id+" ");
	}
}/*
*                                1
*                 2              3              4
*           5          6     7         8    9        10
*        11    12    13    14 15      16     17    18  19
*/
public class SP20191th {
	public static void main(String[] args) {
		CovidGraph graph = new CovidGraph();
		graph.addPerson(1,2);		graph.addPerson(1,3);		graph.addPerson(1,4);
		graph.addPerson(2,5);	graph.addPerson(2,6);	graph.addPerson(3,7);	graph.addPerson(3,8);	graph.addPerson(4,9);	graph.addPerson(4,10); 
		graph.addPerson(5,11);	graph.addPerson(5,12);	graph.addPerson(6,13);	graph.addPerson(7,14);	graph.addPerson(7,15);	graph.addPerson(8,16);	graph.addPerson(9,17);
		graph.addPerson(10,18);	graph.addPerson(10,19);
		
		graph.dfs(10);
	}
}
