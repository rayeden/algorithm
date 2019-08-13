package leetcode;

import java.util.*;

/**
 * @author Sesame
 * @createTime 2019/7/21
 * @description
 */
public class LFUCache {

    //["LFUCache","put","put","get","put","get","get","put","get","get","get"]
    //[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]

    //["LFUCache","put","get"]
    //[[0],[0,0],[0]]

    //["LFUCache","put","put","get","put","put","get"]
    //[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]

    //["LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
    //[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]

    private static String operate = "\"put\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"put\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\",\"get\",\"put\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"get\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"get\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\",\"put\",\"get\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"put\",\"put\",\"put\"";

    private static String data = "10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26";

    //["LFUCache","put","put","put","put","get"]
    //[[2],[1,1],[2,2],[1,3],[3,1],[2]]

    public static void main(String[] args) {

//        LFUCache cache = new LFUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.put(1, 3);
//        cache.put(3, 1);
//        cache.get(2);
//        System.out.println("get 2 :" + cache.get(2));

        LFUCache cache = new LFUCache(10);

        String[] ops = operate.split(",");
        String[] datas = data.split("],\\[");

        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("\"put\"")) {
                String d = datas[i];
                String[] ds = d.split(",");
                cache.put(Integer.valueOf(ds[0]), Integer.valueOf(ds[1]));
            } else if (ops[i].equals("\"get\"")) {
                if (datas[i].equals("12")) {
                    System.out.println("here");
                }
                System.out.println(datas[i] + " " + cache.get(Integer.valueOf(datas[i])));
            }
        }

//        System.out.println(Arrays.toString(ops));
//        System.out.println(Arrays.toString(datas));
//        System.out.println(ops.length + " " + datas.length);
//

//        LFUCache cache = new LFUCache(2);
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

//        LFUCache cache = new LFUCache(0);
//        cache.put(0, 0);
//        cache.get(0);

//        LFUCache cache = new LFUCache(2);
//        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(2));
//        cache.put(1, 1);
//        cache.put(4, 1);
//        System.out.println(cache.get(2));
    }

    private TreeMap<Integer, Deque<Node>> listMap;

    private Map<Integer, Node> keyMap;

    private int capacity;

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

    public LFUCache(int capacity) {
        listMap = new TreeMap<>();
        keyMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = keyMap.get(key);
        if (node == null) {
            System.out.println("get node: key = " + key + ", result = -1");
            printListMap();

            return -1;
        } else {
            int freq = node.freq;
            Deque<Node> deque = listMap.get(freq);
            deque.remove(node);
            if (deque.isEmpty()) {
                listMap.remove(freq);
            }
            Deque<Node> addDeque = listMap.get(freq + 1);
            node.freq = freq + 1;
            if (null == addDeque) {
                addDeque = new LinkedList<>();
                addDeque.addFirst(node);
            } else {
                addDeque.addFirst(node);
            }
            listMap.put(freq + 1, addDeque);
            keyMap.put(key, node);

            System.out.println("get node: key = " + key + ", result = " + node.value);
            printListMap();

            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = keyMap.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (keyMap.size() == capacity) {
                Map.Entry<Integer, Deque<Node>> minFreqEntry = listMap.firstEntry();
                if (null != minFreqEntry) {
                    Deque<Node> lastDeque = minFreqEntry.getValue();
                    Node lastNode = lastDeque.pollLast();
                    keyMap.remove(lastNode.key);
                } else {
                    return;
                }
            }
            Deque<Node> deque = listMap.get(node.freq);
            if (null == deque) {
                deque = new LinkedList<>();
            }
            deque.addFirst(node);
            keyMap.put(key, node);
            listMap.put(node.freq, deque);
        } else {
            node.value = value;
            Deque<Node> deque = listMap.get(node.freq);
            if (null == deque) {
                System.out.println("error");
                return;
            }
            deque.remove(node);
            Deque<Node> addDeque = listMap.get(node.freq + 1);
            if(addDeque == null){
                addDeque = new LinkedList<>();
            }
            addDeque.addFirst(node);
            keyMap.put(key, node);
            listMap.put(node.freq, deque);
            listMap.put(node.freq + 1, addDeque);
        }


//        deque.remove(node);
//        deque.addFirst(node);
//        listMap.put(freq, deque);

        System.out.println("put node: key = " + key + ", value = " + value);
        printListMap();
    }

    private void freqUpNode(Node node) {
        int freq = node.freq;
        Deque<Node> deque = listMap.get(freq);
        if (null == deque) {
            deque = new LinkedList<>();
        } else {
            deque.remove(node);
        }
        if (deque.isEmpty()) {
            listMap.remove(freq);
        }
        Deque<Node> upDeque = listMap.get(freq + 1);
        node.freq = freq + 1;
        if (null == upDeque) {
            upDeque = new LinkedList<>();
        }
        upDeque.addFirst(node);
        listMap.put(freq + 1, upDeque);
    }


    private void printListMap() {
        for (Map.Entry<Integer, Deque<Node>> entry : listMap.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            Deque<Node> deque = entry.getValue();
            for (Node n : deque) {
                System.out.print(n.key + ", ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}

