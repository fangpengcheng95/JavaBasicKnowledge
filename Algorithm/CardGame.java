package com.fpc.Test;

/*
 * 
输入例子1:

3
2 7 4


输出例子1:

5*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class compare implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		int a = (int) arg0;
		int b = (int) arg1;
		return b - a;
	}
	
}
public class CardGame {
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		ArrayList list = new ArrayList<Integer>();
		for ( int i = 0 ; i < n ; i++ ) {
			list.add(scanner.nextInt());
		}
		Collections.sort(list, new compare());
		int cow = 0;
		int sheep = 0;
		for ( int i = 1 ; i <= n ; i++ ) {
			if ( i % 2 == 1) {
				cow += (int)list.get(i-1);
			} else {
				sheep += (int)list.get(i-1);
			}
		}
		System.out.println(cow - sheep);
	}
}
