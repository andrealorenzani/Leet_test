package name.lorenzani.andrea.leet.metaprep._20250510.lrucache;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {

    CacheNode head = null;
    CacheNode tail = null;
    int capacity;
    int curr;
    HashMap<Integer, CacheNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        curr = 0;
    }

    public int get(int key) {
        CacheNode hit = cache.get(key);
        if(hit==null) return -1;
        moveToHead(hit);
        return head.value;
    }

    private CacheNode moveToHead(CacheNode node) {
        if(node==head) return head;
        if(node==tail) {
            tail = tail.prev;
            tail.connect(null);
        }
        node.delete();
        node.prev = node;
        node.connect(head);
        head = node;
        return node;
    }

    public void put(int key, int value) {
        CacheNode insert = new CacheNode(key, value, head, null);
        if(head==null){
            head = insert;
            tail = insert;
            insert.prev=insert;
            cache.put(key, insert);
        }
        else if(cache.containsKey(key)) {
            moveToHead(cache.get(key));
            cache.get(key).value=value;
        }
        else {
            insert.connect(head);
            head = insert;
            cache.put(key, insert);
            if(cache.size()>capacity){
                System.out.println("Removing "+tail.key);
                cache.remove(tail.key);
                tail.prev.connect(null);
                tail = tail.prev;
            }
        }
    }

    private void print(CacheNode start) {
        StringBuffer sb = new StringBuffer("[");
        while(start!=null&&start.next!=start){
            sb.append("(").append(start.key).append(",").append(start.value).append(")");
            start = start.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}

class CacheNode {
    int key;
    int value;
    CacheNode next;
    CacheNode prev;
    public CacheNode(int key, int val, CacheNode prev, CacheNode next){
        this.key = key;
        this.value=val;
        this.next=next;
        this.prev=prev;
    }
    public void delete() {
        if(prev != this && prev != null) this.prev.next = this.next;
        if(next != null) this.next.prev = this.prev;
    }
    public void connect(CacheNode nextNode) {
        if(nextNode != null) nextNode.prev = this;
        if(nextNode != this) this.next = nextNode;
    }
}