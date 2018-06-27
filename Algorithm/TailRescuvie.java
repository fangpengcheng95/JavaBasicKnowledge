package com.fpc.Test;

public class TailRescuvie {
	//线性递归
	public int Rescuvie( int n) {
		return ( n == 1 )? 1 : n * Rescuvie(n - 1);
	}
	
    //封装用
	public int tailRescuvie( int n ) {
		return ( n == 0 ) ? 1 : tailRescuive( n , 1 );
	}
	//尾递归
	public int tailRescuive( int n , int a ) {
		return ( n == 1 ) ? a : tailRescuive( n - 1 , a * n);
	}
	
	public static void main( String[] args ) {
		TailRescuvie t = new TailRescuvie();
		System.out.println(t.Rescuvie(5));
		System.out.println(t.tailRescuvie(5));
		
	}
}
