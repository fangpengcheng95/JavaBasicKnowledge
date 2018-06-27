package com.fpc.Test;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BuyHeat {
	public static double area(int[][] array,int i , int j , int k) {
		
		double a = (double) Math.sqrt( (array[i][1] - array[j][1])*(array[i][1] - array[j][1]) +  
				(array[i][2] - array[j][2])*(array[i][2] - array[j][2]) + 
				(array[i][3] - array[j][3])*(array[i][3] - array[j][3]) );
		double b = (double) Math.sqrt( (array[i][1] - array[k][1])*(array[i][1] - array[k][1]) +  
				(array[i][2] - array[k][2])*(array[i][2] - array[k][2]) + 
				(array[i][3] - array[k][3])*(array[i][3] - array[k][3]) );
		double c = (double) Math.sqrt( (array[k][1] - array[j][1])*(array[k][1] - array[j][1]) +  
				(array[k][2] - array[j][2])*(array[k][2] - array[j][2]) + 
				(array[k][3] - array[j][3])*(array[k][3] - array[j][3]) );
		if ( a + b > c && a + c > b &&  c + b > a  && a>Math.abs(b-c) && b>Math.abs(a-c) && c>Math.abs(a-b) ) {
			return (double) (1.0/4.0 * Math.sqrt((a+b+c)*(a+b-c)*(a+c-b)*(b+c-a)));
		}
		return (double) -1.0f;
	}
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[][] array = new int[n][4];
		int sum = 0;
		for ( int i = 0 ; i < n ; i++ ) {
			String a = scanner.next();
			if ( a.equals("R") ) {
				array[i][0] = 0;
			}
			if ( a.equals("G") ) {
				array[i][0] = 1;
			}
			if ( a.equals("B") ) {
				array[i][0] = 2;
			}
			array[i][1] = scanner.nextInt();
			array[i][2] = scanner.nextInt();
			array[i][3] = scanner.nextInt();
		}
		
		double max = 0.0f;
		for ( int i = 0 ; i < n ; i++ ) {
			for ( int j = i+1 ; j < n ; j++ ) {
				for ( int k = j+1 ; k < n ; k++ ) {
					if ( ( array[i][0] == array[j][0] && array[i][0] == array[k][0]) || ( array[i][0] + array[j][0] + array[k][0] == 3 )) {
						max = Math.max( max, area(array,i,j,k) );
					}
				}
			}
		}
		
		System.out.format("%.5f", max);
//		for ( int i = 0 ; i < n ; i++ ) {
//				System.out.println(array[i][0] + " " + array[i][1] + " " + array[i][2] + " " + array[i][3] + " ");
//		}
	}
}
