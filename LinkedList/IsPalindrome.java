import java.util.*;
import java.io.*;

class IsPalindrome<T> {
  public Node<T> head;
  public Node<T> secondhalf;
  public int N;

  public static class Node<T> {
    public Node<T> next;
    public T item;

    public Node(Node<T> next,T item) {
      this.next = next;
      this.item = item;
    }

    public T getItem() {
      return item;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(Node<T> next) {
      this.next =  next;
    }
  }

  public int Size() {
    return N;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void add(T item) {
    head = add(head,item);
  N++;
  }

  private Node<T> add(Node<T> node,T item) {
    if(node == null)
      return new Node<T>(null,item);
    else if(node.getNext() == null)
      node.setNext(new Node<T>(null,item));
    else
      add(node.getNext(),item);
    return node;
  }

  public void Print() {
    Node<T> current  = head;
    while(current != null) {
      System.out.print(current.getItem() + "-->");
      current = current.next;
    }
    System.out.println("null");
  }

  public boolean ispalindrome(Node<T> node) {
    Node<T> slow = node,fast = node;
    Node<T> prev_slow = node;
    Node<T> midnode = null;
    boolean res = true;

    if(node != null && node.next != null) {
      
      while(fast != null && fast.next != null) {
        fast = fast.next.next;
        prev_slow = slow;
        slow = slow.next;
      }

      if(fast != null) {
        midnode = slow;
        slow = slow.next;
      }

      secondhalf = slow;
      prev_slow.next = null;
      reverse(secondhalf);
      res = compareList(head,secondhalf);

      reverse(secondhalf);
      if(midnode != null) {
        prev_slow.next = midnode;
        midnode.next = secondhalf;
      }
      else prev_slow.next = secondhalf;
    }
    return res;
  }

  private void reverse(Node<T> node1) {
    Node<T> prev = null;
    Node<T> curr = node1;
    Node<T> temp;

    while(curr != null) {
      temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    node1 = prev;
  }

  private boolean compareList(Node<T> head1,Node<T> head2) {
    Node<T> temp1 = head1;
    Node<T> temp2 = head2;

    while(temp1 != null && temp2 != null) {
      if(temp1.item == temp2.item) {
        temp1 = temp1.next;
        temp2 = temp2.next;
      }
      else
        return false;
    }

    if(temp1 == null && temp2 == null) 
      return true;

    return false;
  }

  public static void main(String[] args) throws Exception {
    IsPalindrome<Integer> list = new IsPalindrome<Integer>();
    list.add(1);
    list.add(2);
    list.add(2);
    list.Print();
    System.out.println(list.ispalindrome(list.head));
  }
}

