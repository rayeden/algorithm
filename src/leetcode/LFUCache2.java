package leetcode;

import java.util.*;

/**
 * @author Sesame
 * @createTime 2019/7/22
 * @description
 */
public class LFUCache2 {

    public static void main(String[] args) {
//
//        LFUCache2 cache = new LFUCache2(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.put(1, 3);
//        cache.put(3, 1);
//        cache.get(2);
//        System.out.println("get 2 :" + cache.get(2));


//        System.out.println(Arrays.toString(ops));
//        System.out.println(Arrays.toString(datas));
//        System.out.println(ops.length + " " + datas.length);
//

//        LFUCache2 cache = new LFUCache2(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));
//        cache.put(3, 3);
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));
//        cache.put(4, 4);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

//        LFUCache2 cache = new LFUCache2(0);
//        cache.put(0, 0);
//        cache.get(0);

        LFUCache2 cache = new LFUCache2(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println(cache.get(2));
    }

    class Node {
        int key;
        int value;
        int freq;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private TreeMap<Integer, Deque<Node>> listMap;

    private HashMap<Integer, Node> keyMap;

    private int capacity;

    public LFUCache2(int capacity) {
        this.capacity = capacity;
        this.listMap = new TreeMap<>();
        this.keyMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = keyMap.get(key);
        if (null == node) {
            return -1;
        } else {
            int freq = node.freq;
            Deque<Node> deque = listMap.get(freq);
            if (null == deque) {
                return -1;
            }
            deque.remove(node);
            if (deque.size() == 0) {
                listMap.remove(freq);
            } else {
                listMap.put(freq, deque);
            }
            node.freq += 1;
            Deque<Node> upDeque = listMap.get(node.freq);
            if (null == upDeque) {
                upDeque = new LinkedList<>();
            }
            upDeque.addFirst(node);
            listMap.put(node.freq, upDeque);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = keyMap.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (keyMap.size() == capacity) {
                Map.Entry<Integer, Deque<Node>> firstQueEntry = listMap.firstEntry();
                if (null == firstQueEntry) {
                    return;
                } else {
                    Deque<Node> firstQue = firstQueEntry.getValue();
                    Node lastNode = firstQue.pollLast();
                    keyMap.remove(lastNode.key);
                    if (firstQue.size() == 0) {
                        listMap.remove(firstQueEntry.getKey());
                    } else {
                        listMap.put(firstQueEntry.getKey(), firstQue);
                    }
                }
            }
        } else {
            node.value = value;
            Deque<Node> deque = listMap.get(node.freq);
            deque.remove(node);
            if (deque.size() == 0) {
                listMap.remove(node.freq);
            }
            node.freq += 1;
        }
        Deque<Node> deque = listMap.get(node.freq);
        if (null == deque) {
            deque = new LinkedList<>();
        }
        deque.addFirst(node);
        listMap.put(node.freq, deque);
        keyMap.put(node.key, node);
    }

}
