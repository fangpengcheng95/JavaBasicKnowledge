package com.fpc.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class person{
	private String name;
	private int age;
	public person( String name , int age ) {
		this.name = name;
		this.age = age;
	}
	public void showInfo() {
		System.out.print(" Name : " + name + " Age : " + age + "       ");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

class personComparator implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		person p1 = (person) arg0;
		person p2 = (person) arg1;
		int nameResult = p1.getName().compareTo(p2.getName());
		if ( nameResult == 0 ) {
			return p1.getAge() - p2.getAge();
		}
		return nameResult;
	}
	
}
public class ComparableandComparator {
	public static void print( ArrayList list ) {
		for ( int i = 0 ; i < list.size() ; i++ ) {
			person p = (person)list.get(i);
			p.showInfo();
		}
		System.out.println();
	}
	public static void main( String[] args ) {
		person p1 = new person("fpc",23);
		person p2 = new person("sam",23);
		person p3 = new person("fpc",24);
		person p4 = new person("aa",29);
		ArrayList<person> list = new ArrayList<person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		Collections.sort(list,new personComparator());
		ComparableandComparator.print(list);
	}
}
