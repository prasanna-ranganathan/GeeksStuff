import java.util.*;
import java.io.*;

class ListNode {
      int val;
      ListNode  next;
      public ListNode(int x) {
        val = x;
        next = null;
      }
  }

public class DeleteDup2 {
  public static ListNode deleteDup(ListNode head) {
    if(head == null || head.next == null)
      return head;
    ListNode fkhead = new ListNode(0);
    fkhead.next = head;
    ListNode prepre = fkhead;

    boolean preDel = false;
    ListNode pre = head;
    ListNode curr = head;
    while(curr.next != null) {
      curr = curr.next;
      if(curr.val == pre.val) {
        prepre.next = curr.next;
        curr = prepre;
        preDel = true;
      }else {
        pre = curr;
        if(!preDel)
          prepre = prepre.next;
        preDel = false;
      }
    }
    return fkhead.next;
  }

  public static void Print(ListNode head) {
    ListNode curr = head;
    while(curr != null){
      System.out.print(curr.val + "-->");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) throws Exception {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(3);
    ListNode n5 = new ListNode(4);
    ListNode n6 = new ListNode(4);
    ListNode n7 = new ListNode(5);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;

    n1 = deleteDup(n1);
    Print(n1);
  }
}




