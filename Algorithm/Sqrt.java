package com.fpc.Test;

public class Sqrt {
	public int mySqrt(int x) {
        double Xk = x;
        double Xk1 = x;
        do {
        	Xk = Xk1;
        	Xk1 = ( Xk + x / Xk) / 2;
        }while( Math.abs((Xk - Xk1)) > 0.0000001);
        return (int)Xk;
    }
	
	public static void main( String[] args ) {
		Sqrt s = new Sqrt();
		int res = s.mySqrt(3);
		System.out.println(res);
	}
}
