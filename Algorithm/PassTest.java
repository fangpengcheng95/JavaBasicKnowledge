package com.fpc.Test;

import java.util.Scanner;
public class PassTest {
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n+1];
		double[][] dp = new double[n+1][n+1];
		for ( int i = 1 ; i <= n ; i++ ) {
			array[i] = scanner.nextInt();
		}
		dp[0][0] = 1;
		for ( int i = 1 ; i<= n; i++ ) {
			for( int j = 0 ; j <= i ; j++ ) {
				double p = (double)( array[i] / 100.0 );
				if ( j == 0 ) {
					dp[i][j] = dp[i-1][j] * (1 - p);
				} else {
					dp[i][j] = dp[i-1][j] * ( 1 - p ) + dp[i - 1][j - 1] * p; 
				}
				
			}
		}
		double b = n * 0.6;
		int a = (int)(b);
		if ( b - a > 0.00001 ) {
			a++;
		}
		double res = 0.0f;
		for ( int i = n ; i >= a ; i-- ) {
			res += dp[n][i];
		}
		System.out.format("%.5f", res);
	}
}
