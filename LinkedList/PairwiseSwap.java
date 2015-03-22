import java.util.*;
import java.io.*;

class PairwiseSwap<T> {
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

  public void PairWiseSwap(Node<T> node) {

    while(node != null && node.next != null) {
      temp = node.next;
      T x = node.item;
      node.item = temp.item;
      temp.item = x;
      node = temp.next;
    }
  }

  public static void main(String[] args) throws Exception {
    PairwiseSwap<Integer> list = new PairwiseSwap<Integer>();
    for(int i = 0; i<10; i++)
        list.add(i);
    list.Print();
    list.PairWiseSwap(list.head);
    list.Print();
  }
}

