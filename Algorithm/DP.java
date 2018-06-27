package com.fpc.Test;

import java.util.Scanner;

/*
 * ��Ŀ����:�ȶ��������ȫ�����ر����Ȥ,����1��n��һ������,�ȶ��ܷ��ֿ������м���ݴ�С��ϵ������ʵĴ��ں�С�ڷ���(�� '>' �� '<' )ʹ���Ϊһ���Ϸ��Ĳ���ʽ���С�
 * �������ڶȶ�������ֻ��k��С�ڷ��ż�('<'')��n-k-1�����ڷ���(��'>'),�ȶ�����֪������1��n������������ж��ٸ����п���ʹ����Щ����ʹ��Ϊ�Ϸ��Ĳ���ʽ���С�
��������:
�������������������,�𰸶�2017ȡģ��
�������һ��,������������n��k(k < n �� 1000)
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
