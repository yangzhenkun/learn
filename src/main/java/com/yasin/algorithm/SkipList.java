package com.yasin.algorithm;

/**
 * @author yangzhenkun
 * @create 2018-12-07 18:10
 */
public class SkipList<T> {

    private static final int DEFAULT_CAP = 65536;
    private int cap = 0;//2^16
    private int maxLevel = 8;
    private final double p = 0.25;
    private SkipNode head;


    public SkipList(int cap) {
        this.cap = cap;
        this.maxLevel = maxLevel(cap);

        head = new SkipNode();
        head.key = null;
        head.value = null;
        head.forward = new SkipNode[maxLevel];

    }

    public SkipList() {
        this(DEFAULT_CAP);
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public T get(Integer key) {

        SkipNode cur = head;

        for (int l = maxLevel - 1; l >= 0; l--) {

            if (cur.forward[l] == null) {
                continue;
            }

            while (cur.forward[l] != null && key > cur.forward[l].key) {
                cur = cur.forward[l];
            }

            if (cur.forward[l] != null && key == cur.forward[l].key) {
                return (T) cur.forward[l].value;
            }
        }
        return null;
    }

    public boolean set(int key, T value) {
        SkipNode newNode = initNode(key, value);
        int newNodeMaxLevel = newNode.forward.length;
        SkipNode cur = head;
        SkipNode[] update = new SkipNode[newNodeMaxLevel];//记录更新的节点

        /**
         * 遍历找到插入的节点，并记录下需要更新层指针的节点
         */
        for (int l = maxLevel - 1; l >= 0; l--) {

            if (cur.forward[l] == null) {
                if (l < newNodeMaxLevel) {
                    update[l] = cur;
                }
                continue;
            }

            while (cur.forward[l] != null && key > cur.forward[l].key) {
                cur = cur.forward[l];
            }

            if (cur.forward[l] != null && key == cur.forward[l].key) {
                return false;
            }
            if (l < newNodeMaxLevel) {
                update[l] = cur;
            }
        }
        /**
         * 执行插入更新操作
         */
        for (int l = newNodeMaxLevel - 1; l >= 0; l--) {
            newNode.forward[l] = update[l].forward[l];
            update[l].forward[l] = newNode;
        }


        return true;
    }

    public boolean remove(int key) {
        SkipNode cur = head;
        SkipNode[] update = new SkipNode[maxLevel];
        SkipNode delete = null;

        /**
         * 遍历找到要删除的节点，并记录下需要更新层指针的节点
         */
        for (int l = maxLevel - 1; l >= 0; l--) {

            if (cur.forward[l] == null) {
                continue;
            }

            while (cur.forward[l] != null && key > cur.forward[l].key) {
                cur = cur.forward[l];
            }

            if (cur.forward[l] != null && key == cur.forward[l].key) {
                delete = cur.forward[l];
                update[l] = cur;
            }

        }
        /**
         * 执行删除更新操作
         */
        if (delete == null) {
            return false;
        }

        for (int l = delete.forward.length - 1; l >= 0; l--) {
            update[l].forward[l] = delete.forward[l];
            delete.forward[l] = null;//help gc
        }

        return true;
    }

    public boolean isEmpty() {
        return head.forward[0] == null ? true : false;
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

    /**
     * 随机获得节点层数
     *
     * @return
     */
    private int randomLevel() {
        int level = 1;
        while (Math.random() <= p && level < maxLevel) {
            level++;
        }
        return level;
    }

    /**
     * 初始化节点
     *
     * @param key
     * @param value
     * @return
     */
    private SkipNode initNode(Integer key, T value) {

        SkipNode node = new SkipNode();
        node.key = key;
        node.value = value;
        int level = randomLevel();
        node.forward = new SkipNode[level];
        return node;
    }


    private class SkipNode<T> {

        SkipNode[] forward;
        Integer key;
        T value;
    }

    @Override
    public String toString() {
        SkipNode cur = null;
        StringBuilder sb = new StringBuilder();
        for (int l = maxLevel - 1; l >= 0; l--) {
            sb.append("第").append(l).append("层:");
            cur = head.forward[l];

            while (cur != null) {
                sb.append(cur.key).append(";");

                cur = cur.forward[l];
            }

            sb.append("\n");
        }

        return sb.toString();
    }


}
