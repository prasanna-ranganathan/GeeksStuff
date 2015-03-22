import java.util.*;
import java.io.*;

class PrintReverse<T> {
  public Node<T> head;
  public int N;

  private static class Node<T> { 
    public Node<T> next;
    public T item;

    public Node(Node<T> next, T item) {
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

  public void PrintReverse(Node<T> node) {
    if(node == null)
      return;
    PrintReverse(node.next);
    System.out.print(node.item + "-->" );
  }

  public static void main(String[] args) throws Exception {
    PrintReverse<String> list = new PrintReverse<String>();
    list.add("Mumbai");
    list.add("Pune");
    list.add("Nagpur");
    list.add("Bandra");
    list.add("Dhadhar");
    list.Print();
    list.PrintReverse(list.head);
    System.out.println("null");
  }
}

