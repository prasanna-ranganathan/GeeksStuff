import java.util.*;
import java.io.*;

class ListNode {
  int val;
  ListNode next;
  public ListNode(int x) {
    val = x;
    next = null;
  }
}

public class MergeSortList {
  public static ListNode mergesort(ListNode head) {
    if(head == null || head.next == null)
      return head;

    int count = 0;
    ListNode p1 = head;
    while(p1 != null) {
      count++;
      p1 = p1.next;
    }

    int middle = count / 2;

    ListNode l = head,r = null;
    ListNode p2 = head;
    int counthalf = 0;
    while(p2 != null) {
      counthalf++;
      ListNode next = p2.next;
      if(counthalf == middle) {
        p2.next = null;
        r = next;
      }
      p2 = next;
    }
    ListNode h1 = mergesort(l);
    ListNode h2 = mergesort(r);

    ListNode merged = merge(h1,h2);
    return merged;
  }
  public static ListNode merge(ListNode l,ListNode r) {
    ListNode p1 = l;
    ListNode p2 = r;
    ListNode fkhead = new ListNode(10);
    ListNode pNew = fkhead;
    while(p1 != null || p2 != null) {
        if(p1 == null) {
          pNew.next = new ListNode(p2.val);
          p2 = p2.next;
          pNew = pNew.next;
        }else if(p2 == null) {
          pNew.next = new ListNode(p1.val);
          p1 = p1.next;
          pNew = pNew.next;
        }else {
          if(p1.val > p2.val)  {
            pNew.next = new ListNode(p2.val);
            p2 = p2.next;
            pNew = pNew.next;
          }else if(p1.val == p2.val) {
            pNew.next = new ListNode(p2.val);
            pNew.next.next = new ListNode(p1.val);
            pNew = pNew.next.next;
            p1 = p1.next;
            p2 = p2.next;
          }else {
            pNew.next = new ListNode(p1.val);
            p1 = p1.next;
            pNew =  pNew.next;
          }
        }
    }
    return fkhead.next;
  }

  public static void Print(ListNode head) {
    ListNode curr = head;
    while(curr != null) {
      System.out.print(curr.val + "-->");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) throws Exception {
    ListNode n1 = new ListNode(2);
    ListNode n2 = new ListNode(3);
    ListNode n3 = new ListNode(4);
    ListNode n4 = new ListNode(3);
    ListNode n5 = new ListNode(1);
    ListNode n6 = new ListNode(5);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;

    n1 = mergesort(n1);
    Print(n1);
  }
}




