package com.fpc.Test;

import java.util.Scanner;

public class MtirxRank {
	
	public void showMetrix( int[][] metrix ) {
		int m = metrix.length;
		int n = metrix[0].length;
		for ( int i = 0 ; i < m ; i++ ) {
			for ( int j = 0 ; j < n ; j++ ) {
				System.out.print( metrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//某一行乘上某个值
	public void mulMetrix( int[][] metrix ,int rows, int value ) {
		for ( int i = 0 ; i < metrix[0].length ; i++ ) {
			metrix[rows][i] *= value;
		}
	}
	
	//某一行乘上某个值再加到某一行上去
	public void muladdMetrix( int[][] metrix ,int rows, int value , int newRows ) {
		for ( int i = 0 ; i < metrix[0].length ; i++ ) {
			metrix[newRows][i] += metrix[rows][i] * value;
		}
	}
	
	//交换某两行的值
	public void exchange( int[][] metrix ,int rows, int newRows ) {
		for ( int i = 0 ; i < metrix[0].length ; i++ ) {
			int temp = metrix[newRows][i];
			metrix[newRows][i] = metrix[rows][i];
			metrix[rows][i] = temp;
		}
	}
	
	
	public int getMetrixRank( int[][] metrix ) {
		int m = metrix.length;
		int n = metrix[0].length;
		int rank = 0; //代表秩
		boolean flag;
		for(int i = 0; i < n; i++) { 
			flag=true;
		     for(int j = rank;j < m; j++) {
		      if(metrix[j][i]!=0)
		       { if(j != rank) {
		          if(flag)
		       	   exchange(metrix ,j, rank );
		          else
		           { int t=metrix[j][i];
		             mulMetrix( metrix , j , metrix[rank][i]);
		             muladdMetrix( metrix ,rank, -t , j );
		           }
		         }
		       flag=false;
		       }
		     }
		     if(!flag) rank++;
		     showMetrix(metrix);
		 }
		return rank;
	}
	public static void main( String[] args ) {
		int m,n;
		/*
		
4 5
3 2 0 5 0
3 -2 3 6 -1
2 0 1 5 -3
1 6 -4 -1 4 


3 3
1 1 1
1 2 3
1 5 1

4 5
3 2 0 5 0
3 -2 3 6 -1
2 0 1 7 -3
1 6 -4 -1 4 

4 5
3 2 1 1 0
0 2 3 1 0
0 2 4 4 0
0 3 5 6 0

4 5
3 2 1 1 0
0 2 3 1 0
0 2 4 4 0
0 3 5 6 0

4 5
3 2 1 1 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
		 * */
		Scanner scanner = new Scanner(System.in);
		m = scanner.nextInt();
		n = scanner.nextInt();
		int[][] metrix = new int[m][n];
		for ( int i = 0 ; i < m ; i++ ) {
			for ( int j = 0 ; j < n ; j++ ) {
				metrix[i][j] = scanner.nextInt();
			}
		}
		MtirxRank m1 = new MtirxRank();
		int res = m1.getMetrixRank(metrix);
		System.out.println("the rank of metrix : " + res);
		m1.showMetrix(metrix);
	}
}
