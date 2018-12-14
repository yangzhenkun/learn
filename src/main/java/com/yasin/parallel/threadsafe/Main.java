package com.yasin.parallel.threadsafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;


/**
 * 测试SimpleDateFormat线程不安全
 * @author yangzhenkun
 *
 */
public class Main {

	@Test
	public void testSimpleDateFormatThreadSafe() throws ParseException, InterruptedException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		ThreadLocal<SimpleDateFormat> safe = new ThreadLocal() {

			@Override
			protected Object initialValue() {
				return new SimpleDateFormat("yyyy-MM-dd");	
			}
			
		};
		
		
		long now = System.currentTimeMillis();
		long one = 1000 * 60 * 60 * 24;
		long[] times = { now, now - one, now - one * 2, now - one * 3, now - one * 4, now - one * 5, now - one * 6,
				now - one * 7, now - one * 8, now - one * 9, now - one * 10, now - one * 11, now - one * 12,
				now - one * 13, now - one * 14, now - one * 15, now - one * 16, now - one * 17, now - one * 18,
				now - one * 19, now - one * 20, now - one * 21, now - one * 22, now - one * 23, now - one * 24,
				now - one * 25, now - one * 26, now - one * 27, now - one * 28, now - one * 29 };

		ExecutorService pool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 30; i++) {
			pool.execute(new Work(safe.get(),times[i]));//线程安全
			pool.execute(new Work(sdf, times[i]));//线程不安全
			// System.out.println(sdf.format(new Date(times[i])));//串行执行
			
		}

		 Thread.sleep(10000);

	}

	public class Work implements Runnable {

		SimpleDateFormat sdf;
		long date;

		public Work(SimpleDateFormat sdf, long date) {
			this.sdf = sdf;
			this.date = date;
		}

		@Override
		public void run() {
			System.out.println(sdf.format(new Date(date)));
		}

	}

}
