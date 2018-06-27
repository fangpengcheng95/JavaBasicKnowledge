package com.fpc.Test;

import java.util.BitSet;
class SimpleHash{
	private int cap;
	private int seed;
	
	public SimpleHash( int cap , int seed ) {
		this.cap = cap;
		this.seed = seed;
	}
	
	public int hash( String value ) { //字符串哈希，选取好的哈希函数很重要
		int result = 0;
		int len = value.length();
		for ( int i = 0 ; i < len ; i++ ) {
			result = seed * result + value.charAt(i);
		}
		return ( cap - 1 ) & result;
	}
}
public class BloomFilter {
	private static final int DEFAULT_SIZE = 2 << 24; //布隆过滤器的比特长度
	private static final int[] seeds = { 3 , 5 , 7 , 11 , 13 , 31 , 37 , 61 };//这里要选取质数，能很好的降低错误率
	private static BitSet bits = new BitSet(DEFAULT_SIZE);
	private static SimpleHash[] func = new SimpleHash[seeds.length];
	
	public BloomFilter() {
		for ( int i = 0 ; i < seeds.length ; i++ ) {
			func[i] = new SimpleHash(DEFAULT_SIZE,seeds[i]);
		}
	}
	
	public static void addValue( String value ) {
		if ( value == null ) {
			return;
		}
		for ( SimpleHash f : func ) {
			bits.set(f.hash(value),true);
		}
	}
	
	public static boolean contains( String value ) {
		if ( value == null ) {
			return false;
		}
		boolean res = true;
		for ( SimpleHash f : func ) {
			res = res && bits.get(f.hash(value));
		}
		return res;
	}
	
	public static void main( String[] args ) {
		BloomFilter bb = new BloomFilter(); 
		String value = new String("bupterfpc");
		System.out.println(BloomFilter.contains(value));
		BloomFilter.addValue(value);
		System.out.println(BloomFilter.contains(value));
	}
}
