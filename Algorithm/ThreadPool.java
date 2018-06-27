package com.fpc.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThreadPool implements Callable<Object>{
	private String ThreadName;
	public ThreadPool( String ThreadName ) {
		this.ThreadName = ThreadName;
	}
	
	@Override
	public Object call() throws Exception{
		System.out.println(">>>>>>�߳�"+ ThreadName +"����");
		Date startTime = new Date();
		Thread.sleep(10000);
		Date endTime = new Date();
		long time = endTime.getTime() - startTime.getTime(); 
		return "�߳�"+ ThreadName +"���� " + "��ʼʱ��: " + startTime.toString() + " ����ʱ��: " +endTime.toString() + " ����ʱ��: " + time;
	}
	
	
	public static void main( String[] args ) throws InterruptedException, ExecutionException {
		int taskSize = 10;
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		List<Future> list = new ArrayList<Future>();
		for ( int i = 0 ; i < taskSize ; i++ ) {
			ThreadPool t = new ThreadPool( i + "");
			Future f = pool.submit(t);
			list.add(f);
		}
		
		for ( int i = 0 ; i < taskSize ; i++ ) {
			System.out.println(list.get(i).get());
		}
	}
}
