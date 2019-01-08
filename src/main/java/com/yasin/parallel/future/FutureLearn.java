package com.yasin.parallel.future;

import com.alibaba.fastjson.JSON;
import com.yasin.common.ThreadPoolManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 线程阻塞获取返回值
 *
 * @author yangzhenkun
 * @create 2018-12-12 17:33
 */
public class FutureLearn {


    @Test
    public void future() {


        ThreadPoolExecutor pool = ThreadPoolManager.createThreadPoolExecutor("CarSummaryLocal", 32, 64, 2048);
        CompletionService<List<String>> cs = new ExecutorCompletionService<List<String>>(pool);
        cs.submit(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {

                List<String> data = new ArrayList<>();
                data.add("1");
                TimeUnit.SECONDS.sleep(10);
                return data;
            }
        });


        try {
            System.out.println(JSON.toJSONString(cs.take().get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void set() {

        Set<String> set = new HashSet();

        set.add("1");
        set.add("1");


        List<String> data = set.stream().collect(Collectors.toList());

        System.out.println(data.size());


    }


}
