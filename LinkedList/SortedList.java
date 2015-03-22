import java.util.*;
import java.io.*;

class SortedList<T> {
  public Node<T> head;
  public int N;

  private static class Node<T> {
    public Node<T> next;
    public Comparable item;

    public Node(Node<T> next,Comparable item) {
      this.next = next;
      this.item = item;
    }

    public Comparable getItem() {
      return item;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }
  }

  public boolean IsEmpty() {
    return N == 0;
  }

  public int Size() {
    return N;
  }

  public void add(Comparable item) {
    head = add(head,item);
    N++;
  }

  private Node<T> add(Node<T> node,Comparable item) {
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

  public void sortedInsert(Node<T> node,Node<T> new_node) {
    Node<T> curr;
    if(node  == null || node.item.compareTo(new_node.item) > 0) {
      new_node.next = node;
      node = new_node;
    }
    else {
      curr = node;
      while(curr.next != null && curr.next.item.compareTo(new_node.item) < 0 ){
        curr = curr.next;
      }
      new_node.next = curr.next;
      curr.next = new_node;
    }
  }

  public static void main(String[] args) throws Exception {
    SortedList<Integer> list = new SortedList<Integer>();
    for(Integer i = 0 ;i <= 10; i+= 2)
      list.add(i);
    list.Print();

    Node<Integer> new_node = new Node<Integer>(null,5);
    list.sortedInsert(list.head,new_node);
    list.Print();
  }
}
