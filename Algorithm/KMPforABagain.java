package com.fpc.Test;

import java.util.Scanner;
public class KMPforABagain {
	
	public int[] calculcatorNextArray( String ptr ) {
		int[] next = new int[ptr.length()];
		next[0] = -1;
		int k = -1;
		for ( int i = 0 ; i < ptr.length(); i++ ) {
			while ( k > -1 && ptr.charAt(k+1) != ptr.charAt(i)) {
				k = next[k];
			}
			if ( ptr.charAt(k+1) == ptr.charAt(i) ) {
				k++;
			}
		}
		return next;
	}
	
	public int KMP( String str , String ptr ) {
		int[] next = calculcatorNextArray(ptr);
		int k = -1;
		for ( int i = 0 ; i < str.length() ; i++ ) {
			while ( k > -1 && ptr.charAt(k+1) != str.charAt(i) ) {
				k = next[k];
			}
			if ( ptr.charAt(k+1) == str.charAt(i) ) {
				k++;
				if ( i == str.length() - 1) {
					return k+1;
				}
			}
			if ( k == ptr.length() - 1) {
				k = -1;
			}
		}
		return 0;
	}
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
		String str = scanner.next();
		String ptr = scanner.next();
		StringBuilder sb = new StringBuilder();
		KMPforABagain kmp1 = new KMPforABagain();
		int a = kmp1.KMP(str, ptr);
		int b = kmp1.KMP(ptr, str);
		System.out.println(a + " ------ " + b);
		if ( a > b ) {
			sb.append(str);
			sb.append(ptr.substring(a, ptr.length()));
		} else if ( a == b ) {
			if ( str.compareTo(ptr) > 0  ) {
				sb.append(ptr);
				sb.append(str.substring(b, str.length()));
			} else {
				sb.append(str);
				sb.append(ptr.substring(a, ptr.length()));
			}
		}
		else {
			sb.append(ptr);
			sb.append(str.substring(b, str.length()));
		}
		System.out.println(sb.toString());
		}
	}
}
