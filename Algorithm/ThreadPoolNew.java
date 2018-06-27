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
		System.out.println("�߳� : " + ThreadName + " ����ִ�� ��");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�߳� : " + ThreadName + " ִ����� ��");
	}
	public static void main( String[] args ) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(5,10,200,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
		for ( int i = 0 ; i < 20 ; i++ ) {
			ThreadPoolNew t = new ThreadPoolNew(i+"");
			pool.execute(t);
			System.out.println("�̳߳����̵߳�����:"+ pool.getCorePoolSize() +" ��������еȴ����߳���: " + pool.getQueue().size() + "�Ѿ�ִ����ɵ��߳���: " + pool.getCompletedTaskCount() );
		}
		pool.shutdown();
	}
}
