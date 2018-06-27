package com.fpc.Test;

import java.util.Scanner;

public class GreedyQ {
	public int result = Integer.MIN_VALUE;
	public void recurision( int n , int days , int blocks ) {
		int remainBlocks = blocks - n;
		int reaminDays = days - 1;
		System.out.println(reaminDays + "  ---  " + remainBlocks);
		if ( remainBlocks >=  reaminDays ) {
			result = Math.max(result, n);
			System.out.println(result);
		} else if ( remainBlocks <  reaminDays ) {
			return;
		}
		recurision( n * 2 , days - 1 , blocks - n );
		recurision( n * 2 - 1 , days - 1 , blocks - n );
	}
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
        int m = scanner.nextInt();
        GreedyQ q = new GreedyQ();
        q.recurision(2, n, m);
        int res = q.result;
        System.out.println(res);
        
	}
}
