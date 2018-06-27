package com.fpc.Test;

import java.util.Random;
public class random {
	public int rand7() {
		Random rand = new Random();
		return rand.nextInt(7) + 1;
	}
	
	public int rand10() {
		int a1 = rand7();
		int a2 = rand7();
		while ( (a1 * 7 + a2) >= 40 ) {
			a1 = rand7();
			a2 = rand7();
		}
		return (a1 * 7 + a2) / 4 + 1;
	}
	
	public static void main( String[] args ) {
		random r = new random();
		System.out.println(r.rand10());
	}
}
