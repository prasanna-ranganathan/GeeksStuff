import java.util.*;
import java.io.*;

class DeleteDup<T> {
  public Node<T> head;
  public Node<T> secondhalf;
  public int N;

  public static class Node<T> {
    public Node<T> next;
    public T item;
    
    public Node(T item) {
      this.next = null;
      this.item = item;
    }
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
//Sorted Method 1 (eg. 1->1->2->2->3  return 1->2->3)
  public Node<T> deleteDup(Node<T> node) {
    if(node == null || node.next == null)
      return node;
    Node<T> prev = node;
    Node<T> p = node;
    while(p.next !=  null) {
      p = p.next;
      if(p.item == prev.item) {
        prev.next = p.next;
        p.next = null;
        p = prev;
      }
      else
        prev = p;
    }
    return node;
  }

  //Sorted Method 2 (eg. 1->2->3->3->4->4->5 return 1->2->5)
  public Node<T> deleteDup2(Node<T> node,T item) {
    if(node == null || node.next == null)
      return node;
    Node<T> fkhead = new Node<T>(item);
    fkhead.next = node;
    Node<T> prepre = fkhead;

    boolean preDel = false;
    Node<T> pre = node;
    Node<T> curr = node;
    while(curr.next != null) {
      curr = curr.next;
      if(curr.item == pre.item) {
        prepre.next = curr.next;
        curr = prepre;
        preDel = true;
      }else {
        pre = curr;
        if(!preDel) 
          prepre = prepre.next;
        preDel = false;
      }
    }
    return fkhead.next;
  }

  public static void main(String[] args) throws Exception {
    DeleteDup<Integer> list = new DeleteDup<Integer>();
    list.add(1);
    list.add(1);
    list.add(2);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(4);
    list.add(5);
    list.Print();
    //Method 1
    //Node<Integer> head = list.deleteDup(list.head);
    //Method 2
    Node<Integer> head = list.deleteDup2(list.head,0);
    list.Print();
  }
}
