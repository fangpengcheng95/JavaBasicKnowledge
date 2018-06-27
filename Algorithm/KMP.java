package com.fpc.Test;

public class KMP {
	private String ptr;
	private String str;
	private int[] next;
	public KMP( String ptr , String str) {
		this.ptr = ptr;
		this.str = str;
		next = new int[str.length()];
	}
	public void calculatorNextArray() {
		next[0] = -1;
		int k = -1;
		for( int i = 1 ; i < str.length() ; i++ ) {
			while ( k != -1 && str.charAt(k+1) != str.charAt(i) ) {
				k = next[k];
			}
			if ( str.charAt(k+1) == str.charAt(i) ) {
				k++;
			}
			next[i] = k;
		}
	}
	
	public void KMPfind() {
		calculatorNextArray();
		int k = -1;
		for ( int i = 0 ;  i < ptr.length(); i++ ) {
			while ( k > -1 && str.charAt(k+1) != ptr.charAt(i) ) {
				k = next[k];
			}
			if ( str.charAt(k+1) == ptr.charAt(i) ) {
				k++;
				if ( k == str.length() - 1) {
					System.out.println( i - str.length() + 1);
					k = -1;
				}
			}
			
		}
	}

	public static void main( String[] args ) {
		KMP kmp = new KMP("bacbababadababacambabacaddababacasdsd","ababaca");
//		kmp.calculatorNextArray();
//		for ( int i = 0 ; i < kmp.next.length ; i++ ) {
//			System.out.print(kmp.next[i] + " ");
//		}
		kmp.KMPfind();
	}
}
