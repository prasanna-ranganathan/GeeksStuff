import java.util.*;
import java.io.*;

class ReverseList<T> {
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
  //Iterative
  public void Reverse(Node<T> node) {
    Node<T> prev = null;
    Node<T> current = node;
    Node<T> temp;

    while(current != null) {
      temp = current.next;
      current.next = prev;
      prev = current;
      current = temp;
    }
    head = prev;
  }
  //Recursive
  public void ReverseRec(Node<T> node) {
    if(node != null)
      head = Reverse(null,node);
  }

  private Node<T> Reverse(Node<T>  prev,Node<T> curr) {
    Node<T> secondElem = curr.next;
    curr.next = prev;
    return (secondElem == null) ? curr : Reverse(curr,secondElem);
  }

  public static void main(String[] args) throws Exception {
    ReverseList<Integer> list = new ReverseList<Integer>();
    for(int i = 1; i<=10; i++)
      list.add(i);
    list.Print();
    list.Reverse(list.head);
    list.Print();
    list.ReverseRec(list.head);
    list.Print();
  }
}
