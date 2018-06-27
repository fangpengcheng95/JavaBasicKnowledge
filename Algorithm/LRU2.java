package com.fpc.Test;

import java.util.HashMap;
import java.util.Map;

class CacheNode{
	CacheNode pre;
	CacheNode next;
	Object key;
	Object value;
}
public class LRU2<K,V> {
	private int currentCacheSize;
	private int CacheCapcity;
	private HashMap<K,CacheNode> caches;
	private CacheNode first;
	private CacheNode last;
	
	public LRU2( int size ) {
		this.currentCacheSize = 0;
		this.CacheCapcity = size;
		this.caches = new HashMap<K,CacheNode>(size);
	}
	
	public void put( K k , V v) {
		CacheNode node = caches.get(k);
		if ( node == null ) {
			if ( caches.size() >= this.CacheCapcity ) {
				caches.remove(last.key);
				removeLast();
			}
			node = new CacheNode();
			node.key = k;
		}
		node.value = v;
		moveToFirst(node);
		caches.put(k, node);
	}
	
	public void removeLast() {
		if ( last != null ) {
			last = last.pre;
			if ( last == null ) {
				first = null;
			} else {
				last.next = null;
			}
		}
	}
	
	public void moveToFirst( CacheNode node ) {
		if ( first == node ) {
			return;
		}
		if ( node.next != null ) {
			node.next.pre = node.pre;
		}
		if ( node.pre != null ) {
			node.pre.next = node.next;
		}
		if ( node == last ) {
			last = last.pre;
		}
		
		if ( first == null || last == null ) {
			first = last = node;
			return;
		}
		node.next = first;
		first.pre = node;
		first = node;
		first.pre = null;
	}
	
	public Object get( K k) {
		CacheNode node = caches.get(k);
		if ( node == null ) {
			return null;
		}
		moveToFirst(node);
		return node;
	}
	
	public Object remove( K k ) {
		CacheNode node = caches.get(k);
		if ( node != null ) {
			if ( node.pre != null ) {
				node.pre.next = node.next;
			}
			
			if ( node.next != null ) {
				node.next.pre = node.pre;
			}
			
			if ( node == first ) {
				first = node.next;
			}
			
			if ( node == last ) {
				last = node.pre;
			}
			node = null;
		}
		return caches.remove(k);
	}
	
	public void clear() {
		first = null;
		last = null;
		caches.clear();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		CacheNode node = first;
		while ( node != null ) {
			sb.append(String.format("%s:%s ", node.key,node.value));
			node = node.next;
		}
		return sb.toString();
	}
	
	public static void main( String[] args ) {
		LRU2<Integer,String> lru = new LRU2<Integer,String>(3);

        lru.put(1, "a");    // 1:a
        System.out.println(lru.toString());
        lru.put(2, "b");    // 2:b 1:a 
        System.out.println(lru.toString());
        lru.put(3, "c");    // 3:c 2:b 1:a 
        System.out.println(lru.toString());
        lru.put(4, "d");    // 4:d 3:c 2:b  
        System.out.println(lru.toString());
        lru.put(1, "aa");   // 1:aa 4:d 3:c  
        System.out.println(lru.toString());
        lru.put(2, "bb");   // 2:bb 1:aa 4:d
        System.out.println(lru.toString());
        lru.put(5, "e");    // 5:e 2:bb 1:aa
        System.out.println(lru.toString());
        lru.get(1);         // 1:aa 5:e 2:bb
        System.out.println(lru.toString());
        lru.remove(11);     // 1:aa 5:e 2:bb
        System.out.println(lru.toString());
        lru.remove(1);      //5:e 2:bb
        System.out.println(lru.toString());
        lru.put(1, "aaa");  //1:aaa 5:e 2:bb
        System.out.println(lru.toString());
        
        Map<Integer,Integer> map = new HashMap();
        map.put(1, 2);
        map.put(2,3);
        for ( Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	System.out.println( entry.getKey() + "  " + entry.getValue());
        }
	}
}
