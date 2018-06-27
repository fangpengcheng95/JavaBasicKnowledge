package com.fpc.Test;

import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class google2011 {
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int[] A = {1,2,3,4,5};
		int[] B = {2,4,6,7,8};
		Map map = new HashMap<Integer,Integer>();
		for ( int i = 0 ; i < A.length ; i++ ) {
			map.put(A[i], 1);
		}
		List res = new ArrayList<Integer>();
		for ( int j = 0 ; j < B.length; j++ ) {
			if ( map.containsKey(B[j]) ) {
				res.add(B[j]);
			}
		}
		System.out.println(res);
	}
}
