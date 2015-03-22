import java.util.*;
import java.io.*;

class LinkedListNode {
  public int val;
  public LinkedListNode next;
  public LinkedListNode(int x) {
    val = x;
    next = null;
  }
}

class RemoveDupUnsorted {
  public LinkedListNode head;

  public void Print() {
    LinkedListNode curr  = head;
    while(curr != null) {
      System.out.print(curr.val + "-->");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public void DeleteDups(LinkedListNode node) {
    if(head == null)
      return;

    LinkedListNode curr = node;
    while(curr != null) {
      LinkedListNode runner = curr;
      while(runner.next != null) {
        if(runner.next.val == curr.val) {
          LinkedListNode dup = runner.next;
          runner.next = runner.next.next;
          dup.next = null;
        }
        else
          runner = runner.next;
      }
      curr = curr.next;
    }
  }

  public void RemoveDupHash(LinkedListNode node) {
    HashMap<Comparable,Integer>  map = new HashMap<Comparable,Integer>();
    LinkedListNode prev = node;
    LinkedListNode curr = node.next;
    map.put(node.val,1);
    while(curr != null) {
      if(map.containsKey(curr.val)) {
        prev.next = curr.next;
        curr = curr.next;
      }else {
        map.put(curr.val,1);
        prev = prev.next;
        curr = curr.next;
      }
    }
  }

  public void add(int d) {
    LinkedListNode n = new LinkedListNode(d);
    if(this.head == null) 
      this.head = n;
    else {
      n.next = head;
      head = n;
    }
  }

  public static void main(String[] args) throws Exception {
    RemoveDupUnsorted list = new RemoveDupUnsorted();
    list.add(12);
    list.add(11);
    list.add(12);
    list.add(12);
    list.add(41);
    list.add(43);
    list.add(21);
    list.Print();
 // list.DeleteDups(list.head);
    list.RemoveDupHash(list.head);
    list.Print();
  }
}
