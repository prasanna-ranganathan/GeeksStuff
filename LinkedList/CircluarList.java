import java.util.*;
import java.io.*;

class CircularList<T> {
  public Node<T> head;
  public Node<T> first;
  public Node<T> last;
  public int N;

  private static class Node<T> {
    public Node<T> next;
    public T item;

    public Node(Node<T> next,T item) {
      this.next = next;
      this.item = item;
    }

    public Node(T item) {
      this.item = item;
      next = null;
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

  public boolean IsEmpty() {
    return head == null;
  }

  public int Size() {
    Node<T> curr = first.next;
    while(curr != head) {
      N++;
      curr = curr.next;
    }
    return N;
  }

  public void add(T item) {
    head = add(head,item);
  }

  private Node<T> add(Node<T> node,T item) {
    if(node == null) {
      first = node;
      last  = node;
    }else {
      Node<T> tail = last;
      last.next = node;
      node.next = first;
      last = node;
    }
    return first;
  }

  public void Print() {
    Node<T> curr = head;
    for(int i = -1; i< Size(); i++)
      System.out.print(curr.item + " ");
    curr = curr.next;
  }

  public static void main(String[] args) throws Exception {
    CircularList<Integer> list = new CircularList<Integer>();
    Scanner in  = new Scanner(System.in);
    int input = in.nextInt();
    for(int i = 0; i < input; i++)
      list.add(list.head,new Integer(i));
    list.Print();
  }
}

