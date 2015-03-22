import java.util.*;

public class Queue<Item> implements Iterable<Item> {
  private int N;
  private Node<Item> first;
  private Node<Item> last;

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  public Queue() {
    first = null;
    last = null;
    N = 0;
  }

  public boolean isEmpty() {
    return  first ==  null;
  }

  public int Size() {
    return N;
  }

  public void enqueue(Item item) {
    Node<Item> oldlast = last;
    last = new  Node<Item>();
    last.item = item;
    last.next = null;
    if(isEmpty()) first = last;
    else          oldlast.next = last;
    N++;
  }

  public Item peek() {
    if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
    return first.item;
  }

  public Item dequeue() {
    if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
    Item item = first.item;
    first = first.next;
    if(isEmpty()) last = null;
    N--;
    return item;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(Item item : this) 
      sb.append(item + " ");
    return sb.toString();
  }

  public Iterator<Item> iterator() {
    return new ListIterator<Item>(first);
  }

  /*  private class ListIterator<Item> implements Iterator<Item> {
      private Node<Item> current;

      public ListIterator(Node<Item> first) {
      current = first;
      }

      public boolean hasnext() { return current != null; }
      public void remove() { throw new UnsupportedOperationException(); }

      public Item item() {
      if(!hasnext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
      }
      }*/

  private class ListIterator<Item> implements Iterator<Item> {
    private Node<Item> current;

    public ListIterator(Node<Item> first) {
      current = first;
    }

    public boolean hasNext()  { return current != null;                     }
    public void remove()      { throw new UnsupportedOperationException();  }

    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next; 
      return item;
    }
  }
}
