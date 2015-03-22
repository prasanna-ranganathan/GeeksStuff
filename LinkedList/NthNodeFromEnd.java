import java.util.*;
import java.io.*;

class NthNodeFromEnd<T> {
  public Node<T> head;
  public int N;
  public static int i;

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
      System.out.print(current.getItem() + "-->");
      current = current.getNext();
    }
    System.out.println("null");
  }

  //Method 1
  public void NthNodeFromEnd(Node<T> node,int n) {
    int len = 0;
    Node<T> temp = node;

    //Calucate the length of the list
    while(temp != null) {
      temp = temp.next;
      len++;
    }

    if(len < n)
      return;

    temp = node;
    //Get the (len-n+1) from beggining.
    for(int i = 1; i < len - n + 1; i++) 
      temp = temp.next;

    System.out.println("NthNode From End: " + temp.item);

    return;
  }
  //Method 1 Recursive
  public void PrintNthFromLast(Node<T> node,int n) {
    i = 0;
    if(node == null)
      return;
    PrintNthFromLast(node.next,n);
    if(++i == n)
      System.out.println("NthNode From Last: " + node.item);
  }

  //Method 2
  public void PrintNthFromEnd(Node<T> node,int n) {
    Node<T>  _main = node;
    Node<T>  _ref =  node;
    int count = 0;

    if(node != null) {
      while(count < n) {
        if(_ref == null) {
          System.out.println("Greater than No of Node" + n);
          return;
        }
        _ref = _ref.next;
        count++;
      }

      while(_ref != null) {
        _main = _main.next;
        _ref  = _ref.next;
      }
      System.out.println("Nth Node From ENd: " + _main.item + " " + n);
    }
  }

  public static void main(String[] args) throws Exception {
    NthNodeFromEnd<Integer> list = new NthNodeFromEnd<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    for(Integer i = 6; i <=10; i++)
      list.add(i);
    list.Print();
    list.NthNodeFromEnd(list.head,4);
    list.PrintNthFromLast(list.head,7);
    list.PrintNthFromEnd(list.head,5);
  }
}


