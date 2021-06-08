package com.ygygood.datastructure;

import java.util.ArrayList;
import java.util.Collections;

class Person implements Comparable<Person>{
	String name;
	int age;
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Person person) {
		// TODO Auto-generated method stub
		// 이름순으로 정렬
//		if(this.name.compareTo(person.name) > 0) return 1;
//		else	return -1;
		
		// 이름순으로 정렬하면서 이름이 동일하면 나이순으로 정렬
		if(this.name.compareTo(person.name) > 0) return 1;
		else if(this.name.compareTo(person.name) < 0) return -1;
		else {												// 이름이 같을 경우
			if(this.age > person.age)	return 1;
			else return -1;
		}
	}
}

public class ArrayListHandler {
	
	ArrayList<Person> personArrList;
	
	ArrayListHandler(){
		personArrList = new ArrayList<Person>();
		Person p1 = new Person("harry",33);
		Person p2 = new Person("bruth",32);
		Person p3 = new Person("henry",68);
		Person p4 = new Person("natali",25);
		Person p5 = new Person("hugo",13);
		Person p6 = new Person("hugo",15);
		Person p7 = new Person("henry",31);
		Person p8 = new Person("giyeon",35);
		Person p9 = new Person("son",28);
		
		personArrList.add(p1);
		personArrList.add(p2);
		personArrList.add(p3);
		personArrList.add(p4);
		personArrList.add(p5);
		personArrList.add(p6);
		personArrList.add(p7);
		personArrList.add(p8);
		personArrList.add(p9);
	}
	
	void sort() {
		Collections.sort(personArrList);
		System.out.println(personArrList.toString());
	}
	
	public static void main(String[] args) {
		ArrayListHandler arrayListHandler = new ArrayListHandler();
		arrayListHandler.sort();
	}
}
