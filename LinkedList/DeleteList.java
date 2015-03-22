import java.util.*;
import java.io.*;

class DeleteList<T> {
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

    public void setNext(Node<T> node) {
      this.next = node;
    }
  }

  public int Size() {
    return N;
  }

  public void add(T item) {
    head = add(head,item);
    N++;
  }

  public Node<T> add(Node<T> node,T item) {
    if(node  == null)
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

  public void Deletelist(Node<T> node) {
    Node<T> cur = node;
    Node<T> temp;

    while(cur != null) {
      temp = cur.next;
      cur = null;
      cur = temp;
    }
    head = null;
  }

  public static void main(String[] args) throws Exception {
    DeleteList<String> list = new DeleteList<String>();
    list.add("chennai");
    list.add("Mumbai");
    list.add("Banglore");
    list.add("Hyderabad");
    list.add("Kochi");
    list.Print();
    list.Deletelist(list.head);
    list.Print();
  }
}
