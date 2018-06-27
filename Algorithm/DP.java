package com.fpc.Test;

import java.util.Scanner;

/*
 * 题目描述:度度熊最近对全排列特别感兴趣,对于1到n的一个排列,度度熊发现可以在中间根据大小关系插入合适的大于和小于符号(即 '>' 和 '<' )使其成为一个合法的不等式数列。
 * 但是现在度度熊手中只有k个小于符号即('<'')和n-k-1个大于符号(即'>'),度度熊想知道对于1至n任意的排列中有多少个排列可以使用这些符号使其为合法的不等式数列。
输入描述:
输出满足条件的排列数,答案对2017取模。
输入包括一行,包含两个整数n和k(k < n ≤ 1000)
 * 
 * */
public class DP {
	public static void main( String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[][] dp = new int[n+1][k+1];
		for ( int i = 1 ; i <= n ; i++ ) {
			dp[i][0] = 1;
		}
		for ( int i = 2 ; i <= n ; i++ ) {
			for ( int j = 1 ; j <= k ; j++ ) {
				dp[i][j] = (dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j] * j + dp[i-1][j-1] * ( i - 1 - j) ) % 2017;
			}
		}
		System.out.println(dp[n][k]);
	}
}
