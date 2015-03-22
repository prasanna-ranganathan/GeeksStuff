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

class InterSectionList {
  public static ListNode Intersection(ListNode head1,ListNode head2) {
    ListNode n1 = head1;
    ListNode n2 = head2;

    if(n1 == null || n2 == null)
      return null;

    int len1 = 0,len2 = 0;
    while(n1 != null) {
      len1++;
      n1 = n1.next;
    }

    while(n2 != null) {
      len2++;
      n2 = n2.next;
    }

    int diff = 0;
    n1 = head1;
    n2 = head2;
    if(len1 > len2) {
      diff = len1 - len2;
      int i = 0;
      while(i < diff) {
        n1 = n1.next;
        i++;
      }
    }else {
      diff = len2 - len1;
      int i = 0;
      while(i < diff) {
        n2 = n2.next;
        i++;
      }
    }

    while(n1 != null && n2 != null) {
      if(n1.val == n2.val) 
          return n1;
      n1 = n1.next;
      n2 = n2.next;
    }
    return null;
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
    ListNode n4 = new ListNode(5);
    ListNode n5 = new ListNode(6);

    n1.next = n2;

    n3.next = n4;
    n4.next = n5;

    ListNode n6 = new ListNode(9);
    ListNode n7 = new ListNode(8);
    ListNode n8 = new ListNode(7);
    ListNode n9 = new ListNode(1);

    n6.next = n7;
    n7.next = n8;
    n8.next = n9;

    n2.next = n6;
    n5.next = n6;

    ListNode X = Intersection(n1,n3);
    System.out.println(X.val);
  }
}

