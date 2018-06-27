package com.fpc.Test;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/*
4
3 4 1 2 
 */
public class MaxMulti {
	public static void main(String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Long min_1 = Long.MAX_VALUE;
		Long min_2 = Long.MAX_VALUE;
		Long max_1 = Long.MIN_VALUE;
		Long max_2 = Long.MIN_VALUE;
		Long max_3 = Long.MIN_VALUE;
		for ( int i = 1 ; i <= n ; i++ ) {
			Long temp = scanner.nextLong();
			if ( i == 1 ) {
				min_1 = Math.min(temp, min_1);
				max_1 = Math.max(temp, max_1);
			} else if ( i == 2 ) {
				min_2 = Math.min(min_2 ,temp * (temp > 0 ? min_1 : max_1));
				max_2 = Math.max(max_2 , temp * (temp > 0 ? max_1 : min_1) );
				min_1 = Math.min(temp, min_1);
				max_1 = Math.max(temp, max_1);
			} else {
				max_3 = Math.max(max_3, temp * (temp > 0 ? max_2 : min_2));
				min_2 = Math.min(min_2 ,temp * (temp > 0 ? min_1 : max_1));
				max_2 = Math.max(max_2 , temp * (temp > 0 ? max_1 : min_1) );
				min_1 = Math.min(temp, min_1);
				max_1 = Math.max(temp, max_1);
			}
		}
		System.out.println(max_3);
	}
}
