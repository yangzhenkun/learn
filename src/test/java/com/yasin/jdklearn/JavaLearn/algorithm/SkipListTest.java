package com.yasin.jdklearn.JavaLearn.algorithm;

import com.yasin.algorithm.SkipList;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2018-12-07 18:18
 */
public class SkipListTest {


    @Test
    public void sdd() {
        SkipList<String> list = new SkipList<>(1024);
        for (int i = 0; i < 50; i++) {
            list.set((i * 2) + 1, String.valueOf((i * 2) + 1));
        }

        for (int i = 0; i < 50; i++) {
            list.set((i * 2), String.valueOf((i * 2)));
        }

        /**
         * test add\get
         */
        for (int i = 0; i < 100; i++) {
            System.out.println(list.get(i));
        }

        System.out.println(list.toString());
        /**
         *test remove
         */
        for (int i = 99; i >= 0; i--) {
            System.out.println(list.remove(i));
            for (int j = 0; j < i; j++) {
                String v = list.get(j);
                if (StringUtils.isBlank(v)) {
                    System.out.println("error！删除" + i + "节点后，" + j + "的数据也没有了");
                }
                continue;
            }
        }

        System.out.println("是否为空:" + list.isEmpty());

        System.out.println(list.toString());


        for (int i = 0; i < 50; i++) {
            list.set((i * 2) + 1, String.valueOf((i * 2) + 1));
        }

        for (int i = 0; i < 50; i++) {
            list.set((i * 2), String.valueOf((i * 2)));
        }

        /**
         *test remove
         */
        for (int i = 0; i < 100; i++) {
            System.out.println(list.remove(i));
            for (int j = i + 1; j < 100; j++) {
                String v = list.get(j);
                if (StringUtils.isBlank(v)) {
                    System.out.println("error！删除" + i + "节点后，" + j + "的数据也没有了");
                }
                continue;
            }
        }

        System.out.println("是否为空:" + list.isEmpty());

        System.out.println(list.toString());

    }


}
