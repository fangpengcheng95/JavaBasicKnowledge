package com.fpc.Test;

import java.util.Scanner;
public class BagDynamic {
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for ( int i = 1 ; i <= n ; i++ ) {
			int number_product = scanner.nextInt();
			int capacity = scanner.nextInt();
			int[] Volum = new int[number_product + 1];
			int[] Price = new int[number_product + 1];
			
			for ( int j = 1 ; j <= number_product; j++ ) {
				Price[j] = scanner.nextInt();
			}
			
			for ( int j = 1 ; j <= number_product; j++ ) {
				Volum[j] = scanner.nextInt();
			}
			
			int[][] dp = new int[number_product+1][capacity+1];
			
			for ( int j = 1 ; j <= number_product ; j++ ) {
				for ( int v = 0 ; v <= capacity ; v++ ) {
					if ( Volum[j] <= v ) {
						dp[j][v] = Integer.max(dp[j-1][v], dp[j-1][v - Volum[j]] + Price[j]);
					} else {
						dp[j][v] = dp[j-1][v];
					}
				}
			}
			System.out.println(dp[number_product][capacity]);
		}
	}
}
