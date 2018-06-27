package com.fpc.Test;
public class Base{
	private void a () {
		System.out.println("hello");
	}
	
	public static void main( String[] args ) {
		aac c = new aac();
		c.a();
	}
}
class aac extends Base{
	public void a() {
		System.out.println("word");
	}
	
	
}