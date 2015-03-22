import java.util.*;
import java.io.*;

class MiddleNode<T> {
  public Node<T> head;
  public int N;

  private static class Node<T> {
    private Node<T> next;
    private T item;

    public Node(T item,Node<T> next) {
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
      this.next = next;
    }
  }

  public void add(T item) {
    head = add(head,item);
    N++;
  }

  private Node<T> add(Node<T> node,T item) {
    if(node == null)
      return new Node<T>(item,null);
    else if(node.getNext() == null)
      node.setNext(new Node<T>(item,null));
    else
      add(node.getNext(),item);
    return node;
  }

  public void Print() {
    Node<T> current = head;
    while(current != null) {
      System.out.print(current.getItem() + "-->");
      current = current.getNext();
    }
    System.out.println("null");
  }

  public void PrintMiddle(Node<T>  node) {
    Node<T> fast = node;
    Node<T> slow = node;

    if(node != null) {
      while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      System.out.println("Middle Element: " + slow.item);
    }
  }

  public static void main(String[] args) throws Exception {
    MiddleNode<Integer> list = new MiddleNode<Integer>();
    list.add(1);
    list.add(4);
    list.add(1);
    list.add(12);
    list.add(1);
    list.Print();
    list.PrintMiddle(list.head);
  }
}


