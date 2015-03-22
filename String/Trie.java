import java.util.*;
import java.io.*;

class Trie<Value> {
  private static int R = 256;
  private Node root;
  private int N;

  private static class Node {
    private Object val;
    private Node[] next = new Node[R];
  }
  
  public Trie() { }

  public void put(String key,Value val) {
    if(val == null)
      delete(key);
    else
      root = put(root,key,val,0);
  }

  private Node put(Node x,String key,Value val,int d) {
    if(x ==  null) x = new Node();
    if(d == key.length()) {
      if(x.val == null) N++;
      x.val = val;
      return x;
    }
    char c = key.charAt(d);
    x.next[c] = put(x.next[c],key,val,d+1);
    return x;
  }

  public Value get(String key) {
    Node x = get(root,key,0);
    if(x == null) return null;
    return (Value) x.val;
  }

  private Node  get(Node x,String key,int d) {
    if(x == null) return null;
    if(d == key.length()) return x;
    char c = key.charAt(d);
    return get(x.next[c],key,d+1);
  }

  public boolean contains(String key) {
    return get(key) != null;
  }

  public int Size() {
    return N;
  }

  public boolean isEmpty() {
    return Size() == 0;
  }

  public void delete(String key) {
    root = delete(root,key,0);
  }

  private Node delete(Node x, String key,int d) {
    if(x == null) return null;
    if(d == key.length()) x.val = null;
    else {
      char c = key.charAt(d);
      x.next[c] = delete(x.next[c],key,d+1);
    }
    if(x.val != null) return x;

    for(char c = 0; c < R; c++)
      if(x.next[c] != null) return x;
    return null;
  }
  
  public Iterable<String> keys() {
    return KeysWithPrefix("");
  }

  public Iterable<String> KeysWithPrefix(String prefix) {
    Queue<String> results = new Queue<String>();
    Node x = get(root,prefix,0);
    collect(x,new StringBuilder(prefix),results);
    return results;
  }

  private void collect(Node x,StringBuilder sb,Queue<String> q) {
    if(x ==  null) return;
    if(x.val != null) q.enqueue(sb.toString());
    for(char c = 0; c < R; c++) {
        sb.append(c);
        collect(x.next[c],sb,q);
        sb.deleteCharAt(sb.length()-1);
    }
  }

  public Iterable<String> KeysWithMatch(String pattern) {
    Queue<String> results = new Queue<String>();
    collect(root,new StringBuilder(),pattern,results);
    return results;
  }

  private void collect(Node x,StringBuilder sb,String pattern,Queue<String> q) {
    if(x == null) return;
    int d = sb.length();
    if(d == pattern.length()  && x.val != null)
      q.enqueue(sb.toString());
    if(d == pattern.length())
      return;
    char c = pattern.charAt(d);
    if(c == '.') {
      for(char ch = 0; ch < R; ch++) {
        sb.append(ch);
        collect(x.next[ch],sb,pattern,q);
        sb.deleteCharAt(sb.length() - 1);
      }
    }else {
      sb.append(c);
      collect(x.next[c],sb,pattern,q);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public String LongestPrefix(String key) {
    int length = LongestPrefix(root,key,0,0);
    return key.substring(0,length);
  }

  private int LongestPrefix(Node x,String key,int d,int length) {
    if(x == null) return length;
    if( x.val != null ) length = d;
    if(d == key.length()) return length;
    char c = key.charAt(d);
    return LongestPrefix(x.next[c],key,d+1,length);
  }
  
  public static void main(String[] args) throws IOException {
    Scanner in  = new Scanner(System.in);
    Trie<Integer> st = new Trie<Integer>();
    int N = in.nextInt();
    for(int i = 0; i <= N; i++) {
      String key = in.nextLine();
      st.put(key,i);
    }

    if(st.Size() < 100) {
      System.out.println("Keys (  )");
      for(String key : st.keys())
        System.out.println(key + " " + st.get(key));
    }
  }
}
  
