import java.util.*;
import java.io.*; 

class DetectLoop<T> {
  public Node<T> head;
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

  public boolean detectloop(Node<T> node) {
    Node<T> slow = node;
    Node<T> fast = node;

    while(slow != null && fast != null && fast.next != null)  {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) {
        System.out.println("Found Loop");
        return true;
      }
    }
  return false;
  }

  public static void main(String[] args) throws Exception {
    DetectLoop<Integer> list = new DetectLoop<Integer>();
    for(int i = 1; i<=10; i++)
      list.add(i);
    list.Print();
    list.head.next.next.next.next = list.head;
    System.out.println(list.detectloop(list.head));
  }
}
