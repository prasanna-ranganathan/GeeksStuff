import java.util.*;
import java.io.*;

class MoveToFront<T> {
  private Node<T> head;
  private Node<T> temp;
  private int N;

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
    Node<T> curr = head;
    while(curr != null) {
      System.out.print(curr.getItem() + "-->");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public void MovetoFront(Node<T> node) {
    if(node == null || node.next == null)
      return;

    Node<T> secLast = null;
    Node<T> last = node;

    while(last.next != null) {
      secLast = last;
      last = last.next;
    }

    secLast.next = null;
    last.next = head;

    head = last;
  }

  public static void main(String[] args) throws Exception {
    MoveToFront<Integer> list = new MoveToFront<Integer>();
    for(int i =1; i<5; i++)
      list.add(i);
    list.Print();
    list.MovetoFront(list.head);
    list.Print();
  }
}

