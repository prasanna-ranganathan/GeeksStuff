import java.util.*;
import java.io.*;

class Count<T> {
  public Node<T> head;
  public int N;

  private static class Node<T> {
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
      this.next = next;
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
    Node<T> current = head;
    while(current != null) {
      System.out.print(current.getItem() + "-->");
      current = current.next;
    }
    System.out.println("null");
  }

  public int count(Node<T> node,T key) {
    Node<T> current = node;
    int count = 0;
    while(current != null) {
      if(current.item == key)
        count++;
      current = current.next;
    }
    return count;
  }

  public static void main(String[] args) throws Exception {
    Count<Integer> list = new Count<Integer>();
    list.add(1);
    list.add(2);
    list.add(1);
    list.add(1);
    list.add(3);
    list.add(2);
    list.Print();
    Integer x = 1;
    System.out.println("Count Value: " + list.count(list.head,x));
  }
}

