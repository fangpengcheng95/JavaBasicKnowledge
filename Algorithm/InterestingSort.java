package com.fpc.Test;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/*
*-1, -2, +3, +4, -5, -6, +7, +8£º
2
 * */
public class InterestingSort {
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int flag = -1;
		int sum = 0;
		int index = 0;
		for ( int i = 1; i <= n; i++ ) {
			if ( index == m ) {
				flag = -flag;
				index = 1;
			} else {
				index++;
			}
			sum += ( flag * i);
		}
		System.out.println(sum);
	}
}
