package com.fpc.Test;
/*
 3 3 
1 100 
10 1000 
1000000000 1001 
9 10 1000000000
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
public class niuniufindJob {
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int firends_number = scanner.nextInt();
		int jobs_number = scanner.nextInt();
		ArrayList power = new ArrayList<Integer>();
		ArrayList salary = new ArrayList<Integer>();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for ( int i = 1 ; i <= jobs_number ; i++ ) {
			int a = scanner.nextInt();
			power.add(a);
			int b = scanner.nextInt();
			salary.add(b);
			map.put(a, b);
		}
		ArrayList power1 = new ArrayList<Integer>();
		for ( int i = 1 ; i <= firends_number ; i++ ) {
			int a = scanner.nextInt();
			power.add(a);
			power1.add(a);
			if ( !map.containsKey(a) ) {
				map.put(a, 0);
			}
		}
		Collections.sort(power);
		int m = 0;
		for ( int i = 0 ; i < power.size(); i++ ) {
			m = Integer.max(m, map.get(power.get(i)));
			map.put((Integer) power.get(i), m);
		}
		
		for ( int i = 0 ; i < power1.size() ; i++ ) {
			System.out.println(map.get(power1.get(i)));
		}
		scanner.close();
	}
}
