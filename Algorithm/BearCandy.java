package com.fpc.Test;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
2 5
5 6 10 20 30
4 34
3 35
*/
class BearSort implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = (ArrayList<Integer>) arg0;
		ArrayList<Integer> b = (ArrayList<Integer>) arg1;
		return b.get(1) - a.get(1);
	}
}

public class BearCandy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		ArrayList<Integer> candy = new ArrayList<Integer>();
		for (int i = 1; i <= m; i++) {
			candy.add(scanner.nextInt());
		}
		Collections.sort(candy);
		ArrayList<ArrayList<Integer>> bear = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(i);
			temp.add(scanner.nextInt());
			temp.add(scanner.nextInt());
			bear.add(temp);
		}
		Collections.sort(bear, new BearSort());
		int[] res = new int[n + 1];
		for (int i = 0; i < bear.size(); i++) {
			int hungry = bear.get(i).get(2);
			for ( int j = candy.size() - 1 ; hungry > 0 && j >= 0; j-- ) {
				if (candy.get(j) > 0 && candy.get(j) <= hungry) {
					bear.get(i).set(2, hungry - candy.get(j));
					hungry -= candy.get(j);
					candy.set(j, 0);
				}
			}
		}
		for ( int i = 0 ; i < bear.size() ; i++  ) {
			res[bear.get(i).get(0)] = bear.get(i).get(2);
		}
		for (int i = 1; i <= n; i++) {
			System.out.println(res[i]);
		}
		scanner.close();
	}
}
