package com.fpc.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolNew implements Runnable{
	private String ThreadName;
	
	public ThreadPoolNew( String ThreadName ) {
		this.ThreadName = ThreadName;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("线程 : " + ThreadName + " 正在执行 ！");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程 : " + ThreadName + " 执行完成 ！");
	}
	public static void main( String[] args ) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(5,10,200,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
		for ( int i = 0 ; i < 20 ; i++ ) {
			ThreadPoolNew t = new ThreadPoolNew(i+"");
			pool.execute(t);
			System.out.println("线程池中线程的数量:"+ pool.getCorePoolSize() +" 缓冲队列中等待的线程数: " + pool.getQueue().size() + "已经执行完成的线程数: " + pool.getCompletedTaskCount() );
		}
		pool.shutdown();
	}
}
