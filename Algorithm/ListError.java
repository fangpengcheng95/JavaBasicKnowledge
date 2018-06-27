package com.fpc.Test;

import java.util.List;
import java.util.ArrayList;

public class ListError {
	public static void main( String[] args ) {
		List list = new ArrayList();
		list.add("hello1");
		list.add("hello2");
		list.add("hello3");
		list.add(4);
		System.out.println(list);
	}
}
