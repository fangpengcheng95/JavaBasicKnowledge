package com.fpc.Test;

/*
 
输入例子1:

5 2

输出例子1:

7
 */
import java.util.Scanner;
public class shudui {
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		Long res = (long)0;
		if ( k == 0 ) {
			res = (long)n*(long)n;
		} else {
			for ( int y = k + 1 ; y <= n ; y++ ) {
				int factory = n / y;
				res += factory * ( y - k); 
				res += Integer.max(0, n - (factory * y) - k + 1 );
			}
		}
		System.out.println(res);
	}
}
