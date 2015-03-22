import java.util.Map.Entry;
import java.util.*;
import java.io.*;
import java.lang.*;

class FirstNonRepeating {
  //Method1
  public static char getFirstNonRepatingchar(String s) {
    HashMap<Character,Integer> map = new HashMap<>();
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(map.containsKey(c)){
        map.put(c,map.get(c)+1);
      }else {
        map.put(c,1);
      }
    }

    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(map.get(c) == 1) {
        return c;
      }
    }
    throw new RuntimeException("Undefined Behaviour");
  }
  //Method 2
  public static char getFirstNonRepeatingchar2(String s) {
    Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
    for(char c: s.toCharArray())
     map.put(c,map.containsKey(c) ? map.get(c) + 1 : 1);

    for(Entry<Character,Integer> entry : map.entrySet()){
      if(entry.getValue() == 1)
        return entry.getKey();
    }
    throw new RuntimeException("Undefined Behaviour");
  }

  public static char getRepeatingcharusingSet(String s) {
    Set<Character> set = new HashSet<Character>();
    List<Character> list = new ArrayList<Character>();
    for(int i = 0; i < s.length(); i++) {
     char c = s.charAt(i);
     if(set.contains(c))
       continue;
     if(list.contains(c)){
       list.remove((Character)c);
       set.add(c);
     }else {
       list.add(c);
      }
    }
     return list.get(0);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(getFirstNonRepeatingchar2(br.readLine()));
    System.out.println(getRepeatingcharusingSet(br.readLine()));
  }
}
