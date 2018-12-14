package com.yasin.algorithm;

import lombok.Data;

/**
 * @author yangzhenkun
 * @create 2018-12-07 18:10
 */
@Data
public class SkipList<T> {

    private int cap = 65536;//2^16
    private int maxLevel = 8;
    private double p = 0.25;

    public SkipList(int cap) {

        this.cap = cap;
        this.maxLevel = maxLevel(cap);
    }

    public SkipList() {
    }

    public T get(int key){

        return null;
    }

    public boolean set(int key,T value){

        return false;
    }

    public boolean remove(int key){

        return false;
    }


    /**
     * 计算
     *
     * @param cap
     * @return
     */
    private int maxLevel(int cap) {

        double level = Math.log(cap) / Math.log((1 / p));

        return (int) Math.ceil(level);
    }


    private class SkipNode<T> {


    }

}
