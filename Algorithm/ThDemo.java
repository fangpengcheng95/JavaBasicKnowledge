package com.fpc.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThDemo implements Callable<Object>{
	private String ThreadName;
	public ThDemo( String name ) {
		ThreadName = name;
	}
	
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>" + ThreadName + "任务启动");
		Date date1 = new Date();
		Thread.sleep(1000);
		Date date2 = new Date();
		long time = date2.getTime() - date1.getTime(); 
		System.out.println(">>>>>>>>" + ThreadName + "任务终止");
        return ThreadName + "任务返回运行结果，当前任务时间" + "[" + time + "ms]";
	}
	
	public void run() {
		for ( int i = 0 ; i < 1000 ; i++  ) {
			System.out.println( this.ThreadName + " --- " + i);
		}
	}
	
	public static void main( String[] args ) throws InterruptedException, ExecutionException {
		int taskSize = 5;
		
		//创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		
		List<Future> list = new ArrayList<Future>();
		
		for ( int i = 0 ; i < taskSize ; i++ ) {
			Callable c = new ThDemo(i + " ");
			
			//执行任务并获取Future对象
			list.add(pool.submit(c));
		}
		
		pool.shutdown();
		
		for ( Future f : list ) {
			System.out.println(f.get().toString());
		}
	}

	
}
