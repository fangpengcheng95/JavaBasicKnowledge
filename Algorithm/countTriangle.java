package com.fpc.Test;

import java.util.Scanner;

/*
4
0 0
0 1
1 0
1 1
 */
public class countTriangle {
	private static double eps =  1e-8;
	public static boolean isTriangle( int[][] array , int i , int j , int k ) {
		double a = (double)Math.sqrt( (array[i][0] - array[j][0])*(array[i][0] - array[j][0]) +
                (array[i][1] - array[j][1])*(array[i][1] - array[j][1]));
		double b = (double)Math.sqrt( (array[i][0] - array[k][0])*(array[i][0] - array[k][0]) +
                (array[i][1] - array[k][1])*(array[i][1] - array[k][1]));
		double c = (double)Math.sqrt( (array[k][0] - array[j][0])*(array[k][0] - array[j][0]) +
                (array[k][1] - array[j][1])*(array[k][1] - array[j][1]));
		if ( a + b - c > eps && a + c -b > eps &&  c + b - a > eps  && a - Math.abs(b-c) > eps && b - Math.abs(a-c) > eps && c - Math.abs(a-b) > eps  ) {
			return true;
		}
		return false;
	}
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] array = new int[n][2];
		for ( int i = 0 ; i < n ; i++ ) {
			array[i][0] = scanner.nextInt();
			array[i][1] = scanner.nextInt();
		}
		
		int count = 0;
		for ( int i = 0 ; i < n ; i++ ) {
			for ( int j = i+1 ; j < n ; j++ ) {
				for ( int k = j+1 ;k < n ; k++ ) {
					if ( isTriangle(array , i, j, k) ) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
