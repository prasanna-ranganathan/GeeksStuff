import java.util.*;
import java.io.*;
import java.lang.*;
class PrintCharacters {
  public static void print(String s,String[] strings) {
    HashMap<Character,Boolean> map = new HashMap<Character,Boolean>();
    for(char c : s.toCharArray())
      map.put(c,true);
    
    int size = map.size();
    int count = 0;
    boolean flag  = false;
    for(int i = 0 ; i < strings.length; i++) {
      count = 0;
      for(int j = 0;j < strings[i].length(); j++) {
         if(map.containsKey(strings[i].charAt(j))) {
              count++;
              
         map.put(strings[i].charAt(j),false);
         }
      }
      if(count == size)
        System.out.println(strings[i]);
      
      for(char c : s.toCharArray())
      map.put(c,true);
    }
  }
    
  public static void main(String[] args) throws Exception {
    String[] a = {"geeksforgeeks","unsorted","sunday","just","sss"};
    print("sun",a);
  }
}


