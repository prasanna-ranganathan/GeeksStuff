import java.util.*;
import java.io.*;

class DeleteNode<T> {
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

  public int Size() {
    return N;
  }

  public void add(T item) {
    head = add(head,item);
    N++;
  }

  private Node<T> add(Node<T> node, T item) {
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
      System.out.print(current.getItem() +  "-->");
      current = current.getNext();
    }
    System.out.println("null");
  }

  public void deleteNode(Node<T> node) {
    Node<T> temp = node.next;
    node.item = temp.item;
    node.next = temp.next;
    temp.next = null;
  }

  public static void main(String[] args) throws Exception {
    DeleteNode<Integer> list = new DeleteNode<Integer>();
    list.add(1);
    list.add(4);
    list.add(2);
    list.add(3);
    list.add(5);
    list.Print();
    list.deleteNode(list.head.getNext().getNext());
    list.Print();
  }
}

