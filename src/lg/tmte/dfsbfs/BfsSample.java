package lg.tmte.dfsbfs;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BfsSample {

}

class Graph{
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		Node(int data){
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}
	Node[] nodes;
	Graph(int size){
		nodes = new Node[size];
		for(int i=0; i<size; i++) nodes[i] = new Node(i);
	}
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2))	n1.adjacent.add(n2);
		if(!n2.adjacent.contains(n1))	n2.adjacent.add(n1);
	}
}

class Queue<T> {
	class Node<T>{
		private T data;
		private Node<T> next;
		private Node<T> first;
		private Node<T> last;
		
		public Node(T data) {
			this.data = data;
		}
		
		public void add(T item) {
			Node<T> t = new Node<T>(item);
			if(last != null)	last.next = t;
			last = t;
			if(first == null)	first = last;
		}
		
		public T remove() {
			if(first == null)	throw new NoSuchElementException();
			
			T data = first.data;
			first = first.next;
			
			if(first == null)	last = null;
			
			return data;
		}
		
		public T peek() {
			if(first == null)	throw new NoSuchElementException();
			return first.data;
		}
		
		public boolean isEmpty() {
			return first == null;
		}
	}
}