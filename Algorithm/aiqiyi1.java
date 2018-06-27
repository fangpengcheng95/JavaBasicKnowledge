package com.fpc.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class aiqiyi1 {
	private List<String> res = new ArrayList<String>();
	public String dictsort( String str ) {
	  int index = 0;
	  StringBuilder sb = new StringBuilder();
	  while ( index < str.length() ) {
		  int max_value = Integer.MIN_VALUE;
		  for ( int i = index ; i < str.length() ; i++ ) {
			  if ( max_value < str.charAt(i) ) {
				  max_value = str.charAt(i);
				  index = i;
			  }
		  }
		  sb.append((char)max_value);
		  index++;
	  }
	  return sb.toString();
	}

	public static void main( String[] args ) {
		aiqiyi1 aaa = new aiqiyi1();
		String res = aaa.dictsort("hello");
		System.out.println(res);
	}
}
