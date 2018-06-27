package com.fpc.Test;

public class ThreadFlag extends Thread {
	public volatile boolean stop = false;
	public void run() {
		while( !stop ) {
			System.out.println("Thread is running");
		}
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("week up from block.....");
			stop = true;
		}
		System.out.println("Thread is exiting");
	}
	
	
	public static void main( String[] args ) throws InterruptedException {
		ThreadFlag thread = new ThreadFlag();
		System.out.println("Starting Thread.......");
		thread.start();
		Thread.sleep(3000);
		thread.stop = true;
		thread.interrupt();//����ʱ�˳�����״̬
		Thread.sleep(3000); //���߳�����3���Ա�۲��߳�m1���ж����
		System.out.println("Stopping appliction....");
	}
}
