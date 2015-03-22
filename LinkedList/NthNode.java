import java.util.*;
import java.io.*;

class NthNode<T> {
  public Node<T> head;
  public int N;
  private static class Node<T> {
    public T item;
    public Node<T> next;

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
    Node<T> current  = head;
    while(current != null) {
      System.out.print(current.getItem() + "-->");
      current = current.getNext();
    }
    System.out.println("null");
  }

  public Node<T> GetNth(Node<T> head,int index) {
    Node<T> current = head;
    int count = 0;

    while(current != null) {
      if(count == index)
        return current;
      count++;
      current = current.getNext();
    }
    return null;
  }

  public static void main(String[] args) throws Exception {
    NthNode<String> list = new NthNode<String>();
    list.add("TamilNadu");
    list.add("Pune");
    list.add("Kerla");
    list.add("Kochi");
    list.add("Jammu");
    list.Print();
    Node<String> Nth = list.GetNth(list.head,3);
    System.out.println("Get Nth: " + Nth.getItem());
  }
}
