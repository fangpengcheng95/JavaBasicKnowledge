package com.fpc.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LRU1<K,V> extends LinkedHashMap<K, V> {
	private final int maxCapacity;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private final Lock lock = new ReentrantLock();
	public LRU1( int maxCapacity ) {
		super(maxCapacity,DEFAULT_LOAD_FACTOR,true);
		this.maxCapacity = maxCapacity;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		try {
			lock.lock();
			super.clear();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		try{
			lock.lock();
			return super.get(key);
		}finally {
			lock.unlock();
		}
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> arg0) {
		// TODO Auto-generated method stub
		return size() > this.maxCapacity;
	}

	@Override
	public V put(K arg0, V arg1) {
		// TODO Auto-generated method stub
		try {
			lock.lock();
			return super.put(arg0, arg1);
		} finally {
			lock.unlock();
		}
	}
	@Override
	public boolean containsValue(Object key) {
		// TODO Auto-generated method stub
		try {
			lock.lock();
			return super.containsKey(key);
		} finally {
			lock.unlock();
		}
		
	}
	
	public Collection<Map.Entry<K,V>> getAll(){
		try {
			lock.lock();
			return new ArrayList<Map.Entry<K,V>>(super.entrySet());
		} finally {
			lock.unlock();
		}
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		try {
			lock.lock();
			return super.size();
		} finally {
			lock.unlock();
		}
		
	}
	
	
}
