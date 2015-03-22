import java.util.*;
import java.io.*;

class DoubleLinkedListNode {
  public int key;
  public int val;
  public DoubleLinkedListNode pre;
  public DoubleLinkedListNode next;

  public DoubleLinkedListNode(int key,int value) {
    val = value;
    this.key = key;
  }

}

class LRUCache {
  private HashMap<Integer,DoubleLinkedListNode> map = new HashMap<Integer,DoubleLinkedListNode>();
  private DoubleLinkedListNode head;
  private DoubleLinkedListNode end;
  private int capacity;
  private int len;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    len = 0;
  }

  public int get(int key) {
    if(map.containsKey(key)) {
      DoubleLinkedListNode latest = map.get(key);
      removeNode(latest);
      setHead(latest);
      return latest.val;
    }else {
      return -1;
    }
  }

  public void removeNode(DoubleLinkedListNode node) {
    DoubleLinkedListNode curr = node;
    DoubleLinkedListNode pre  = curr.pre;
    DoubleLinkedListNode post = curr.next;

    if(pre != null) {
      pre.next = post;
    }else {
      head = post;
    }

    if(post != null) {
      post.pre = pre;
    }else {
      end = pre;
    }
  }

  public void setHead(DoubleLinkedListNode node) {
    node.next = head;
    node.pre  = null;
    if(head != null) {
      head.pre = node;
    }

    head = node;
    if(end == null) 
      end = node;
  }

  public void set(int key,int value) {
    if(map.containsKey(key)) {
      DoubleLinkedListNode oldvalue = map.get(key);
      oldvalue.val = value;
      removeNode(oldvalue);
      setHead(oldvalue);
    }else {
      DoubleLinkedListNode newNode = new DoubleLinkedListNode(key,value);
      if(len < capacity) {
        setHead(newNode);
        map.put(key,newNode);
        len++;
      }else {
        map.remove(end.key);
        end = end.pre;
        if(end != null) {
          end.next = null;
        }
        setHead(newNode);
        map.put(key,newNode);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    LRUCache lru = new LRUCache(5);
    lru.set(1,1);
    lru.set(2,2);
    lru.set(3,3);
    lru.set(4,4);
    lru.set(5,5);
    int val = lru.get(1);
    System.out.println(val + " ");
    lru.set(6,6);
    val = lru.get(6);
    System.out.println(val + " " );
  }
}


