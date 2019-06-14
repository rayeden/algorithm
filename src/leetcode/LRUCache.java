package leetcode;

import java.util.HashMap;

/**
 * @author xhtc
 * @createTime 2019/6/11
 * @description 用HashMap结构读取数据，链表结构修改数据
 */
class LRUCache {

    private HashMap<Integer, CacheNode> cache;

    private CacheNode head;
    private CacheNode tail;

    private Integer capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(isNodeExists(key)){
            moveNodeToHead(key);
            return cache.get(key).val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        CacheNode node = cache.get(key);
        if(node != null){
            moveNodeToHead(key);
            node.val = value;
        }else{
            node = new CacheNode(key, value);
            addNewNodeToCacheList(node);
        }
        cache.put(key, node);
    }

    private boolean isNodeExists(int key){
        return cache.get(key) != null;
    }

    public void addNewNodeToCacheList(CacheNode node){
        if(cache.size() >= capacity){
            eliminateLastNodeFromCache();
        }
        if(head == null || tail == null){
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void eliminateLastNodeFromCache(){
        if(null == tail){
            return;
        }
        cache.remove(tail.key);
        tail = tail.prev;
        if(null != tail){
            tail.next.prev = null;
            tail.next = null;
        }
    }

    public void moveNodeToHead(int key){
        CacheNode node = cache.get(key);
        if(null == node){
            return;
        }
        if(head == node){
            return;
        }else if(tail == node){
            tail = node.prev;
            tail.next = null;
            node.prev = null;
            node.next = head;
            head.prev = node;
        }else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(2));
        lruCache.put(1,1);
        lruCache.put(4,1);
        System.out.println(lruCache.get(2));

        String s = "123";
        System.out.println(s.charAt(2) == '3');
        s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.toString().charAt(3);
    }
}

class CacheNode{
    public Integer key;
    public Integer val;
    public CacheNode next;
    public CacheNode prev;
    public CacheNode(Integer key, Integer value){
        this.key = key;
        this.val = value;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
